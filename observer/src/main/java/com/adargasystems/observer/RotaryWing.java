/*
 *
 */
package com.adargasystems.observer;

/**
 *
 * @author $Author: $
 * @id $Id: RotaryWing.java 976 2015-07-07 14:41:33Z  $
 *
 */
public class RotaryWing implements Aircraft {

	private final String name;
	
	public RotaryWing(final String name){
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
	
	public String getType(){
		return "RotaryWing";
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name = " + getName());
		sb.append("; Type = " + getType());
		return sb.toString();
	}

}
