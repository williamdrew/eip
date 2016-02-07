/**
 * 
 */
package com.adargasystems.concurrent;

import junit.framework.TestCase;

/**
 * @author William
 *
 */
public class SimulatedCASTest extends TestCase {

	/**
	 * Test method for {@link com.adargasystems.concurrent.SimulatedCAS#compareAndSwap(int, int)}.
	 */
	public void testCompareAndSwap() {
		
		CasCounter cc1 = new CasCounter();
		
		cc1.increment();
		
		System.out.println("Value = [" + cc1.getValue() + "]");
		
	}

}
