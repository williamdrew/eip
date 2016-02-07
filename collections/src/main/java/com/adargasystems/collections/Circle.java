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
public class Circle extends AbstractShape {


	public Circle(final Color c, final String name) {
		super(c, name);
	}

	public void draw() {
		System.out.println("Drawing a circle");
	}


}
