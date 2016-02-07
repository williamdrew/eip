/*
 *
 */
package com.adargasystems.strategy;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class RevisedLoginRequestStrategy implements ProcessRequestStrategy {

	/* (non-Javadoc)
	 * @see com.adargasystems.strategy.ProcessRequestStrategy#perform()
	 */
	public boolean perform() {
		System.out.println("Revised login strategy");
		return false;
	}

}
