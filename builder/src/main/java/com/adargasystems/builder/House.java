package com.adargasystems.builder;

public interface House {

	public String getName();

	public Floor getFloor();

	public Wall getWall();

	public Roof getRoof();
	
	public void setRoof(final Roof roof);
	
	public void setFloor(final Floor floor);
	
	public void setWall(final Wall wall);
}
