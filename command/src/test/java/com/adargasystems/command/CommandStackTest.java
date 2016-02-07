/**
 * 
 */
package com.adargasystems.command;

import junit.framework.TestCase;

/**
 * @author William
 *
 */
public class CommandStackTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.adargasystems.command.CommandStack#CommandStack()}.
	 */
	public void testCommandStack() {

		CommandStack cs1 = new CommandStack("#1");
		cs1.addCommand(new LandAircraft());
		cs1.addCommand(new TakeOff());
		cs1.addCommand(new PushbackFromGate());

		CommandStack cs2 = new CommandStack("#2");

		cs2.addCommand(new PushbackFromGate());
		cs2.addCommand(new TakeOff());
		cs2.addCommand(new LandAircraft());

		cs1.addCommand(cs2);

		CommandStack cs3 = new CommandStack("#3");
		cs3.addCommand(new PushbackFromGate());
		cs3.addCommand(new TakeOff());
		cs3.addCommand(new LandAircraft());

		cs2.addCommand(cs3);

		cs1.execute();
		// cs3.execute();

		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {
		// }
		// cs.stop();
	}

}
