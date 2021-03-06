/*
 *
 */
package com.adargasystems.observer;

import java.awt.Polygon;

/**
 *
 * @author $Author: $
 * @id $Id: Airspace.java 976 2015-07-07 14:41:33Z  $
 *
 */
public final class Airspace {

	private final Polygon polygon;

	private final double floor;
	private final double ceiling;

	public Airspace(final Polygon polygon, final double floor,
			final double ceiling) {

		this.polygon = polygon;
		this.floor = floor;
		this.ceiling = ceiling;
	}

	/**
	 * @return the polygon
	 */
	final public Polygon getPolygon() {
		return polygon;
	}

	/**
	 * @return the floor
	 */
	final public double getFloor() {
		return floor;
	}

	/**
	 * @return the ceiling
	 */
	final public double getCeiling() {
		return ceiling;
	}

}
