package com.imcs.maven.TestingMavenApp;

import java.util.Scanner;

import com.maven.testing.TestingMaven.Employee;
import com.maven.testing.TestingMaven.EmployeeArrayOperations;
import com.maven.testing.TestingMaven.Gender;

public class EmployeeApp {

	public static void main(String[] args) {

		int numberOfEmployees;
		int choice;
		int empId;
		EmployeeArrayOperations employeeArrayOperations = new EmployeeArrayOperations();
		Scanner scanner = new Scanner(System.in);

		System.out.print("How many Employees do you wish to create? ");
		numberOfEmployees = scanner.nextInt();

		do {
			System.out.print("\n||| Menu|||" + "\n 1. Create Employee" + "\n 2. View Employee"
					+ "\n 3. View All Employees" + "\n 4. Update Employee" + "\n 5. Delete Employee"
					+ "\n 6. Calculate HRA" + "\n 7. Calculate Gross Salary" + "\n 8. Exit" + "\n Select a choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				for (int i = 0; i < numberOfEmployees; i++) {
					System.out.print("Enter Employee ID: ");
					int id = scanner.nextInt();
					System.out.print("Enter Employee First Name: ");
					String firstName = scanner.next();
					System.out.print("Enter Employee Last Name: ");
					String lastName = scanner.next();
					System.out.print("Enter Employee Salary: ");
					double salary = scanner.nextDouble();
					System.out.println("Enter Employee Gender: ");
					System.out.println("1." + Gender.MALE);
					System.out.println("2." + Gender.FEMALE);
					int g = scanner.nextInt();
					Gender gender = null;
					if (g == 1) {
						// String gender="Male";
						gender = Gender.MALE;
					} else if (g == 2) {
						gender = Gender.FEMALE;
					}
					Employee employee = new Employee(id, firstName, lastName, salary, gender);
					employeeArrayOperations.addEmployee(employee);
				}
				break;

			case 2:
				System.out.print("Enter Employee id:");
				empId = scanner.nextInt();
				System.out.println(employeeArrayOperations.getEmployee(empId));
				break;

			case 3:
				System.out.println(employeeArrayOperations.showAllEmployees());
				break;

			case 4:

				int updateChoice;

				System.out.print("Enter Employee id:");
				empId = scanner.nextInt();
				Employee employee = employeeArrayOperations.getEmployee(empId);
				System.out.println(employee);

				do {
					System.out.print(
							"What do you want to update? " + "\n Enter 1 for First Name." + "\n Enter 2 for Last Name."
									+ "\n Enter 3 for Salary" + "\n Enter 4 for Gender" + "\n Enter 5 for Exit: \n");
					updateChoice = scanner.nextInt();

					System.out.println("Employee ID: " + employee.getId());
					if (updateChoice == 1) {
						System.out.print("Enter Employee First Name: ");
						employee.setFirstName(scanner.next());
						System.out.println("First Name Updated");
					} else if (updateChoice == 2) {
						System.out.println("Enter Employee Last Name: ");
						employee.setLastName(scanner.next());
						System.out.println("Last Name Updated");
					} else if (updateChoice == 3) {
						System.out.print("Enter Employee Salary: ");
						employee.setSalary(scanner.nextDouble());
						System.out.println("Salary Updated");
					} else if (updateChoice == 4) {
						System.out.println("Enter Employee Gender: ");
						System.out.println("1." + Gender.MALE);
						System.out.println("2." + Gender.FEMALE);
						int g = scanner.nextInt();
						if (g == 1) {
							employee.setGender(Gender.MALE);
							System.out.println("Gender set to Male");
						} else if (g == 2) {
							employee.setGender(Gender.FEMALE);
							System.out.println("Gender set to Female");
						}
					}
				} while (!(updateChoice == 5));
				break;

			case 5:
				System.out.print("Enter Employee id you want to delete: ");
				empId = scanner.nextInt();
				employeeArrayOperations.deleteEmployee(empId);
				break;

			case 6:
				System.out.print("Enter Employee id:");
				empId = scanner.nextInt();
				double hra = employeeArrayOperations.calculateHRA(empId);
				System.out.println("HRA of Employee id " + empId + " is " + hra);
				break;

			case 7:
				System.out.print("Enter Employee id:");
				empId = scanner.nextInt();
				double grossSalary = employeeArrayOperations.calculateGrossSalary(empId);
				System.out.println("Gross Salary of Employee id " + empId + " is " + grossSalary);
				break;

			default:
				System.out.println("Wrong Choice!! ;-(");
				break;
			}
		} while (!(choice == 8));
	}
}
