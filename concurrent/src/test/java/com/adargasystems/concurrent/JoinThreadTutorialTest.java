/**
 * 
 */
package com.adargasystems.concurrent;

import junit.framework.TestCase;

/**
 * 
 *
 * @author $Author: $
 * @id $Id: JoinThreadTutorialTest.java 977 2015-07-07 14:42:39Z  $
 *
 */
public class JoinThreadTutorialTest extends TestCase {

	/**
	 * Test method for {@link com.adargasystems.concurrent.JoinThreadTutorial#JoinThreadTutorial(java.lang.Long)}.
	 */
	public void testJoinThreadTutorial() {
		String[] args = new String[1];
		
		args[0] = "5";
		
		JoinThreadTutorial.main(args);
	}

}
