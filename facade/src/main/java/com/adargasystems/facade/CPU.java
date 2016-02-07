/**
 * 
 */
package com.adargasystems.facade;

/**
 * @author William
 *
 */
public class CPU {
	public void freeze() {
		System.out.println("Freezing...");
	}

	public void jump(long position) {
		System.out.println("Jumping...");
	}

	public void execute() {
		System.out.println("Executing...");
	}
}
