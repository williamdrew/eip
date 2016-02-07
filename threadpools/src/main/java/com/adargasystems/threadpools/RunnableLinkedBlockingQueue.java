/*
 *
 */
package com.adargasystems.threadpools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class RunnableLinkedBlockingQueue extends ArrayBlockingQueue<Runnable> {

	/**
	 * @param capacity
	 */
	public RunnableLinkedBlockingQueue(int capacity) {
		super(capacity);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7378309476826164813L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.LinkedBlockingDeque#add(java.lang.Object)
	 */
	@Override
	public boolean add(Runnable e) {
		boolean addStatus = super.add(e);

		System.out.println("Added runnable to " + this.getClass().getName());

		return addStatus;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.LinkedBlockingQueue#put(java.lang.Object)
	 */
	@Override
	public void put(Runnable e) throws InterruptedException {
		// TODO Auto-generated method stub
		super.put(e);

		System.out.println("Put runnable to " + this.getClass().getName());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.LinkedBlockingQueue#offer(java.lang.Object,
	 * long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public boolean offer(Runnable e, long timeout, TimeUnit unit) throws InterruptedException {
		boolean status = super.offer(e, timeout, unit);
		System.out.println("Offer runnable to " + this.getClass().getName());
		return status;

	}

	@Override
	public boolean offer(Runnable e) {
		System.out.println("Queueing up [" + e + "] task");
		boolean offerStatus = super.offer(e);
		System.out.println("Queueing [" + e + "] task " + (offerStatus ? "succeeded" : "failed"));
		return offerStatus;
	}
}
