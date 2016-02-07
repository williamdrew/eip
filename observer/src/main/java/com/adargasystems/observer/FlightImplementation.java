/*
 *
 */
package com.adargasystems.observer;

/**
 *
 * @author $Author $
 * @id $Id $
 *
 */
public class FlightImplementation implements Flight {

	private boolean stillFlying = true;
	private final String name;
	private final FlightManager flightManager;

	/**
	 * 
	 */
	public FlightImplementation(final FlightManager flightManager,
			final String name) {
		this.flightManager = flightManager;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		while (stillFlying) {

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.observer.Flight#step()
	 */
	public void step() {

	}

	/**
	 * 
	 */
	public void stop() {
		stillFlying = false;
		Thread.currentThread().interrupt();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.observer.Flight#getName()
	 */
	public String getName() {
		return name;
	}

}
