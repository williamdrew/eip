package com.adargasystems.abstractfactory;

public class ScienceDataArchive implements Archive {

	public DocumentEntity createDocument() {
		return new ScienceDataDocumentEntity();
	}

}
