package com.adargasystems.abstractfactory;

public class ScienceDataArchiveFactory implements ArchiveFactory {

	public Archive create() {
		return new ScienceDataArchive();
	}

}
