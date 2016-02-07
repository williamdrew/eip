/*
 *
 */
package com.adargasystems.concurrent;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class FutureTaskDemo {

	private ExecutorService exec = Executors.newFixedThreadPool(Runtime
			.getRuntime().availableProcessors());

	public enum MyCallableStatus {
		SUCCESS, FAILURE;

	}

	private class MyCallable implements Callable<MyCallableStatus> {

		@Override
		public MyCallableStatus call() throws InterruptedException {
			Thread.currentThread();
			Thread.sleep(ThreadLocalRandom.current().nextInt(1, 10)*1000);
			System.out.println("Task completed");
			return MyCallableStatus.SUCCESS;
		}
	}

	public FutureTaskDemo() {

		// FutureTask<MyCallableStatus> ft = new FutureTask<>(new MyCallable());
		
		String test = new String("Testing");
		String internString = "testing";
		String t2 = "interesting".intern();
		
		if(test.equalsIgnoreCase(internString)){
			System.out.println(test + " equals " + internString);
		}
		
		if(test.equals(internString)){
			System.out.println(test + " equals " + internString);
		}
		
		char[] carray = test.toCharArray();
		
		for(int i = 0; i < carray.length; i++){
			System.out.println(carray[i]);
		}

		Future<MyCallableStatus> f = exec.submit(new MyCallable());

		if (!f.isCancelled()) {
			try {
				System.out.println("Waiting on task...");
				f.get(5, TimeUnit.SECONDS);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Shutting down executor...");
		exec.shutdown();
		

		System.out.println("Awaiting executor termination...");
		try {
			if(!exec.awaitTermination(5, TimeUnit.SECONDS)){
				List<Runnable> tbdList = exec.shutdownNow();
				tbdList.stream().forEach(e -> System.out.println(e));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Terminated");
	}

	public static void main(String[] args) {

		new FutureTaskDemo();
	}

}
