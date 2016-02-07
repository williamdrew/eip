package com.adargasystems.concurrent;
public class CasCounter {
	
    private SimulatedCAS value;

    public CasCounter(){
    	System.out.println("CasCounter ctor()");
    	value = new SimulatedCAS();
    }
    public int getValue() {
        return value.getValue();
    }

    public int increment() {
        int oldValue = value.getValue();
        while (value.compareAndSwap(oldValue, oldValue + 1) != oldValue)
            oldValue = value.getValue();
        return oldValue + 1;
    }
}