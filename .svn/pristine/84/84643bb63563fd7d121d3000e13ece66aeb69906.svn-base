package com.adargasystems.misc;

public class MyAmazingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String description;
	private final Throwable t;

	/**
	 * 
	 * @param description
	 */
	public MyAmazingException(final String description) {
		this.description = description;
		this.t = null;
	}

	public MyAmazingException(final String description, final Throwable t) {
		this.description = description;
		this.t = t;
	}
	
	public String getDescription(){
		return description;
	}
	
	public Throwable getCause(){
		return t;
	}
}