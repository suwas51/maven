package com.maven.testing.TestingMaven;


import java.util.ArrayList;
import java.util.List;

public class EmployeeUtil {

	List<Employee> employees = new ArrayList<>();

	public void addEmployee(Employee employee) {
		employees.add(employee);

	}

	public Employee getEmployee(int empId) {

		for (Employee employee : employees) {
			if (employee.getId() == empId) {
				return employee;
			}
		}
		return null;
	}

	public double calculateHRA(Employee employee) {
		employee.setHra(employee.getSalary() * 1.1);
		return employee.getHra();
	}

	public double calculateGrossSalary(Employee employee) {
		employee.setGrossSalary(employee.getSalary() + employee.getHra());
		return employee.getGrossSalary();
	}

	public void deleteEmployee(int empId) {
		Employee employee = getEmployee(empId);
		if (employee == null) {
			System.out.println("Employee does not exist");
		} else {
			employees.remove(employee);
			System.out.println("Employee Deleted Successfully");
		}
	}

	public List<Employee> showAllEmployees() {
		return employees;
	}

}
