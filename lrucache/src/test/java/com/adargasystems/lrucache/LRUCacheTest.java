/**
 * 
 */
package com.adargasystems.lrucache;

import junit.framework.TestCase;

/**
 * @author William
 *
 */
public class LRUCacheTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.adargasystems.lrucache.LRUCache#add(java.lang.Object)}.
	 */
	public void testAdd() {

		LRUCache<String> sCache = new LRUCache<String>(10);

		fillCache(sCache);

		try {
			@SuppressWarnings("unused")
			Object[] ignored = new Object[(int) Runtime.getRuntime().maxMemory()];
		} catch (Throwable e) {
			// Ignore OME
		}

		System.gc();
		System.gc();

		sCache.showCache();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException ie) {

		}

		sCache.stop();

	}

	public void fillCache(final LRUCache<String> sCache) {

		for (int i = 1; i < 15; i++) {
			String s = new String("Entry " + i);
			sCache.add(s);
			wait(1);
		}

	}

	public void wait(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
