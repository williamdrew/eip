/*
 *
 */
package com.adargasystems.lambdas;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class Person {

	public String name;

	public Person(final String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public synchronized String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public synchronized void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Person \n");
		sb.append("Name = " + getName());
		return sb.toString();
	}

}
