package com.adargasystems.facade;

class HardDrive {
	public byte[] read(long lba, int size) {
		System.out.println("Reading...");
		return new byte[100];
	}
}