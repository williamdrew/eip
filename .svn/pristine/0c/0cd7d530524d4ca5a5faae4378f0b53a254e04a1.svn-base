package com.adargasystems.abstractfactory;

public class ArchiveFactoryFactory {

	public final static ArchiveFactory getFactory(
			final ArchiveFactoryType typeToCreate) {

		ArchiveFactory archiveFactory = null;

		switch (typeToCreate) {
		case REAL_ESTATE:
			archiveFactory = new RealEstateArchiveFactory();
			break;
		case SCIENCE_DATA:
			archiveFactory = new ScienceDataArchiveFactory();
			break;
		default:
			System.out
					.println("Invalid ArchiveFactoryType sent to create an archive factory");
			break;
		}

		return archiveFactory;
	}
}
