package com.adargasystems.builder;

public class HouseContractor {

	public House buildHouse(HouseBuilder houseBuilder) {

		House house = houseBuilder.createHouse();

		System.out.println("House : " + house.getName());

		house.setFloor(houseBuilder.createFloor());

		System.out.println("Floor : " + house.getFloor().getName());

		house.setWall(houseBuilder.createWalls());

		System.out.println("Walls : " + house.getWall().getName());

		house.setRoof(houseBuilder.createRoof());

		System.out.println("Roof : " + house.getRoof().getName());

		return house;
	}

}
