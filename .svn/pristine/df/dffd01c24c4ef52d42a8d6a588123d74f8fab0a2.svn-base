package com.adargasystems.builder;

import junit.framework.TestCase;

public class HouseContractorTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBuildHouse() {

		HouseContractor hc = new HouseContractor();

		hc.buildHouse(new BrickHouseBuilder());

		hc.buildHouse(new WoodenHouseBuilder());
	}

}
