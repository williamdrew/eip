/*
 *
 */
package com.adargasystems.splittingSynchronization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
class GamePlayer implements Runnable {

	protected GamePlayer other;
	protected boolean myturn = false;
	private String name;

	private Collection<String> names = new CopyOnWriteArrayList<String>();

	public GamePlayer(final String name) {
		this.name = name;
	}

	// Double-check idiom for lazy initialization of instance fields.
	private volatile FieldType field;

	FieldType getField() {

		FieldType result = field;
		if (result == null) { // First check (no locking)
			synchronized (this) {
				result = field;
				if (result == null) // Second check (with locking)
					field = result = computeFieldValue();
			}
		}
		return result;
	}

	/**
	 * @return
	 */
	private FieldType computeFieldValue() {
		return new FieldType();
	}

	protected synchronized void setOther(final GamePlayer p) {
		other = p;
	}

	synchronized void giveTurn() {
		myturn = true;
		notify();
	}

	void releaseTurn() {
		GamePlayer p;

		synchronized (this) {
			myturn = false;
			p = other;
		}
		p.giveTurn();
	}

	synchronized void awaitTurn() throws InterruptedException {
		while (!myturn) {
			wait();
		}
	}

	void move() throws InterruptedException {
		System.out.println("Player " + name + " is moving...");
		Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10) * 1000);
	}

	/**
	 * @return Copy of the ArrayList of {@link #names}
	 */
	public synchronized Collection<String> getNames() {
		return new ArrayList<String>(names);
	}

	/**
	 * 
	 * @param name
	 */
	public synchronized void addName(final String name) {
		if (null != name) {
			names.add(name);
		}
	}

	/**
	 * 
	 * @param nameToRemove
	 * @return
	 */
	public synchronized boolean removeName(final String nameToRemove) {
		boolean removedName = false;

		if (null != nameToRemove) {
			removedName = names.remove(nameToRemove);
		}
		return removedName;
	}

	@Override
	public boolean equals(Object o) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		try {
			for (;;) {
				awaitTurn();
				move();
				releaseTurn();
			}
		} catch (InterruptedException ie) {
			System.out.println("Player [" + name + "] has been interrupted.");
		}
		System.out.println("Player [" + name + "] is terminating.");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GamePlayer one = new GamePlayer("One");
		GamePlayer two = new GamePlayer("Two");

		one.setOther(two);
		two.setOther(one);

		one.giveTurn();

		Thread t1 = new Thread(one);
		t1.start();
		Thread t2 = new Thread(two);
		t2.start();

		try {
			t2.join(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t1.interrupt();
		t2.interrupt();

	}
}
