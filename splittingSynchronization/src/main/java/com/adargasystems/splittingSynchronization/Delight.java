package com.adargasystems.splittingSynchronization;

class Delight {
	
	public static void main(String[] args) {
		
		for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
			System.out.println(b);
			if (b == 0x90)
				System.out.print("Joy!");
		}
	}
}
