package com.adargasystems.splittingSynchronization;

public class thread1 implements Runnable {

	private static volatile boolean continueRunning = true;
	private static Thread t1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		thread1 thread1 = new thread1();
		t1 = new Thread(thread1);
		t1.start();

		try {
			t1.join(5000);
		} catch (InterruptedException e) {
			// eat it
		}
		//t1.interrupt();
		stopRunning();

	}

	public static boolean isContinueRunning() {
		return continueRunning;
	}
	
	public static  void stopRunning(){
		continueRunning = false;
		t1.interrupt();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("In run.");

		while (!Thread.currentThread().isInterrupted() && isContinueRunning()) {
		
			System.out.println("About to sleep in run()");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}

	}
}