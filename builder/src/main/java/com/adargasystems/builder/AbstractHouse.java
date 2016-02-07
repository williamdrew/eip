package com.adargasystems.builder;

public abstract class AbstractHouse implements House {

	private Floor floor;
	private Wall wall;
	private Roof roof;

	public Floor getFloor() {
		// TODO Auto-generated method stub
		return floor;
	}

	public Wall getWall() {
		// TODO Auto-generated method stub
		return wall;
	}

	public Roof getRoof() {
		// TODO Auto-generated method stub
		return roof;
	}

	public void setRoof(final Roof roof) {
		this.roof = roof;
	}

	public void setFloor(final Floor floor) {
		this.floor = floor;
	}

	public void setWall(final Wall wall) {
		this.wall = wall;

	}

}
