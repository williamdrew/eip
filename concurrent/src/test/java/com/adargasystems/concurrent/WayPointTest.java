/*
 *
 */
package com.adargasystems.concurrent;

import java.awt.Polygon;

import junit.framework.TestCase;

/**
 *
 * @author $Author: $
 * @version $Revision: 984 $ $Id: WayPointTest.java 984 2015-07-21 19:56:13Z  $
 *
 */
public class WayPointTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.adargasystems.concurrent.AirPortGate#valueOf(java.lang.Double, java.lang.Double, java.lang.Double)}
	 * .
	 */
	public void testCreateInstance() {
		WayPoint wp = AirPortGate.valueOf(1.0, 2.0, 3.0);
		assertNotNull(wp);

		System.out.println(wp);
		
		wp.isInPolygon(new Polygon());
	}

}
