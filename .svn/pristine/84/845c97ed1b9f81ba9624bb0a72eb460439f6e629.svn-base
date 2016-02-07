package com.adargasystems.concurrent;

public class SimulatedCAS {
	private int value = 0;
	
	public synchronized int getValue() {
		return value;
	}

	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		int oldValue = value;
		if (value == expectedValue)
			value = newValue;
		return oldValue;
	}
}