/**
 * 
 */
package com.adargasystems.decorator;

/**
 * @author William
 *
 */
public class SprinkleDecorator extends CoffeeDecorator {

	public SprinkleDecorator(final Coffee coffeeDecorator) {
		super(coffeeDecorator);
	}

	public double getCost() {
		return super.getCost() + .70;
	}

	public String getIngredients() {
		return "Sprinkles, " + super.getIngredients();
	}
}
