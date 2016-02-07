/**
 * 
 */
package com.adargasystems.command;


/**
 * @author William
 *
 */
public class LandAircraft implements Command {

	/* (non-Javadoc)
	 * @see com.adargasystems.command.Command#execute()
	 */
	public boolean execute() {
		System.out.println("Aircraft landing...");
		System.out.println("Wheels down.");
		return true;
	}

}
