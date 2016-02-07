/**
 * 
 */
package com.adargasystems.lrucache;

import java.lang.ref.SoftReference;
import java.util.Comparator;

/**
 * @author William
 *
 */
public class LRUCacheEntryComparator<T> implements Comparator<SoftReference<CacheEntry<T>>>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(SoftReference<CacheEntry<T>> o1,
			SoftReference<CacheEntry<T>> o2) {
		if(null == o1.get()){
			return -1;
		}else if(null == o2.get()){
			return 1;
		}else{
			return o1.get().compareTo(o2.get());
		}
	}

}
