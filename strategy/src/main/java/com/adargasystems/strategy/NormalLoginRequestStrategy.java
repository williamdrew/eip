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
public class NormalLoginRequestStrategy implements ProcessRequestStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.strategy.ProcessRequestStrategy#perform()
	 */
	public boolean perform() {
		System.out.println("Normal login strategy");
		return false;
	}

}
