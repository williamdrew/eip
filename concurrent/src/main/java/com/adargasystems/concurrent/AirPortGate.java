/**
 * 
 */
package com.adargasystems.concurrent;

/**
 * 
 *
 * @author $Author: $
 * @version $Id: AirPortGate.java 984 2015-07-21 19:56:13Z  $
 *
 */
final public class AirPortGate implements WayPoint {

	final private Double latitude;
	final private Double longitude;
	final private Double altitude;
	
	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @param altitude
	 * @return
	 */
	public static WayPoint valueOf(final Double latitude,
			final Double longitude, final Double altitude) {
		return new AirPortGate(latitude, longitude, altitude);
	}

	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @param altitude
	 */
	private AirPortGate(final Double latitude, final Double longitude,
			final Double altitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}

	/* (non-Javadoc)
	 * @see com.adargasystems.concurrent.WayPoint#getLatitude()
	 */
	public Double getLatitude() {
		return latitude;
	}

	/* (non-Javadoc)
	 * @see com.adargasystems.concurrent.WayPoint#getLongitude()
	 */
	public Double getLongitude() {
		return longitude;
	}

	/* (non-Javadoc)
	 * @see com.adargasystems.concurrent.WayPoint#getAltitude()
	 */
	public Double getAltitude() {
		return altitude;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AirportGate [latitude=" + latitude + ", longitude=" + longitude
				+ ", altitude=" + altitude + "]";
	}
}
