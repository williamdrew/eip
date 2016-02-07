/*
 *
 */
package com.adargasystems.observer;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class FlightManager {

	private Map<String, SoftReference<Flight>> flights = new ConcurrentHashMap<String, SoftReference<Flight>>();

	private Phaser phaser = new Phaser();

	private ExecutorService executor = Executors.newCachedThreadPool();

	public FlightManager() {

	}

	public void addFlight(final Flight flight) {
		if (null != flight) {
			flights.put(flight.getName(), new SoftReference<Flight>(flight));
		}
	}

	public void start() {

		for (SoftReference<Flight> srFlight : flights.values()) {

			Flight flight = srFlight.get();

			if (null != flight) {
				executor.execute(flight);
			}
		}
	}

}
