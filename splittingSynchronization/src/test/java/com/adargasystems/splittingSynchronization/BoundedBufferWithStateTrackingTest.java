/*
 *
 */
package com.adargasystems.splittingSynchronization;

import java.util.concurrent.ThreadLocalRandom;

import junit.framework.TestCase;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class BoundedBufferWithStateTrackingTest extends TestCase {

	public enum BUFFER_ACTION {
		PUT, TAKE;
	}

	/**
	 * Test method for
	 * {@link com.adargasystems.splittingSynchronization.BoundedBufferWithStateTracking#BoundedBufferWithStateTracking(int)}
	 * .
	 */
	public void testBoundedBufferWithStateTracking() {

		BoundedBufferWithStateTracking bbwst = new BoundedBufferWithStateTracking(
				10);

		Thread t1 = new Thread(
				new BoundedBufferThread(bbwst, BUFFER_ACTION.PUT));
		t1.start();
		Thread t2 = new Thread(new BoundedBufferThread(bbwst,
				BUFFER_ACTION.TAKE));
		t2.start();

		try {
			t1.join(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			t1.interrupt();
			t2.interrupt();
		}

		try {
			t1.join(10000);
			t2.join(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private class BoundedBufferThread implements Runnable {

		private BoundedBufferWithStateTracking buffer;
		private boolean stillRunning = true;
		private BUFFER_ACTION action;

		public BoundedBufferThread(BoundedBufferWithStateTracking buffer,
				final BUFFER_ACTION action) {
			this.buffer = buffer;
			this.action = action;
		}

		public void run() {

			System.out.println("In run()...");

			while (stillRunning) {

				Object bufferObj = new Object();

				try {
					switch (action) {

					case PUT: {

						System.out.println("Putting object into buffer...");
						buffer.put(bufferObj);
						break;
					}
					case TAKE: {
						System.out.println("Taking object from buffer...");
						buffer.take();
						break;
					}
					default:
						break;
					}

					Thread.sleep(ThreadLocalRandom.current().nextInt(0, 5) * 1000);

				} catch (InterruptedException e) {
					System.out.println("Thread interrupted");
					stop();
				}
			}

			System.out.println("Thread exiting...");

		}

		public void stop() {
			stillRunning = false;
		}

	}
}
