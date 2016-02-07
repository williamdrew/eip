/**
 * 
 */
package com.adargasystems.concurrent;

/**
 * @author William
 *
 */
public class SynchronizedCounter {
	private int count;

	public synchronized void increment() {
		count++;
		showCount();
	}

	public synchronized void decrement() {
		count--;
		showCount();
	}

	private void showCount() {
		System.out.println("Count = " + count);
	}
}
