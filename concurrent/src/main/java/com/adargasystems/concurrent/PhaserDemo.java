/*
 *
 */
package com.adargasystems.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Phaser;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class PhaserDemo {

	public List<Thread> threads = Collections
			.synchronizedList(new ArrayList<Thread>());
	public List<PhaseRunnable> calculators = Collections
			.synchronizedList(new ArrayList<PhaseRunnable>());

	private int prevTotal = 0;

	public Phaser phaser = new Phaser(0) {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.concurrent.Phaser#onAdvance(int, int)
		 */
		@Override
		protected boolean onAdvance(int phase, int registeredParties) {

			Iterator<PhaseRunnable> iter = calculators.iterator();
			int grandTotal = 0;
			while (iter.hasNext()) {
				PhaseRunnable next = iter.next();
				grandTotal = grandTotal + next.getTotal();
			}
			System.out.println("Total [" + grandTotal + "] increased by ["
					+ (grandTotal - prevTotal) + "]");
			prevTotal = grandTotal;
			if (grandTotal > 1000) {
				System.out.println(phaser);
			}
			return (grandTotal > 1000);
		}

	};

	public PhaserDemo() {

		createRunnables(10);

	}

	/**
	 * 
	 * @param numberToCreate
	 */
	private void createRunnables(int numberToCreate) {

		for (int i = 1; i <= numberToCreate; i++) {
			PhaseRunnable pr = new PhaseRunnable(phaser, "Thread # " + i);
			calculators.add(pr);
			threads.add(new Thread(pr));
		}

	}

	/**
	 * 
	 */
	public void startThreads() {

		Iterator<Thread> i = threads.iterator();

		while (i.hasNext()) {
			i.next().start();
		}

		int phaseNumber = 0;

		while (phaseNumber != -1) {

			// System.out.println("Waiting for phase # [" + phaseNumber
			// + "] to complete.");
			phaseNumber = phaser.awaitAdvance(phaser.getPhase());

			if (phaser.isTerminated()) {
				break;
			}
		}

		phaser.forceTermination();
	}

	/**
	 * 
	 * @author $Author$
	 * @id $Id$
	 *
	 */
	private class PhaseRunnable implements Runnable {

		private Phaser phaser;
		private final String name;
		private Random r = new Random();
		private boolean stillRunning = true;
		private int total = 0;

		public PhaseRunnable(Phaser phaser, final String name) {
			this.phaser = phaser;
			this.name = name;
			phaser.register();
			// System.out.println("Name " + name + " Phaser " + phaser);
		}

		public void run() {

			int phaseNumber = 0;

			while (stillRunning) {

				try {
					if (!phaser.isTerminated()) {
						// System.out.println(name + " computing...");
						total = total + r.nextInt(10);
						Thread.sleep(1000);
						phaseNumber = phaser.arriveAndAwaitAdvance();
						if (-1 == phaseNumber) {
							System.out.println("Phase number = " + phaseNumber
									+ "]");
						}
					} else {
						// System.out.println("Phaser has been terminated.");
						stop();
					}
				} catch (InterruptedException e) {
					stop();
				}
			}

			System.out.println(name + " exiting...");

		}

		public void stop() {
			stillRunning = false;
		}

		public int getTotal() {
			return total;
		}
	}
}
