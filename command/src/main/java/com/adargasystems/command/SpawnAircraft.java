/**
 * 
 */
package com.adargasystems.command;

/**
 * @author William
 *
 */
public class SpawnAircraft implements Command {

	/* (non-Javadoc)
	 * @see com.adargasystems.command.Command#execute()
	 */
	public boolean execute() {
		System.out.println("Spawning aircraft...");
		System.out.println("Aircraft spawned.");
		return true;
	}

}
