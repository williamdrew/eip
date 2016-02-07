/**
 * 
 */
package com.adargasystems.concurrent;

/**
 * @author William
 *
 */
public class CounterAccessViaSynchronizedObject implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		SynchronizedCounter c = new SynchronizedCounter();

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

	public CounterAccessViaSynchronizedObject() {

	}

	public class ThreadA implements Runnable {

		SynchronizedCounter c;

		public ThreadA(SynchronizedCounter c) {
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

		SynchronizedCounter c;

		public ThreadB(SynchronizedCounter c) {
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

		CounterAccessViaSynchronizedObject ti = new CounterAccessViaSynchronizedObject();
		Thread t = new Thread(ti);

		t.start();

		try {
			t.join(12000);
		} catch (InterruptedException ie) {
			t.interrupt();
		}
	}
}
