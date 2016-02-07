/**
 * 
 */
package com.adargasystems.decorator;

import junit.framework.TestCase;

/**
 * @author William
 *
 */
public class CoffeeDecoratorTest extends TestCase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.adargasystems.decorator.CoffeeDecorator#AbstractCoffeeDecorator(com.adargasystems.decorator.CoffeeDecorator)}
	 * .
	 */
	public void testAbstractCoffeeDecorator() {
		Coffee c = new RegularCoffee();

		System.out.println("Regular coffee : " + c.getCost() + " with "
				+ c.getIngredients());

		c = new MilkDecorator(new RegularCoffee());

		System.out.println("Milk decorated coffee : " + c.getCost() + " with "
				+ c.getIngredients());

		c = new WhipDecorator(new MilkDecorator(new RegularCoffee()));

		System.out.println("Whip and milk decorated coffee : " + c.getCost()
				+ " with " + c.getIngredients());
		
		c = new MilkDecorator(new WhipDecorator(new RegularCoffee()));

		System.out.println("Milk and whip decorated coffee : " + c.getCost()
				+ " with " + c.getIngredients());
		
		c = new SprinkleDecorator(new WhipDecorator(new MilkDecorator(new RegularCoffee())));
		
		System.out.println("Coffee with " + c.getIngredients() + " costs " + c.getCost());
	}

}
