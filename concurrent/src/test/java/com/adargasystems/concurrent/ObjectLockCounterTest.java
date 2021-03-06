/*
 *
 */
package com.adargasystems.concurrent;

import junit.framework.TestCase;

/**
 * 
 *
 * @author $Author: $
 * @id $Id: ObjectLockCounterTest.java 977 2015-07-07 14:42:39Z  $
 *
 */
public class ObjectLockCounterTest extends TestCase {

	/**
	 * 
	 *
	 * @author $Author: $
	 * @id $Id: ObjectLockCounterTest.java 977 2015-07-07 14:42:39Z  $
	 *
	 */
	private class IncrementThread implements Runnable {

		private ObjectLockCounter olc;
		private boolean stillRunning = true;
		private String name;

		/**
		 * 
		 * @param olc
		 */
		public IncrementThread(final String name, ObjectLockCounter olc) {
			this.olc = olc;
			this.name = name;
		}

		/**
		 * 
		 */
		public void run() {

			while (stillRunning) {

				while (olc.getFirstCounter() < olc.getSecondCounter()) {
					olc.incrementFirst();
					// olc.incrementSecond();
					System.out.println(name + " = " + olc.getFirstCounter());
				}
				stop();
			}
		}

		/**
		 * 
		 */
		public void stop() {
			stillRunning = false;
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Test method for
	 * {@link com.adargasystems.concurrent.ObjectLockCounter#ObjectLock(int, int)}
	 * .
	 */
	public void testObjectLock() {

		ObjectLockCounter l = new ObjectLockCounter("Counter", 0, 100);

		Thread t1 = new Thread(new IncrementThread("First thread", l));
		t1.start();

		Thread t2 = new Thread(new IncrementThread("Second thread", l));
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException ie) {
			// nothing here
		}

	}

}
