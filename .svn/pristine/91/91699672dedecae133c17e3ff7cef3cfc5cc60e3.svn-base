package com.adargasystems.fileio;

public class PathExamples {

	public PathExamples() {

		Thread t1 = new Thread();

		t1.start();

		ThreadTest tt = new ThreadTest();
		Thread t2 = new Thread(tt);

		t2.start();
		
		Thread t3 = new  ExtendingThread();
		
		t3.start();
		
		try {
			t1.join(5000);

			t2.join(5000);
			
			t3.join(5000);
			
		} catch (InterruptedException ie) {

		}
	}

	public static void main(String[] args) {
		new PathExamples();
	}

	private class ExtendingThread extends Thread {

		@Override
		public synchronized void start() {
			super.start();
			System.out.println("ExtendingThread...");
		}

	}

	private class ThreadTest implements Runnable {

		@Override
		public void run() {
			System.out.println("ThreadTest...");

		}

	}
}
