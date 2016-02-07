/*
 *
 */
package com.adargasystems.splittingSynchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import junit.framework.TestCase;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class ServiceExecutorTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.adargasystems.splittingSynchronization.ServiceExecutor#ServiceExecutor(com.adargasystems.splittingSynchronization.Service)}
	 * .
	 */
	public void testServiceExecutor() {

		ExecutorService threadPool = Executors.newFixedThreadPool(Runtime
				.getRuntime().availableProcessors());
		System.out.println(Runtime.getRuntime().availableProcessors()
				+ " processors on this machine.");

		List<ServiceExecutor<Service>> seList = new ArrayList<ServiceExecutor<Service>>();

		// Future<ServiceResult> c = executorService
		// .submit(new ServiceExecutor<Service>(new LoginService()));

		for (int ctr = 0; ctr < 10; ctr++) {
			seList.add(new ServiceExecutor<Service>(new LoginService()));
		}

		try {
			List<Future<ServiceResult>> srList = threadPool.invokeAll(seList);

			for (Future<ServiceResult> fr : srList) {
				ServiceResult sr = fr.get(10, TimeUnit.SECONDS);
				System.out.println(sr);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
