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
public class Rectangle extends AbstractShape {

	public Rectangle(final Color color, final String name){
		super(color, name);	
	}
	
	public void draw() {
		System.out.println("Drawing rectangle");
	}
	
}
