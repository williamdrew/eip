/**
 * 
 */
package com.adargasystems.facade;

/**
 * @author William
 *
 */
public class Computer {

	private CPU cpu;
	private HardDrive hd;
	private Memory memory;

	public Computer() {
		cpu = new CPU();
		hd = new HardDrive();
		memory = new Memory();
	}

	public void start() {
		memory.load(1L, new byte[10]);
		hd.read(10L, 1000);
		cpu.execute();
	}

}
