/**
 * 
 */
package com.adargasystems.chainOfResponsibility;

/**
 * @author William
 *
 */
public interface RequestHandler {
	
	boolean handle(Request action);
	
	void setNextHandler(RequestHandler actionHandler);
	
	RequestHandler getNextHandler();

}
