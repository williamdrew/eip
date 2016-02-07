/**
 * 
 */
package com.adargasystems.lrucache;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author William
 * @param <T>
 *
 */
public class LRUCache<T> {

	private ConcurrentSkipListSet<SoftReference<CacheEntry<T>>> entrySet =
			new ConcurrentSkipListSet<SoftReference<CacheEntry<T>>>(
					new LRUCacheEntryComparator<T>());

	private long maxSize = 0L;
	private AtomicLong currentSize = new AtomicLong(0L);

	private ReferenceQueue<CacheEntry<T>> rq =
			new ReferenceQueue<CacheEntry<T>>();

	private Thread t;
	private ProcessSoftReferences psrThread;

	/**
	 * @return the currentSize
	 */
	public AtomicLong getCurrentSize() {
		return currentSize;
	}

	public LRUCache(final long maxSize) {
		this.maxSize = maxSize;

		psrThread = new ProcessSoftReferences();

		t = new Thread(psrThread);

		t.start();
	}

	public void add(T value) {
		if (null != value) {

			if (currentSize.get() >= maxSize) {
				evictLRUEntry();
			}

			CacheEntry<T> ce = new CacheEntry<T>(value);
			SoftReference<CacheEntry<T>> sr =
					new SoftReference<CacheEntry<T>>(ce, rq);

			entrySet.add(sr);

			currentSize.incrementAndGet();

			System.out.println("Added entry [" + ce + "]");
		}
	}

	private void evictLRUEntry() {

		SoftReference<CacheEntry<T>> sr = entrySet.pollFirst();

		currentSize.decrementAndGet();

		if (null != sr.get()) {
			System.out.println("Evicted entry [" + sr.get().getValue() + "]");
		}
	}

	public void stop() {
		if (null != psrThread) {
			psrThread.stop();
		}
	}

	public void showCache() {

		System.out.println("Size of cache = [" + entrySet.size() + "]");

		Iterator<SoftReference<CacheEntry<T>>> iter = entrySet.iterator();

		while (iter.hasNext()) {
			SoftReference<CacheEntry<T>> sr = iter.next();

			if (null != sr.get()) {
				System.out.println("Entry = [" + sr.get() + "] - value = ["
						+ sr.get().getValue() + "]");
			}
		}
	}

	private class ProcessSoftReferences implements Runnable {

		private boolean stillRunning = true;

		public void run() {

			System.out.println("Starting ProcessSoftReferences thread...");

			while (stillRunning) {
				try {
					Reference<? extends CacheEntry<T>> sr = rq.remove();
					if (null != sr) {
						System.out.println("CacheEntry blah = [" + sr + "]");
						if (entrySet.remove(sr)) {
							System.out.println("Removed entry = [" + sr.toString()
									+ "] from cache");
							if (null != sr.get()) {
								System.out.println("Processed soft ref [" + sr.get().getValue()
										+ "]");
							}
						}
					}
				} catch (InterruptedException ie) {
					stillRunning = false;
				}
			}
		}

		public void stop() {
			if (null != t) {
				t.interrupt();
			}
			stillRunning = false;
		}
	}
}
