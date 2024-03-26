package com.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dto.EmployeeReportData;
import com.exception.EmployeeNotFoundException;
import com.exception.FinancialRecordException;
import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeServiceTest {
	EmployeeService employeeService = new EmployeeService();

	@Test
	public void getEmployeeByIdTest() {
		// Use case 1
		int emid = 12;
		Employee expectedEmployee = new Employee(12, "Ganesh", "Gupta", LocalDate.parse("2002-03-22"), "Male",
				"ganesh@gmail.com", "8657815451", "Chennai", "Manager", LocalDate.parse("2022-03-19"), null);
		try {
			Assert.assertEquals(expectedEmployee, employeeService.getEmployeeById(emid));
		} catch (EmployeeNotFoundException e) {
			Assert.assertEquals("Invalid ID given".toLowerCase(), e.getMessage().toLowerCase());
		} catch (SQLException e) {
		}

		// Use case 2
		emid = 18;
		expectedEmployee = new Employee(18, "Nivetha", "T", LocalDate.parse("2003-03-29"), "Female", "nive@gmail.com",
				"788900766", "cbe", "manager", LocalDate.parse("2023-07-29"), LocalDate.parse("2024-03-25"));
		try {
			Assert.assertEquals(expectedEmployee, employeeService.getEmployeeById(emid));
		} catch (EmployeeNotFoundException e) {
			Assert.assertEquals("Invalid ID given".toLowerCase(), e.getMessage().toLowerCase());
		} catch (SQLException e) {
		}
		// Use case 3
		emid = 28;
		expectedEmployee = new Employee(18, "Nivetha", "T", LocalDate.parse("2003-03-29"), "Female", "nive@gmail.com",
				"788900766", "cbe", "manager", LocalDate.parse("2023-07-29"), LocalDate.parse("2024-03-25"));
		try {
			Assert.assertEquals(expectedEmployee, employeeService.getEmployeeById(emid));
		} catch (EmployeeNotFoundException e) {
			Assert.assertEquals("Invalid ID given".toLowerCase(), e.getMessage().toLowerCase());
		} catch (SQLException e) {
		}

	}

	@Test
	public void getAllEmployee() {
		// use case 1
		try {
			List<Employee> actualList = employeeService.getAllEmployee();
			Assert.assertNotNull(actualList);
		} catch (SQLException e) {
		} catch (EmployeeNotFoundException e) {
			Assert.assertEquals("No Employee Record Found".toLowerCase(), e.getMessage().toLowerCase());
		}
	}

	public void addEmployeeTest() {
		// use case 1
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String firstName = "Nivetha";
		String lastName = "T";
		String dateOfBirthStr = "2003-03-29";
		LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
		String gender = "female";
		String email = "niv@gmail.com";
		String phoneNum = "456788";
		String address = "chennai";
		String position1 = "developer";

		Employee emp = new Employee(firstName, lastName, dateOfBirth, gender, email, phoneNum, address, position1,
				LocalDate.now(), null);
		try {
			employeeService.addEmployee(emp);
		} catch (SQLException e) {

		} catch (EmployeeNotFoundException e) {
			Assert.assertEquals("No values inserted".toLowerCase(), e.getMessage().toLowerCase());
		}

		// use case 2
		firstName = "Nivetha";
		lastName = "T";
		dateOfBirthStr = "2003-39-29";// invalid date format so values will not be inserted
		dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
		gender = "female";
		email = "niv@gmail.com";
		phoneNum = "456788";
		address = "chennai";
		position1 = "developer";

		Employee emp1 = new Employee(firstName, lastName, dateOfBirth, gender, email, phoneNum, address, position1,
				LocalDate.now(), null);
		try {
			employeeService.addEmployee(emp1);
		} catch (SQLException e) {

		} catch (EmployeeNotFoundException e) {
			Assert.assertEquals("No values inserted".toLowerCase(), e.getMessage().toLowerCase());
		}

	}

	@Test
	public void updateEmployeeTest() {
		// use case 1
		int eid = 10;
		String efname = "Ramma";
		String elname = "Devi";
		LocalDate edob = LocalDate.parse("2002-03-22");
		String egender = "Female";
		String eemail = "ram@gmail.com";
		String ephonenumber = "987766478";
		String eaddress = "Bangalore";
		String eposition = "developer";
		LocalDate ejoiningdate = LocalDate.parse("2022-03-22");

		try {
			employeeService.updateEmployee(eid, efname, elname, edob, egender, eemail, ephonenumber, eaddress,
					eposition, ejoiningdate);
		} catch (EmployeeNotFoundException e) {
			Assert.assertEquals("Employee not found to update".toLowerCase(), e.getMessage().toLowerCase());
		} catch (SQLException e) {
		}

		// use case 2// 29 not found it throws Exception
		eid = 29;
		efname = "Ramma";
		elname = "Devi";
		edob = LocalDate.parse("2002-03-22");
		egender = "Female";
		eemail = "ram@gmail.com";
		ephonenumber = "987766478";
		eaddress = "Bangalore";
		eposition = "developer";
		ejoiningdate = LocalDate.parse("2022-03-22");

		try {
			employeeService.updateEmployee(eid, efname, elname, edob, egender, eemail, ephonenumber, eaddress,
					eposition, ejoiningdate);
		} catch (EmployeeNotFoundException e) {
			Assert.assertEquals("Employee not found to update".toLowerCase(), e.getMessage().toLowerCase());
		} catch (SQLException e) {
		}
	}

	@Test
	public void deleteEmployeeTest() {
		// use case 1
		int eid = 10;
		try {
			employeeService.deleteEmployee(eid);
		} catch (EmployeeNotFoundException e) {
			Assert.assertEquals("Employee not found to delete".toLowerCase(), e.getMessage().toLowerCase());
		} catch (SQLException e) {
		}

		// use case 2// 29 not found it throws Exception
		eid = 29;
		try {
			employeeService.deleteEmployee(eid);
		} catch (EmployeeNotFoundException e) {
			Assert.assertEquals("Employee not found to delete".toLowerCase(), e.getMessage().toLowerCase());
		} catch (SQLException e) {
		}
	}

	@Test
	public void getReportTest() {
		// Use case 1
		int empid = 2;
		int fyear = Integer.parseInt("2022");
		EmployeeReportData expectedReport = new EmployeeReportData("Bala", "Ganesh", 100000, Year.parse("2024"), 15000,
				LocalDate.parse("2022-03-21"), "Tax", 3400000);
		List<EmployeeReportData> expectedList = new ArrayList<>();
		expectedList.add(expectedReport);

		try {
			Assert.assertEquals(expectedList, employeeService.getReport(empid, fyear));
		} catch (SQLException e) {

		} catch (FinancialRecordException e) {
			Assert.assertEquals(
					("Detail report for employee ID " + empid + " and financial year " + fyear + " not available.")
							.toLowerCase(),
					e.getMessage().toLowerCase());
		}

		// use case 2
		empid = 8;
		fyear = Integer.parseInt("2023");
		expectedReport = new EmployeeReportData("Deepika", "Raman", 58000, Year.parse("2021"), 5800,
				LocalDate.parse("2023-03-29"), "Expense", 20000000);
		expectedList = new ArrayList<>();
		expectedList.add(expectedReport);

		try {
			Assert.assertEquals(expectedList, employeeService.getReport(empid, fyear));
		} catch (SQLException e) {
		} catch (FinancialRecordException e) {
			Assert.assertEquals(
					("Detail report for employee ID " + empid + " and financial year " + fyear + " not available.")
							.toLowerCase(),
					e.getMessage().toLowerCase());
		}

		// use case 3
		empid = 3;
		fyear = Integer.parseInt("2020");
		expectedReport = new EmployeeReportData("Bala", "Ganesh", 100000, Year.parse("2024"), 15000,
				LocalDate.parse("2022-03-21"), "Tax", 3400000);
		expectedList = new ArrayList<>();
		expectedList.add(expectedReport);
		try {
			Assert.assertEquals(expectedList, employeeService.getReport(empid, fyear));
		} catch (SQLException e) {
		} catch (FinancialRecordException e) {
			Assert.assertEquals(
					("Detail report for employee ID " + empid + " and financial year " + fyear + " not available.")
							.toLowerCase(),
					e.getMessage().toLowerCase());
		}

	}

}
