/**
 * 
 */
package com.adargasystems.decorator;

/**
 * @author William
 *
 */
public class WhipDecorator extends CoffeeDecorator {

	public WhipDecorator(final Coffee coffeeDecorator) {
		super(coffeeDecorator);
	}

	public double getCost() {
		return super.getCost() + 0.10;
	}

	public String getIngredients() {
		return "Whip cream, " + super.getIngredients();
	}
}
