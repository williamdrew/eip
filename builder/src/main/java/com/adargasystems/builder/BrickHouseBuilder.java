package com.adargasystems.builder;

public class BrickHouseBuilder implements HouseBuilder {

	public House createHouse() {
		// TODO Auto-generated method stub
		return new BrickHouse();
	}

	public Roof createRoof() {
		// TODO Auto-generated method stub
		return new SlateRoof();
	}

	public Floor createFloor() {
		// TODO Auto-generated method stub
		return new WoodenFloor();
	}

	public Wall createWalls() {
		// TODO Auto-generated method stub
		return new BrickWall();
	}

}
