/*
 *
 */
package com.adargasystems.concurrent;

/**
 * 
 *
 * @author $Author: $
 * @id $Id: ObjectLockCounter.java 977 2015-07-07 14:42:39Z  $
 *
 */
public class ObjectLockCounter {

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	private int firstCounter;
	private int secondCounter;
	private String name;

	public ObjectLockCounter(final String name, final int firstCounter,
			final int secondCounter) {
		this.name = name;
		this.firstCounter = firstCounter;
		this.secondCounter = secondCounter;
	}

	/**
	 * 
	 */
	public void incrementFirst() {
		synchronized (lock1) {
			firstCounter++;
		}
	}

	/**
	 * 
	 */
	public void incrementSecond() {
		synchronized (lock2) {
			secondCounter++;
		}
	}

	/**
	 * @return the lock1
	 */
	public Object getLock1() {
		return lock1;
	}

	/**
	 * @return the lock2
	 */
	public Object getLock2() {
		return lock2;
	}

	/**
	 * 
	 * @return
	 */
	public int getFirstCounter() {
		return firstCounter;
	}

	/**
	 * 
	 * @return
	 */
	public int getSecondCounter() {
		return secondCounter;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name = [" + name + "]");
		sb.append("Counter 1 = [" + firstCounter + "]");
		sb.append("Counter 2 = [" + secondCounter + "]");
		return sb.toString();
	}
}
