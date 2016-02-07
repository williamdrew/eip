/*
 *
 */
package com.adargasystems.concurrent;

import java.util.Random;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class LogonServiceRequest implements ServiceRequest {
	
	private static Random r = new Random();
	
	@Override
	public ServiceResponse handle(){
		return new ServiceResponse(){
			public boolean isSuccess() throws InterruptedException{
				System.out.println("Handling LogonServiceRequest...");
				Thread.sleep(r.nextInt(10)*1000);
				return true;
			}
		};
	}


}
