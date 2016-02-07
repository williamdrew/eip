/*
 *
 */
package com.adargasystems.splittingSynchronization;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class ServiceResult {

	public enum ServiceResultEnum {
		SUCCESS, FAILURE;
	}

	private volatile ServiceResultEnum value;

	public ServiceResult(final ServiceResultEnum value) {
		this.value = value;
	}

	public ServiceResultEnum getDescription() {
		return value;
	}

	@Override
	public String toString(){
		return "Service results = " + value.toString();
	}
}
