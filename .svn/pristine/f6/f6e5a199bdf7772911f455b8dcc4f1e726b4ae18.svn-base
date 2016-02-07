package com.adargasystems.splittingSynchronization;

class Shape {

	protected AdjustableLocation location;
	protected AdjustableDimension dimension;

	public Shape() {
		location = new AdjustableLocation(0.0, 0.0);
		dimension = new AdjustableDimension(0.0, 0.0);
	}

	public double x() {
		return location.x();
	}

	public double y() {
		return location.y();
	}

	public double width() {
		return dimension.getWidth();
	}

	public double height() {
		return dimension.getHeight();
	}

	public void adjustLocation(double x, double y) {
		location.adjustLocation(x, y);
	}

	public void adjustDimension(double width, double height) {
		dimension.adjustDimension(width, height);
	}

}