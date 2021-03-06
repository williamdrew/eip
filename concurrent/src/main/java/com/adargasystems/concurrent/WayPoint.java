/*
 *
 */
package com.adargasystems.concurrent;

import java.awt.Polygon;

/**
 * 
 *
 * @author $Author: $
 * @id $Id: WayPoint.java 977 2015-07-07 14:42:39Z  $
 *
 */
public interface WayPoint {

	/**
	 * 
	 * @return
	 */
	Double getLatitude();

	/**
	 * 
	 * @return
	 */
	Double getLongitude();

	/**
	 * @return the altitude
	 */
	Double getAltitude();

	default boolean isInPolygon(final Polygon polygon) {
		return true;
	}

}