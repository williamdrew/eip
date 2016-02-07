/*
 *
 */
package com.adargasystems.collections;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public interface Shape extends Comparable<Shape> {

	public enum Color {
		RED, BLUE, GREEN;
	}

	public void draw();

	default public Color getColor() {
		return Color.RED;
	}

	String getName();
}
