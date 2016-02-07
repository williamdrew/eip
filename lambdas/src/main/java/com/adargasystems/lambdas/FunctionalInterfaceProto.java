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
public class FunctionalInterfaceProto {

	public FunctionalInterfaceProto(){
		System.out.println("In " + this.getClass().getName());
	}
	public static void main(String[] args){
		System.out.println("In main...");
		
		new FunctionalInterfaceProto();
	}
}
