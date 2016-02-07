package com.adargasystems.jpaproto;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAMainProto {

	private EntityManagerFactory emf;

	public JPAMainProto() {
		emf = Persistence.createEntityManagerFactory("EmployeeService");
		if(null == emf){
			throw new RuntimeException("Error creating EntityManagerFactory");
		}
	}

	/**
	 * 
	 * @return
	 */
	public synchronized EntityManagerFactory getEmf(){
		return emf;
	}
	
	public static void main(String[] args) {
		new JPAMainProto();
	}
}
