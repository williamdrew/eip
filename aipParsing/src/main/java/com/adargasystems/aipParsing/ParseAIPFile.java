/*
 *
 */
package com.adargasystems.aipParsing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class ParseAIPFile {

	public static void main(String[] args) {

		// The name of the file to open.
		String fileName = "/home/William/aviation_data/aip/openaip_airports_united_states_us.aip";


		BufferedReader bufferedReader = null;

		try {

			/**
			 * FileReader reads text files in the default encoding
			 */

			// Always wrap FileReader in BufferedReader.
			bufferedReader = new BufferedReader(new FileReader(fileName));

			// This will reference one line at a time
			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file [" + fileName + "]");
		} catch (IOException ex) {
			System.out.println("Error reading file [" + fileName + "]");
			// Or we could just do this:
			// ex.printStackTrace();
		} finally {

			// Always close files.

			try {
				bufferedReader.close();
			} catch (IOException e) {
			}
		}
	}
}
