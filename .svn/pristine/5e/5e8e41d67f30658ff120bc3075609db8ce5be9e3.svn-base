/*
 *
 */
package com.adargasystems.collections;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public abstract class AbstractShape implements Shape {

	private Color color;
	private String name;

	public AbstractShape(final Color color, final String name) {
		this.color = color;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Name = [" + name + "]\t");
		sb.append("Color = [" + color + "]");
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Shape o) {

		if (!getName().equals(o.getName())) {
			return getName().compareTo(o.getName());
		}

		if (!getColor().equals(o.getColor())) {
			return getColor().compareTo(o.getColor());
		}

		return 0; // equal
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (AbstractShape) obj;
		if (color != other.getColor())
			return false;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		return true;
	}

}
