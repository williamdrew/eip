/**
 * 
 */
package com.adargasystems.concurrent;

/**
 * @author William
 *
 */
public class RecursionExamples {

	public static int entryCount = 0;
	
	public static void printDescending(int n){
		
		entryCount++;
	
		if(n > 0){
			System.out.println("N = " + n);
			printDescending(n-1);
		}else{
			System.out.println("N = " + n);
		}
	}
	
	public static void referenceUpdate(int refInt){

		System.out.println("Start referenceUpdate() = " + refInt);
		refInt = 0;
		System.out.println("End referenceUpdate() = " + refInt);
	}
	
	public static void main(String[] args){
		printDescending(10);
		System.out.println("Entry count = " + entryCount);
		
		int referencedInt = 10;
		System.out.println("(Before) referencedInt = " + referencedInt);
		referenceUpdate(referencedInt);
		System.out.println("(After) referencedInt = " + referencedInt);
	}
}
