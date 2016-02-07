/*
 *
 */
package com.adargasystems.splittingSynchronization;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
class AdjustableDimension {

	private double width = 0.0;
	private double height = 0.0;

	public AdjustableDimension(final double width, final double height) {
		this.width = width;
		this.height = height;
	}

	public synchronized double getWidth() {
		return width;
	}

	public synchronized double getHeight() {
		return height;
	}

	public synchronized void adjustDimension(final double width,
			final double height) {
		System.out.println("Adjusting dimension...");
		this.width = width;
		this.height = height;
	}

}
