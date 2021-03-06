/*
 *
 */
package com.adargasystems.splittingSynchronization;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
class ExceptionHandlingProto {

	@SuppressWarnings("null")
	public ExceptionHandlingProto() {

		//String nullString = new String("123");
		String nullString = null;

		try {
			System.out.println("In try block.");
			System.out.println("String length = " + nullString.length());
		} catch (NullPointerException npe) {
			System.out.println("In catch block...");
		} finally {
			System.out.println("In finally block.");
		}
		
		try{
			System.out.println("String length = " + nullString.length());
		}finally{
			System.out.println("In second finally without catch");
		}

	}

	public static void main(String[] args) {
		System.out.println("Entering main...");
		new ExceptionHandlingProto();
	}

}
