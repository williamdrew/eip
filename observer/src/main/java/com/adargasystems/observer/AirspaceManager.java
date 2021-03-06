/*
 *
 */
package com.adargasystems.observer;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author $Author: $
 * @id $Id: AirspaceManager.java 976 2015-07-07 14:41:33Z  $
 *
 */
public class AirspaceManager {

	public Map<String, SoftReference<Radar>> radars = new ConcurrentHashMap<String, SoftReference<Radar>>();

	public Map<String, SoftReference<? extends Aircraft>> aircrafts = new ConcurrentHashMap<String, SoftReference<? extends Aircraft>>();

	private ExecutorService executor = Executors.newFixedThreadPool(5);

	private CyclicBarrier cb = new CyclicBarrier(1);

	/**
	 * 
	 */
	public AirspaceManager() {

	}

	/**
	 * 
	 * @param ac
	 */
	public void addAircraft(final Aircraft ac) {
		if (null != ac) {
			aircrafts.put(ac.getName(), new SoftReference<Aircraft>(ac));
		}
	}

	/**
	 * 
	 * @param ac
	 */
	public void removeAircraft(final Aircraft ac) {
		if (null != ac) {
			aircrafts.remove(ac.getName());
		}
	}

	/**
	 * 
	 * @param radar
	 */
	public void addRadar(final Radar radar) {
		if (null != radar) {
			radars.put(radar.getName(), new SoftReference<Radar>(radar));
		}
	}

	/**
	 * 
	 * @param name
	 */
	public void removeRadar(final String name) {
		if (null != name) {
			radars.remove(name);
		}
	}

	/**
	 * 
	 * @param aircraft
	 */
	public void moveAircraft() {

		for (SoftReference<Radar> srRadar : radars.values()) {
			if (null != srRadar.get()) {
				for (SoftReference<? extends Aircraft> sfAircraft : aircrafts
						.values()) {
					Aircraft ac = sfAircraft.get();
					if (null != ac) {
						srRadar.get().observe(ac);
					}
				}
			}
		}
	}
}
