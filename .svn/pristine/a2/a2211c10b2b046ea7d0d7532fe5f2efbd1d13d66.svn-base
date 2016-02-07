/*
 *
 */
package com.adargasystems.observer;

import junit.framework.TestCase;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class AirspaceManagerTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.adargasystems.observer.AirspaceManager#AirspaceManager()}.
	 */
	public void testAirspaceManager() {

		AirspaceManager airspaceMgr = new AirspaceManager();

		airspaceMgr.addRadar(new Radar("TRACON"));
		airspaceMgr.addRadar(new Radar("Tower"));
		airspaceMgr.addRadar(new Radar("Enroute"));

		airspaceMgr.addAircraft(new FixedWing("DAL333"));
		airspaceMgr.addAircraft(new FixedWing("SW4202"));
		airspaceMgr.addAircraft(new RotaryWing("HUEY233"));
		airspaceMgr.addAircraft(new RotaryWing("GUNBOAT666"));
		
		airspaceMgr.moveAircraft();
		
		airspaceMgr.addRadar(new Radar("Ramp Tower"));
		airspaceMgr.moveAircraft();
	}

}
