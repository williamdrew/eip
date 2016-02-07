/*
 *
 */
package com.adargasystems.strategy;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class RequestHandler {

	private static ProcessRequestStrategy _processStrategy = null;

	public RequestHandler(ProcessRequestStrategy processStrategy) {
		_processStrategy = processStrategy;
	}

	public boolean handle() {
		return _processStrategy.perform();
	}
}
