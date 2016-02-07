/**
 * 
 */
package com.adargasystems.chainOfResponsibility;

/**
 * @author William
 *
 */
public class Login implements Request {

	/* (non-Javadoc)
	 * @see com.adargasystems.chainOfResponsibility.Action#perform()
	 */
	public boolean handle() {
		System.out.println();
		return true;
	}

}
