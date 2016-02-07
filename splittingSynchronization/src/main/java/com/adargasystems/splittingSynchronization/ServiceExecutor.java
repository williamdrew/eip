/*
 *
 */
package com.adargasystems.splittingSynchronization;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class ServiceExecutor<T extends Service> implements Callable<ServiceResult> {

	private Service service;
	
	public ServiceExecutor(final T s){	
		this.service = s;
	}
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	public ServiceResult call() throws Exception {
		System.out.println("In call().");
		Thread.sleep(ThreadLocalRandom.current().nextInt(1, 10) * 1000);
		return service.perform();
	}

}
