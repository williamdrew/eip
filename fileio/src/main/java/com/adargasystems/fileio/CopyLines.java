package com.adargasystems.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

public class CopyLines {

	public static void writeToFileZipFileContents(String zipFileName,
			String outputFileName) throws java.io.IOException {

		java.nio.charset.Charset charset =
				java.nio.charset.StandardCharsets.US_ASCII;
		java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

		// Open zip file and create output file with
		// try-with-resources statement
		// java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);

		try (java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
				java.io.BufferedWriter writer =
						java.nio.file.Files.newBufferedWriter(outputFilePath, charset)) {
			// Enumerate each entry
			for (Enumeration<? extends ZipEntry> entries = zf.entries(); entries
					.hasMoreElements();) {
				
				// Get the entry name and write it to the output file
				String newLine = System.getProperty("line.separator");
				String zipEntryName =
						((java.util.zip.ZipEntry) entries.nextElement()).getName()
								+ newLine;
				writer.write(zipEntryName, 0, zipEntryName.length());
			}
		} finally {

			System.out.println("Finally called.");
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		// try {
		// inputStream = new BufferedReader(new FileReader("xanadu.txt"));
		// outputStream = new PrintWriter(new
		// FileWriter("characteroutput.txt"));

		inputStream = new BufferedReader(new FileReader("xanadu.txt"));
		outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

		try {

			String l;
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}