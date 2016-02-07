/*
 *
 */
package com.adargasystems.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class ServiceRequestProcessor {

	/**
	 * 
	 *
	 * @author $Author$
	 * @id $Id$
	 *
	 */
	private static class FutureServiceResponseProcessor implements Runnable {

		private BlockingQueue<Future<ServiceResponse>> lbq = new LinkedBlockingQueue<Future<ServiceResponse>>();
		private boolean stillRunning = true;
		private ExecutorService fsResponseES = Executors.newCachedThreadPool();

		public void add(final Future<ServiceResponse> future) {
			if (null != future) {
				lbq.add(future);

			}
		}

		@Override
		public void run() {

			System.out.println("Running ServiceRequestProcessor thread...");

			while (!Thread.currentThread().isInterrupted() && stillRunning) {
				try {
					Future<ServiceResponse> fsr = lbq
							.poll(10, TimeUnit.SECONDS);

					if (null != fsr) {
						fsResponseES.execute(new FutureQueryHandler(fsr));
					}

				} catch (InterruptedException ie) {
					stop();
				}
			}

		}

		public void stop() {
			fsResponseES.shutdown();
			System.out.println("Stopping ServiceRequestProcessor thread...");
			stillRunning = false;
			Thread.currentThread().interrupt();
		}

		/**
		 * 
		 *
		 * @author $Author$
		 * @id $Id$
		 *
		 */
		private class FutureQueryHandler implements Runnable {

			private Future<ServiceResponse> fsr;

			public FutureQueryHandler(Future<ServiceResponse> fsr) {
				this.fsr = fsr;
			}

			@Override
			public void run() {

				try {

					if (null != fsr) {
						try {
							ServiceResponse sr = fsr.get(60, TimeUnit.SECONDS);
							if (null != sr) {
								System.out.println("Request"
										+ (sr.isSuccess() ? " was successful"
												: " failed"));
							}
						} catch (ExecutionException ee) {
							System.out.println(ee.getLocalizedMessage());
						} catch (TimeoutException te) {
							System.out.println(te.getLocalizedMessage());
						}
					}
				} catch (InterruptedException ie) {
					System.out.println("Thread was interrrupted");
				}
			}

		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		FutureServiceResponseProcessor fsrp = new FutureServiceResponseProcessor();

		Thread t = new Thread(fsrp);
		t.start();

		ExecutorService es = Executors.newCachedThreadPool();

		for (int i = 0; i < 4; i++) {
			LogonServiceRequest lsr = new LogonServiceRequest();
			ServiceRequestHandler<ServiceRequest> srh = new ServiceRequestHandler<ServiceRequest>(
					lsr);

			Future<ServiceResponse> fsr = es.submit(srh);

			fsrp.add(fsr);
		}

		try {
			t.join(20000);
		} catch (InterruptedException ie) {

		}

		fsrp.stop();

		es.shutdownNow();

	}

}
