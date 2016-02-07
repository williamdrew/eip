/**
 * 
 */
package com.adargasystems.chainOfResponsibility;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author William
 *
 */
public class CommandStack {

	private Set<RequestHandler> handlers = Collections
			.synchronizedSet(new LinkedHashSet<RequestHandler>());

	public CommandStack() {

	}

	public boolean execute() {
		System.out.println("Executing command stack");

		for (RequestHandler h : handlers) {

		}

		return true;
	}
}
