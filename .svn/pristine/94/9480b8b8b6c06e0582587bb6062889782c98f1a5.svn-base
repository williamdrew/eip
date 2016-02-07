package com.adargasystems.splittingSynchronization;

/**
 * 
 *
 * @author $Author$
 * @id $Id$
 *
 */
class AdjustableLocation {

	private double x = 0.0;
	private double y = 0.0;

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public AdjustableLocation(final double x, final double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @return
	 */
	public synchronized double x() {
		return x;
	}

	/**
	 * 
	 * @return
	 */
	public synchronized double y() {
		return y;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public synchronized void adjustLocation(final double x, final double y) {
		System.out.println("Adjusting location...");
		this.x = x;
		this.y = y;
	}

}