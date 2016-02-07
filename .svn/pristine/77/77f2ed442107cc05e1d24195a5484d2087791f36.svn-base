package com.adargasystems.abstractfactory;

import junit.framework.TestCase;

public class ArchiveFactoryFactoryTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetFactory() {

		ArchiveFactory af = ArchiveFactoryFactory
				.getFactory(ArchiveFactoryType.REAL_ESTATE);

		assertNotNull(af);

		Archive archive = af.create();

		assertNotNull(archive);

		DocumentEntity de = archive.createDocument();

		assertNotNull(de);

		DocumentEntityType det = de.getType();
		
		assert (det == DocumentEntityType.REALESTATE_DATA);

	}

}
