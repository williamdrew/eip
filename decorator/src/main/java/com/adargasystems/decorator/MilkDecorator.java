/**
 * 
 */
package com.adargasystems.decorator;

/**
 * @author William
 *
 */
public class MilkDecorator extends CoffeeDecorator {

	/**
	 * @param decoratedCoffee
	 */
	public MilkDecorator(Coffee decoratedCoffee) {
		super(decoratedCoffee);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.decorator.AbstractCoffeeDecorator#getCost()
	 */
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return super.getCost() + 0.2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.decorator.AbstractCoffeeDecorator#getIngredients()
	 */
	@Override
	public String getIngredients() {
		// TODO Auto-generated method stub
		return "Milk, " + super.getIngredients();
	}

}
