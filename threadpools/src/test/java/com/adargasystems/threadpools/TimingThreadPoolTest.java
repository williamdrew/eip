/*
 *
 */
package com.adargasystems.threadpools;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class TimingThreadPoolTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.adargasystems.threadpools.BlockingQueueThreadPoolExecutor#TimingThreadPool(int, int, long, java.util.concurrent.TimeUnit, java.util.concurrent.BlockingQueue)}
	 * .
	 */
	public void testTimingThreadPool() {

		Callable<Boolean> blockingTimeOutCallback = new Callable<Boolean>() {

			public Boolean call() throws Exception {
				// will probably want to put logic here to determine when to
				// return false and have the tasked rejected
				// for now it always returns true and queues the task for
				// execution
				System.out.println("Keep trying!!!");
				return true;
			}

		};

		BlockingQueueThreadPoolExecutor immutableTimingThreadPoolExecutor =
				new BlockingQueueThreadPoolExecutor(5, // pool size
						5, // queue size
						5, // keep alive time
						TimeUnit.SECONDS, // time unit
						5, // max blocking time
						TimeUnit.SECONDS, // blocking time unit
						blockingTimeOutCallback);

		assertNotNull(immutableTimingThreadPoolExecutor);

		for (int idx = 0; idx < 20; idx++) {
			try {
				immutableTimingThreadPoolExecutor.submit(new TimingTestThread(
						"Thread - " + (idx + 1)));
			} catch (RejectedExecutionException je) {
				System.out.println("Rejected!!!");
			}
		}

		try {
			System.out.println("Awaiting termination...");
			if (immutableTimingThreadPoolExecutor.await(30, TimeUnit.SECONDS)) {
				System.out.println("All submitted tasks completed successfully");
			}

			immutableTimingThreadPoolExecutor.shutdown();

			if (immutableTimingThreadPoolExecutor.awaitTermination(30,
					TimeUnit.SECONDS)) {
				System.out.println("ThreadPoolExecutor terminated successfully");
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
