package com.adargasystems.threadpools;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class TimingTestThread implements Callable<Boolean> {

	private final String name;

	public TimingTestThread(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	public Boolean call() throws Exception {

		System.out.println("call() invoked in " + name);
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(1, 100) * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

}
