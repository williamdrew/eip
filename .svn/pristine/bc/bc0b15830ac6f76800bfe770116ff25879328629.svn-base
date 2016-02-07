package com.adargasystems.jpaproto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeServiceImpl implements EmployeeService {
	protected EntityManager em;

	public EmployeeServiceImpl(EntityManager em) {
		this.em = em;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.jpaproto.EmployeeService#createEmployee(int,
	 * java.lang.String, long)
	 */
	public Employee createEmployee(int id, String name, long salary) {
		Employee emp = new Employee(id);
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		return emp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.jpaproto.EmployeeService#removeEmployee(int)
	 */
	public void removeEmployee(int id) {
		Employee emp = findEmployee(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.jpaproto.EmployeeService#raiseEmployeeSalary(int,
	 * long)
	 */
	public Employee raiseEmployeeSalary(int id, long raise) {
		Employee emp = em.find(Employee.class, id);
		if (emp != null) {
			emp.setSalary(emp.getSalary() + raise);
		}
		return emp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.jpaproto.EmployeeService#findEmployee(int)
	 */
	public Employee findEmployee(int id) {
		return em.find(Employee.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adargasystems.jpaproto.EmployeeService#findAllEmployees()
	 */
	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
		return query.getResultList();
	}
}