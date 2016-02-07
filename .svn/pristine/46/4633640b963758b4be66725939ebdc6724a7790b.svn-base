/**
 * 
 */
package com.adargasystems.decorator;

/**
 * @author William
 *
 */
public class CoffeeDecorator implements Coffee {

	protected Coffee decoratedCoffee;

	public CoffeeDecorator(final Coffee decoratedCoffee) {
		this.decoratedCoffee = decoratedCoffee;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.decorator.CoffeeDecorator#getCost()
	 */
	public double getCost() {
		return decoratedCoffee.getCost();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.decorator.CoffeeDecorator#getIngredients()
	 */
	public String getIngredients() {
		return decoratedCoffee.getIngredients();
	}

}
