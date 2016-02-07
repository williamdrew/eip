/**
 * 
 */
package com.adargasystems.concurrent;

/**
 * @author William
 *
 */
public class JoinThreadTutorial {

	public Thread getThread() {
		return t;
	}

	private Thread t;

	public JoinThreadTutorial(final Long waitDuration) {

		MessageConsumer mc = new MessageConsumer();
		t = new Thread(mc);

		t.start();

		try {
			t.join(waitDuration * 1000);

			t.interrupt();

			System.out
					.println("Waiting for the message consumer to terminate.");
			try {
				t.join();
			} catch (InterruptedException ie2) {
				// nothing to do here
			}

		} catch (InterruptedException ie) {

		}
	}

	private class MessageConsumer implements Runnable {

		private boolean continueRunning = true;

		public void run() {

			while (continueRunning) {
				try {
					Thread.sleep(1000);
					System.out.println("Process any messages here...");

				} catch (InterruptedException e) {
					continueRunning = false;
				}

			}
			System.out.println(this.getClass().getName() + " is exiting");
		}
	}

	public static void main(String[] args) {

		Long waitDuration = 5L;

		if (args.length == 1) {
			try {
				waitDuration = Long.parseLong(args[0]);
			} catch (NumberFormatException e) {

			}

			JoinThreadTutorial jtt = new JoinThreadTutorial(waitDuration);

			try {
				jtt.getThread().join();
			} catch (InterruptedException ie) {

			}

		}
	}
}
