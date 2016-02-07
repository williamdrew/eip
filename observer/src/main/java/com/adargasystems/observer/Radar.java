/*
 *
 */
package com.adargasystems.observer;

/**
 *
 * @author $Author: $
 * @id $Id: Radar.java 976 2015-07-07 14:41:33Z  $
 *
 */
public class Radar implements AirspaceObserver {

	private final String name;

	public Radar(final String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adargasystems.observer.AirspaceObserver#observe(com.adargasystems
	 * .observer.Aircraft)
	 */
	public void observe(Aircraft a) {
		System.out.println(getName() + " notification of aircraft [" + a + "]");

	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
}
