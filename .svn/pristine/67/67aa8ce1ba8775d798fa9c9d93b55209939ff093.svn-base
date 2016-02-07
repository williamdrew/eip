/**
 * 
 */
package com.adargasystems.command;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author William
 *
 */
public class CommandStack implements Command {

	private Deque<Command> commands = new ConcurrentLinkedDeque<Command>();

	// private boolean continueProcessing = true;
	// private Thread cpThread;
	private String name;

	public CommandStack(final String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adargasystems.command.CommandStack#addComand(com.adargasystems.command
	 * .Command)
	 */
	public void addCommand(Command command) {
		commands.push(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.command.CommandStack#flush()
	 */
	public void flush() {
		commands.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.command.CommandStack#execute()
	 */
	public boolean execute() {

		System.out.println("Executing [" + name + "]");

		while (!commands.isEmpty()) {
			Command c = commands.pop();
			if (null != c) {
				c.execute();
			}
		}

		return true;
	}

	// public void stop() {
	// continueProcessing = false;
	// cpThread.interrupt();
	// }
	//
	// private class CommandProcessor implements Runnable {
	//
	// public void run() {
	//
	// while (continueProcessing) {
	//
	// while (!commands.isEmpty()) {
	//
	// Command c = commands.pop();
	//
	// if (null != c) {
	// c.execute();
	// }
	// }
	// }
	//
	// System.out.println("Command processor is terminated.");
	// }
	// }
}
