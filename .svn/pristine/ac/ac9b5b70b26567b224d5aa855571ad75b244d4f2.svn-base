/**
 * 
 */
package com.adargasystems.chainOfResponsibility;

/**
 * @author William
 *
 */
public class LoginHandler implements RequestHandler {

	private RequestHandler nextHandler;

	public LoginHandler(final RequestHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.chainOfResponsibility.ActionHandler#handle(com.
	 * adargasystems.chainOfResponsibility.Action)
	 */
	public boolean handle(Request action) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adargasystems.chainOfResponsibility.ActionHandler#setNextHandler(
	 * com.adargasystems.chainOfResponsibility.ActionHandler)
	 */
	public void setNextHandler(RequestHandler actionHandler) {
		if (null != actionHandler) {
			this.nextHandler = actionHandler;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adargasystems.chainOfResponsibility.ActionHandler#getNextHandler()
	 */
	public RequestHandler getNextHandler() {
		return nextHandler;
	}

}
