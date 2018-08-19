package com.maven.testing.TestingMaven;


import java.util.ArrayList;
import java.util.List;

public class EmployeeArrayOperations {

	EmployeeUtil employeeUtil = new EmployeeUtil();
	Employee employee = null;

	public void addEmployee(Employee employee) {
		employeeUtil.addEmployee(employee);
	}

	public List<Employee> showAllEmployees() {
		return employeeUtil.showAllEmployees();
	}

	public Employee getEmployee(int empId) {
		employee = employeeUtil.getEmployee(empId);
		return employee;
	}

	public double calculateHRA(int empId) {
		employee = getEmployee(empId);
		return employeeUtil.calculateHRA(employee);
	}

	public double calculateGrossSalary(int empId) {
		employee = getEmployee(empId);
		return employeeUtil.calculateGrossSalary(employee);
	}

	public void deleteEmployee(int empId) {
		employeeUtil.deleteEmployee(empId);

	}

}
