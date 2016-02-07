package com.adargasystems.jpaproto;

import java.util.List;

public interface EmployeeService {

	Employee createEmployee(int id, String name, long salary);

	void removeEmployee(int id);

	Employee raiseEmployeeSalary(int id, long raise);

	Employee findEmployee(int id);

	List<Employee> findAllEmployees();

}