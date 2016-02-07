/**
 * 
 */
package com.adargasystems.lrucache;

/**
 * @author William
 * @param <T>
 *
 */
public class CacheEntry<T> implements Comparable<CacheEntry<T>> {

	private T value;
	private long lastAccess;

	public CacheEntry(T value) {
		this.value = value;
		this.lastAccess = System.currentTimeMillis();
	}

	public T getValue() {
		updateLastAccess();
		return value;
	}

	public long getLastAccess() {
		return lastAccess;
	}

	private void updateLastAccess() {
		lastAccess = System.currentTimeMillis();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(CacheEntry<T> o) {

		if (null == o) {
			return 1;
		}

		if (this.equals(o)) {
			return 0;
		} else if (lastAccess > o.getLastAccess()) {
			return 1;
		} else if (lastAccess < o.getLastAccess()) {
			return -1;
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (lastAccess ^ (lastAccess >>> 32));
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CacheEntry [value=" + value + ", lastAccess=" + lastAccess
				+ "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		CacheEntry<T> other = (CacheEntry<T>) obj;
		if (lastAccess != other.lastAccess)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} 
		
		return true;
	}

}
