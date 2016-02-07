package com.adargasystems.jpaproto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

public class EmployeeServiceImplTest extends TestCase {

	public void testEmployeeServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
		EntityManager em = emf.createEntityManager();
		EmployeeService es = new EmployeeServiceImpl(em);
		assertNotNull(es);
		System.out.println("Start transaction.");
		em.getTransaction().begin();
		Employee emp = es.createEmployee(1001, "Ross Byzcek", 10000000);
		assertNotNull(emp);
		System.out.println("Created employee [" + emp + "]");
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
