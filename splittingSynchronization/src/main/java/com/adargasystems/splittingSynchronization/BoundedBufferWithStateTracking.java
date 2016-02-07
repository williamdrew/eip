/*
 *
 */
package com.adargasystems.splittingSynchronization;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
class BoundedBufferWithStateTracking {

	protected final Object[] array;
	protected int putPtr = 0;
	protected int takePtr = 0;
	protected int usedSlots = 0;

	public BoundedBufferWithStateTracking(final int capacity)
			throws IllegalArgumentException {

		if (capacity <= 0) {
			throw new IllegalArgumentException();
		}
		array = new Object[capacity];
	}

	public synchronized int size() {
		return usedSlots;
	}

	public int capacity() {
		return array.length;
	}

	public synchronized void put(final Object x) throws InterruptedException {

		while (usedSlots == array.length) {
			System.out.println("No slots available. Entering wait state.");
			wait();
		}

		array[putPtr] = x;

		putPtr = (putPtr + 1) % array.length;
		System.out.println("Put ptr = " + putPtr);

		if (usedSlots++ == 0) { // signal if empty
			notifyAll();
		}
	}

	public synchronized Object take() throws InterruptedException {

		while (usedSlots == 0) { // wait until something to take
			System.out.println("No objects available. Entering wait state.");
			wait();
		}

		Object x = array[takePtr];

		array[takePtr] = null;
		takePtr = (takePtr + 1) % array.length;
		System.out.println(" Take ptr = " + takePtr);

		if (usedSlots-- == array.length) {
			notifyAll(); // signal if was full
		}

		return x;
	}

}
