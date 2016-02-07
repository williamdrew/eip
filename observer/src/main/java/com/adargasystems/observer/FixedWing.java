/*
 *
 */
package com.adargasystems.observer;

/**
 *
 * @author $Author: $
 * @id $Id: FixedWing.java 976 2015-07-07 14:41:33Z  $
 *
 */
public class FixedWing implements Aircraft {

	private final String name;

	public FixedWing(final String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.observer.Aircraft#getName()
	 */
	public String getName() {
		return name;
	}

	public String getType() {
		return "FixedWing";
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name = " + getName());
		sb.append("; Type = " + getType());
		return sb.toString();
	}

}
