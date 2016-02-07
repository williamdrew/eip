/*
 *
 */
package com.adargasystems.threadpools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class BlockingQueueThreadPoolExecutor extends ThreadPoolExecutor {

	private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	private final AtomicLong numTasks = new AtomicLong();

	private final AtomicLong totalTime = new AtomicLong();

	/**
	 * Counts the number of current tasks in process
	 */
	private AtomicInteger tasksInProcess = new AtomicInteger();

	private Synchronizer synchronizer = new Synchronizer();

	/**
	 * @param corePoolSize
	 * @param maximumPoolSize
	 * @param keepAliveTime
	 * @param unit
	 * @param workQueue
	 */
	public BlockingQueueThreadPoolExecutor(int poolSize, int queueSize, long keepAliveTime, TimeUnit keepAliveTimeUnit,
			long maxBlockingTime, TimeUnit maxBlockingTimeUnit, Callable<Boolean> blockingTimeCallback) {

		super(poolSize, poolSize, keepAliveTime, keepAliveTimeUnit,
				new ArrayBlockingQueue<Runnable>(Math.max(poolSize, queueSize)),
				new BlockThenRunPolicy(maxBlockingTime, maxBlockingTimeUnit, blockingTimeCallback));
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);

		System.out.printf("Thread %s: start %s \n", t, r);

		startTime.set(System.nanoTime());
	}

	@Override
	public void execute(Runnable task) {

		// count a new task in process
		tasksInProcess.incrementAndGet();
		try {
			super.execute(task);
		} catch (RuntimeException e) { // specifically handle
			// RejectedExecutionException
			tasksInProcess.decrementAndGet();
			throw e;
		} catch (Error e) {
			tasksInProcess.decrementAndGet();
			throw e;
		}
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		try {
			long taskTime = System.nanoTime() - startTime.get();

			numTasks.incrementAndGet();
			totalTime.addAndGet(taskTime);

			System.out.printf("Runnable %s: time=%dsecs \n", r, (taskTime / 1000000000));
		} finally {

			super.afterExecute(r, t);

			synchronized (this) {
				tasksInProcess.decrementAndGet();
				if (tasksInProcess.intValue() == 0) {
					synchronizer.signalAll();
				}
			}
		}
	}

	@Override
	public void setCorePoolSize(int corePoolSize) {
		super.setCorePoolSize(corePoolSize);
		super.setMaximumPoolSize(corePoolSize);
	};

	@Override
	public void setMaximumPoolSize(int maximumPoolSize) {
		throw new UnsupportedOperationException("setMaximumPoolSize is not supported");
	};

	@Override
	protected void terminated() {
		try {
			System.out.printf("Terminated: Total tasks=%s : Total time=%d secs : avg time=%d secs \n", numTasks,
					(totalTime.get() / 1000000000),
					(numTasks.get() == 0 ? 0 : ((totalTime.get() / numTasks.get()) / 1000000000)));
		} finally {
			super.terminated();
		}
	}

	public void await() throws InterruptedException {
		synchronizer.await();
	}

	public boolean await(long timeOut, TimeUnit timeUnit) throws InterruptedException {
		return synchronizer.await(timeOut, timeUnit);
	}

	/**
	 * This Policy class enforces the blocking feature of the
	 * BlockingQueueThreadPoolExecutor. It does so by invoking the BlockingQueue's
	 * put method (instead of the offer method that is used by the standard
	 * implementation of the ThreadPoolExecutor.
	 */
	private static class BlockThenRunPolicy implements RejectedExecutionHandler {

		private long maxBlockingTime;
		private TimeUnit maxBlockingTimeUnit;
		private Callable<Boolean> blockingTimeCallback;

		public BlockThenRunPolicy(long maxBlockingTime, TimeUnit maxBlockingTimeUnit,
				Callable<Boolean> blockingTimeCallback) {
			this.maxBlockingTime = maxBlockingTime;
			this.maxBlockingTimeUnit = maxBlockingTimeUnit;
			this.blockingTimeCallback = blockingTimeCallback;
		}

		public BlockThenRunPolicy() {

		}

		/**
		 * When this method is invoked by the ThreadPoolExecutor's reject method it
		 * simply asks for the Executor's Queue and calls on its offer method which
		 * will block {@link #maxBlockingTime} of {@link #maxBlockingTimeUnit} units
		 * if the {@link #blockingTimeCallback} is NOT null. Else it will simply
		 * call put on the queue and block if full.
		 * 
		 * @see java.util.concurrent.RejectedExecutionHandler#rejectedExecution(Runnable,
		 *      ThreadPoolExecutor)
		 */
		public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {

			BlockingQueue<Runnable> workQueue = executor.getQueue();

			boolean taskSent = false;

			while (!taskSent) {

				if (executor.isShutdown()) {
					throw new RejectedExecutionException(
							"ThreadPoolExecutor has shutdown while attempting to offer a new task.");
				}

				try {
					// check whether to offer (blocking) with a timeout or
					// without
					if (blockingTimeCallback != null) {
						// put on the queue and block if no room is available,
						// with a timeout
						// the result of the call to offer says whether the task
						// was accepted or not
						System.out.println("Offering task [" + task + " to work queue for " + maxBlockingTime + " "
								+ maxBlockingTimeUnit);
						if (workQueue.offer(task, maxBlockingTime, maxBlockingTimeUnit)) {
							System.out.println("Task " + task + " accepted.");
							taskSent = true;
						} else {
							// task was not accepted - call the Callback
							Boolean result = null;
							try {
								result = blockingTimeCallback.call();
							} catch (Exception e) {
								// we got an exception from the Callback, wrap
								// it and throw
								throw new RejectedExecutionException(e);
							}
							// if result if false we need to throw an exception
							// otherwise, just continue with the loop
							if (result == false) {
								throw new RejectedExecutionException("User decided to stop waiting for task insertion");
							} else {
								continue;
							}
						}

					}
					// no timeout
					else {
						// just send the task (blocking, if the queue is full)
						System.out.println("Callback is null so simply putting on the queue without timeout.");
						workQueue.put(task);
						// task accepted
						taskSent = true;
					}
				} catch (InterruptedException e) {
					// someone woke us up and we need to go back to the
					// offer/put call...
				}
			} // end of while for InterruptedException
		}

	}

	/**
	 * 
	 *
	 * @author $Author$
	 * @id $Id$
	 *
	 */
	private class Synchronizer {

		private final Lock lock = new ReentrantLock();
		private final Condition done = lock.newCondition();
		private boolean isDone = false;

		/**
		 * This PRIVATE method allows the ThreadPoolExecutor to notify all
		 * interested parties that all tasks given to the execute method have run to
		 * conclusion.
		 */
		private void signalAll() {

			lock.lock(); // MUST lock!
			try {
				isDone = true; // To help the await method ascertain that it has
				// not waken up 'spuriously'
				done.signalAll();
			} finally {
				lock.unlock(); // Make sure to unlock even in case of an
				// exception
			}
		}

		/**
		 * This is the inner implementation for supporting the
		 * NotifyingBlockingThreadPoolExecutor.await().
		 * 
		 * @see NotifyingBlockingThreadPoolExecutor#await() for details.
		 * @throws InterruptedException
		 *           when the internal condition throws it.
		 */
		public void await() throws InterruptedException {

			lock.lock(); // MUST lock!
			try {
				while (!isDone) { // Ascertain that this is not a 'spurious
					// wake-up'
					done.await();
				}
			} finally {
				isDone = false; // for next time
				lock.unlock(); // Make sure to unlock even in case of an
				// exception
			}
		}

		/**
		 * This is the inner implementation for supporting the
		 * NotifyingBlockingThreadPoolExecutor.await(timeout, timeUnit).
		 * 
		 * @see NotifyingBlockingThreadPoolExecutor#await(long, TimeUnit) for
		 *      details.
		 * @throws InterruptedException
		 *           when the internal condition throws it.
		 */
		public boolean await(long timeout, TimeUnit timeUnit) throws InterruptedException {

			boolean await_result = false;
			lock.lock(); // MUST lock!
			boolean localIsDone;
			try {
				await_result = done.await(timeout, timeUnit);
			} finally {
				localIsDone = isDone;
				isDone = false; // for next time
				lock.unlock(); // Make sure to unlock even in case of an
				// exception
			}
			// make sure we return true only if done!
			return await_result && localIsDone;
		}
	}

	// ====================================================================
	// end of inner class Synchronizer
	// ====================================================================

}
