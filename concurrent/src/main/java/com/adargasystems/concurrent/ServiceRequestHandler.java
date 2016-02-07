/*
 *
 */
package com.adargasystems.concurrent;

import java.util.concurrent.Callable;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class ServiceRequestHandler<T extends ServiceRequest> implements
		Callable<ServiceResponse> {

	private ServiceRequest serviceRequest;

	public ServiceRequestHandler(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public ServiceResponse call() throws Exception {
		return serviceRequest.handle();
	}

}
