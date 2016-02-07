package com.adargasystems.flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CoffeeShop {
	private final List<Order> orders = new CopyOnWriteArrayList<Order>();
	private final Menu menu = new Menu();

	void takeOrder(String flavourName, int table) {
		CoffeeFlavour flavour = menu.lookup(flavourName);
		Order order = new Order(table, flavour);
		orders.add(order);
	}

	void service() {
		for (Order order : orders) {
			order.serve();
			orders.remove(order);
		}
	}

	String report() {
		return "\ntotal CoffeeFlavour objects made: "
				+ menu.totalCoffeeFlavoursMade();
	}
}