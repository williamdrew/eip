/*
 *
 */
package com.adargasystems.concurrent;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class CyclicBarrierDemo {

	private CyclicBarrier cb;
	private int[] mainIntArray;
	private LocalDateTime localDate = LocalDateTime.now();

	private ZoneOffset offset = ZoneOffset.of("-05:00");
	private OffsetDateTime startTime = OffsetDateTime.of(localDate, offset);
	private String formattedString = new String();

	private ExecutorService es = Executors.newCachedThreadPool();
	private int numOfParties;
	private int timesRun = 0;

	private DateTimeFormatter format = DateTimeFormatter
			.ofPattern("MMM d yyyy  hh:mm:ss a");

	/**
	 * 
	 *
	 * @author $Author$
	 * @id $Id$
	 *
	 */
	private class CellAggragator implements Runnable {

		private CyclicBarrier cb;
		private CyclicBarrierDemo parent;
		private boolean stillRunning = true;
		private String name;

		public CellAggragator(final CyclicBarrierDemo parent,
				final CyclicBarrier cb, final String name) {

			this.cb = cb;
			this.parent = parent;
			this.name = name;
		}

		public void run() {

			try {

				while (stillRunning) {

					if (cb.isBroken()) {
						stillRunning = false;
					} else {
						System.out
								.println(name + " waiting for next iteration");
						cb.await();
					}
					// System.out.println(parent.getFormattedTime());
				}

			} catch (InterruptedException ie) {
				stillRunning = false;
				System.out.println("Interrupted exception.");
			} catch (BrokenBarrierException bbe) {
				stillRunning = false;
				System.out.println("BrokenBarrier exception.");
			}

			System.out.println("Thread " + name + " exiting...");
		}
	}

	/**
	 * 
	 * @param arraySize
	 */
	public CyclicBarrierDemo(int numOfParties) {

		this.numOfParties = numOfParties;

		cb = new CyclicBarrier(numOfParties, new Runnable() {

			public void run() {

				System.out.println("Barrier has been reached");

				timesRun++;

				if (timesRun > 4) {
					es.shutdownNow();
				} else {
					formattedString = LocalDateTime.now().plusSeconds(timesRun)
							.format(format);
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {

				}

				// System.out.println("Current time " + getFormattedTime());

			}
		});
	}

	/**
	 * @return
	 */
	public String getFormattedTime() {
		return formattedString;
	}

	public void start() {

		formattedString = startTime.format(format);

		System.out.println("Start time " + formattedString);

		for (int i = 0; i < numOfParties; i++) {
			es.execute(new CellAggragator(this, cb, new String("Thread "
					+ (i + 1))));
		}

		try {
			es.awaitTermination(60000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
