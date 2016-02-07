package com.adargasystems.lambdas;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class ConcurrentGreeter extends Greeter {

	private static ExecutorService exec = Executors.newFixedThreadPool(Runtime
			.getRuntime().availableProcessors());
	
	Set<Person> pl = new TreeSet<Person>(Comparator.comparing(Person::getName));

	Callable<String> callable = () -> {
		return "success";
	};

	public void greet() {
		// Thread t = new Thread(super::greet);
		// Thread t = new Thread(super::respond);

		pl.add(new Person("Bob"));
		pl.add(new Person("Carl"));
		pl.add(new Person("Dave"));
		pl.add(new Person("Eric"));

		pl.stream().forEach(x -> System.out.println(x));

		FutureTask<String> f = new FutureTask<String>(callable);

		f.run();

		Future<Boolean> future = exec.submit(new PersonLocator("Bob "));

		try {
			Boolean found = future.get(10, TimeUnit.SECONDS);
			System.out.println("Person locator results = " + found);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

	private class PersonLocator implements Callable<Boolean> {

		private String nameToFind;

		public PersonLocator(final String nameToFind) {
			this.nameToFind = nameToFind;
		}

		@Override
		public Boolean call() {
			Boolean foundPerson = false;
			if ((null != pl) && (null != nameToFind)
					&& (!"".equals(nameToFind))) {
				foundPerson = pl.contains(new Person(nameToFind));
			}
			return foundPerson;
		}
	}

	public static void main(String[] args) {
		new ConcurrentGreeter().greet();
		
		if (null != exec) {
			
			if (!exec.isTerminated()) {
				
				exec.shutdown();

				try {
					exec.awaitTermination(10, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					System.out.println("In the finally block!!!");
				}
		
			}
		
		}
	
	}
	
}