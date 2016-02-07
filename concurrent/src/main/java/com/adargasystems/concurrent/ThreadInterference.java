/**
 * 
 */
package com.adargasystems.concurrent;

/**
 * @author William
 *
 */
public class ThreadInterference implements Runnable {

	private class Counter {
		private int value = 0;

		public void increment() {
			value++;
			showValue();
		}

		public void decrement() {
			value--;
			showValue();
		}

		private void showValue() {
			System.out.println("value = " + value);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		Counter c = new Counter();

		ThreadA ta = new ThreadA(c);
		ThreadB tb = new ThreadB(c);

		Thread t1 = new Thread(ta);
		t1.start();
		Thread t2 = new Thread(tb);
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException ie) {

		}

	}

	public ThreadInterference() {

	}

	public class ThreadA implements Runnable {

		Counter c;

		public ThreadA(Counter c) {
			this.c = c;
		}

		public void run() {
		
				for (int i = 0; i < 10; i++) {
					c.increment();
					try {
						Thread.sleep(100);
					} catch (InterruptedException ie) {
						// nothing to do
					}
				}
			
		}
	}

	public class ThreadB implements Runnable {

		Counter c;

		public ThreadB(Counter c) {
			this.c = c;
		}

		public void run() {
			
			for (int i = 0; i < 10; i++) {
				c.decrement();
				try {
					Thread.sleep(100);
				} catch (InterruptedException ie) {
					// nothing to do
				}
			}
		}
	}

	public static void main(String[] args) {

		ThreadInterference ti = new ThreadInterference();
		Thread t = new Thread(ti);

		t.start();

		try {
			t.join(12000);
		} catch (InterruptedException ie) {
			t.interrupt();
		}
	}
}
