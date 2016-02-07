package com.adargasystems.misc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

	private List<Integer> intList = new ArrayList<Integer>();

	private Elvis elvis;

	public App(final String fileName) {

		// readList(fileName);

	}

	private void readList(final String fileName) {

		try (RandomAccessFile raf = new RandomAccessFile(fileName, "r");) {
			String line;
			while (null != (line = raf.readLine())) {
				intList.add(Integer.valueOf(line));
			}
		} catch (FileNotFoundException fne) {
			System.err.println("File [" + fileName + "] not found.");
		} catch (IOException ioe) {
			System.err.println(ioe.getLocalizedMessage());
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// if(args.length != 1){
		// System.err.println("Please provide a file for parsing");
		// return;
		// }

		//App a = new App(args[0]);
		App a = new App(null);
		System.out.println(
				"Elvis has " + ((a.elvis.INSTANCE.leftTheBuilding()) == true ? "not " : "") + "left the building");
	}
}
