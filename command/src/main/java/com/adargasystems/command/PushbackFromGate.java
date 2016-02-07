/**
 * 
 */
package com.adargasystems.command;

/**
 * @author William
 *
 */
public class PushbackFromGate implements Command {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.command.Command#execute()
	 */
	public boolean execute() {
		System.out.println("Pushing back from gate...");
		System.out.println("Push back complete.");
		return true;
	}

}
