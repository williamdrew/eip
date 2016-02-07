/*
 *
 */
package com.adargasystems.observer;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public interface Flight extends Runnable {

	void step();

	void stop();

	/**
	 * @return
	 */
	String getName();
}
