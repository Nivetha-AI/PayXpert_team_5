package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.dto.EmployeeReportData;
import com.exception.EmployeeNotFoundException;
import com.exception.FinancialRecordException;
import com.exception.ValidationException;
import com.model.Employee;
import com.service.EmployeeService;
import com.service.ValidationService;

public class EmployeeController {
	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeService();
		ValidationService validationService = new ValidationService();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter UserName: ");
		String username = sc.next().trim();
		try {
			validationService.validateUser(username);
			System.out.println("Enter password: ");
			int password = sc.nextInt();
			validationService.validatePassword(username, password);
			System.out.println("User verified successfully\n");
			int employeeId = validationService.getEmployeeId(username);
			String position = validationService.getPositionForEmployee(employeeId);
			System.out.println("You are a " + position);
			if (position.trim().equalsIgnoreCase("manager")) { // case for manager

				while (true) {
					System.out.println("************Employee Info System for Manager************");
					System.out.println("Press 1. Get all the Employees by ID ");
					System.out.println("Press 2. to fetch all Employee records ");
					System.out.println("Press 3. to insert the Employee record ");
					System.out.println("Press 4. to Update all the employees record");
					System.out.println("press 5. to Delete the Employee record ");
					System.out.println(
							"press 6. to Generate detail report including Tax and Financial Record for Employee based on Financial year");
					System.out.println("Press 0. to Exit");
					System.out.println("**********************************************");

					int input = sc.nextInt();

					if (input == 0) {
						System.out.println("Existing ... Thank You");
						break;
					}
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

					switch (input) {
					case 1:
						System.out.println("***SINGLE EMPLOYEE DETAILS");
						System.out.println("Enter employee Id : ");
						int emid = sc.nextInt();

						try {
							Employee e = employeeService.getEmployeeById(emid);
							System.out.println(e);
						} catch (SQLException e) {// if query goes wrong
							System.out.println(e.getMessage());
						} catch (EmployeeNotFoundException e) {// if id is invalid
							System.out.println(e.getMessage());
						}
						break;

					case 2:

						try {
							List<Employee> list = employeeService.getAllEmployee();
							// Iterate over list
							System.out.println("**********ALL EMPLOYEES *********************");

							for (Employee e : list) {
								System.out.println("Employee ID: " + e.getId() + "\t " + "First Name: "
										+ e.getFirstName() + " \t" + "Last Name: " + e.getLastName() + "\t " + "DOB: "
										+ e.getDateOfBirth() + " \t" + "Gender: " + e.getGender() + "\t " + "\"Email : "
										+ e.getEmail() + " \t" + "Phone Num: " + e.getPhoneNum() + " \t" + "Address: "
										+ e.getAddress() + " \t" + "Position: " + e.getPosition() + "\t "
										+ "Joining Date: " + e.getJoiningDate() + " \t" + "Termination Date: "
										+ e.getTerminationDate());

							}
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						}

						break;

					case 3:

						System.out.println("Enter first name ");
						sc.nextLine();
						String firstName = sc.nextLine();
						System.out.println("Enter last name ");
						String lastName = sc.nextLine();
						System.out.println("Enter DOB (YYYY-MM-DD): ");
						String dateOfBirthStr = sc.next();
						LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
						System.out.println("Enter gender ");
						String gender = sc.next();
						System.out.println("Enter email");
						String email = sc.next();
						System.out.println("Enter phone Number");
						String phoneNum = sc.next();
						System.out.println("Enter Address ");
						String address = sc.next();
						System.out.println("Enter Position");
						String position1 = sc.next();

						// insert the record in db
						Employee emp = new Employee(firstName, lastName, dateOfBirth, gender, email, phoneNum, address,
								position1, LocalDate.now(), null);

						try {
							employeeService.AddEmployee(emp);
							System.out.println("Employee inserted in DB");
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						} catch (Exception e) {
							System.out.println("Insertion error:" + e.getMessage());
						}

						break;

					case 4:

						System.out.println("Enter employee ID to update");
						int eid = sc.nextInt();
						System.out.println("Enter updated first name");

						String efname = sc.next();
						System.out.println("Enter updated last name");
						String elname = sc.next();
						System.out.println("Enter updated dob : yyyy-mm-dd");
						String edob1 = sc.next();
						LocalDate edob = LocalDate.parse(edob1, formatter);
						System.out.println("Enter updated gender");
						String egender = sc.next();
						System.out.println("Enter updated email ");
						String eemail = sc.next();
						System.out.println("Enter updated Phone number ");
						String ephonenumber = sc.next();
						System.out.println("Enter updated Address ");
						String eaddress = sc.next();
						System.out.println("Enter updated Position ");
						String eposition = sc.next();
						System.out.println("Enter updated joining date:yyyy-mm-dd  ");
						String ejoiningdate1 = sc.next();
						LocalDate ejoiningdate = LocalDate.parse(ejoiningdate1, formatter);

						try {
							employeeService.updateEmployee(eid, efname, elname, edob, egender, eemail, ephonenumber,
									eaddress, eposition, ejoiningdate);
							System.out.println("Record updated");
						} catch (SQLException | EmployeeNotFoundException e) {
							System.out.println(e.getMessage());
						}

						break;
					case 5:

						System.out.println("Enter Employee Id to Delete");
						int id = sc.nextInt();
						try {
							employeeService.deleteEmployee(id);
							System.out.println("Employee Deleted");
						} catch (EmployeeNotFoundException | SQLException e) {
							System.out.println(e.getMessage());
						}

						break;

					case 6:
						System.out.println("Enter employee Id : ");
						int empid = sc.nextInt();
						System.out.println("Enter Financial Year (YYYY): ");
						String fyear1 = sc.next();
						int fyear = Integer.parseInt(fyear1);
						try {
							List<EmployeeReportData> list = employeeService.getReport(empid, fyear);

							for (EmployeeReportData emp1 : list) {
								System.out.println(" First Name: " + emp1.getFirstName() + " Last Name: "
										+ emp1.getLastName() + " Taxable Income: " + emp1.getTaxableIncome()
										+ " Tax Year: " + emp1.getTaxYear() + "  Tax Amount: " + emp1.getTaxAmount()
										+ " Record Date: " + emp1.getRecordDate() + " record Type: "
										+ emp1.getRecordType() + " Financial Amount: " + emp1.getAmount());
							}
						} catch (SQLException | FinancialRecordException e) {
							System.out.println(e.getMessage());
						}

						break;
					default:
						System.out.println("Invalid Input given..");
						break;

					}// switch ends

				} // while ends
			} // if ends
			else {// case for employee
				while (true) {
					System.out.println("************Employee Info System for Employee************");
					System.out.println("Press 1. Get all the Employees by ID ");
					System.out.println(
							"press 2. to Generate detail report including Tax and Financial Record for Employee based on Financial year");
					System.out.println("Press 0. to Exit");
					System.out.println("**********************************************");

					int input = sc.nextInt();

					if (input == 0) {
						System.out.println("Existing ... Thank You");
						break;
					}

					switch (input) {
					case 1:
						System.out.println("***SINGLE EMPLOYEE DETAILS");
						System.out.println("Enter employee Id : ");
						int emid = sc.nextInt();

						try {
							Employee e = employeeService.getEmployeeById(emid);
							System.out.println(e);
						} catch (SQLException e) {// if query goes wrong
							System.out.println(e.getMessage());
						} catch (EmployeeNotFoundException e) {// if id is invalid
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						System.out.println("Enter employee Id : ");
						int empid = sc.nextInt();
						System.out.println("Enter Financial Year (YYYY): ");
						String fyear1 = sc.next();
						int fyear = Integer.parseInt(fyear1);
						try {
							List<EmployeeReportData> list = employeeService.getReport(empid, fyear);

							for (EmployeeReportData emp1 : list) {
								System.out.println(" First Name: " + emp1.getFirstName() + " Last Name: "
										+ emp1.getLastName() + " Taxable Income: " + emp1.getTaxableIncome()
										+ " Tax Year: " + emp1.getTaxYear() + "  Tax Amount: " + emp1.getTaxAmount()
										+ " Record Date: " + emp1.getRecordDate() + " record Type: "
										+ emp1.getRecordType() + " Financial Amount: " + emp1.getAmount());
							}
						} catch (SQLException | FinancialRecordException e) {
							System.out.println(e.getMessage());
						}

						break;

					default:
						System.out.println("Invalid Input given..");
						break;
					}// switch ends employee
				} // while ends employee
			} // else ends
		} // try ends
		catch (SQLException | EmployeeNotFoundException | ValidationException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}// main ends
}// class ends
