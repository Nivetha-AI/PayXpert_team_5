package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.exception.EmployeeNotFoundException;
import com.exception.FinancialRecordException;
import com.model.FinancialRecord;
import com.service.FinancialRecordService;

public class MFinancialRecordController {

	public static void main(String[] args) {
		FinancialRecordService financialRecordService = new FinancialRecordService();
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n-------------------FINANCIAL RECORD OPERATIONS-------------------");
			System.out.println("Press 1. To Add Financial Record");
			System.out.println("Press 2. To Get Financial Record by Id");
			System.out.println("Press 3. To Get Financial Records for employee");
			System.out.println("Press 4. To Get Financial Records for date");
			System.out.println("Press 5. To Delete Financial Record for specific employee");
			System.out.println("Press 0. To exit all operations..");

			System.out.println("\nEnter the operation that you want to perform:");
			int input = sc.nextInt();

			if (input == 0) {
				System.out.println("\nExiting Financial Record Operations... Thank You!");
				break;
			}

			switch (input) {

			case 1:
				// To add Financial Record
				System.out.println("Enter Record Id: ");
				int recordId = sc.nextInt();
				System.out.println("Enter employee Id: ");
				int empId = sc.nextInt();
				try {
					int found = financialRecordService.verifyEmployeeId(empId);
					System.out.println("Employee found for the id : " + found);
					System.out.println("Enter date of the financial record: (yyyy-mm-dd) ");
					String date = sc.next().trim();
					LocalDate recordDate = LocalDate.parse(date);
					System.out.println(
							"Enter the description for the record: (Income / Bills / Invoices / Salary / Tax  / Investment ");
					String description = sc.next();
					System.out.println("Enter the amount: ");
					double amount = sc.nextDouble();
					System.out.println("Enter the record type: (Income / Expense / Tax  / Payroll / Assets");
					String recordType = sc.next();
					financialRecordService.AddFinancialRecord(recordId, empId, recordDate, description, amount,
							recordType);
					System.out.println("\nFinancial Record added successfully\n");
				} catch (EmployeeNotFoundException | DateTimeParseException | SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				// To get Financial Record by id
				System.out.println("Enter the Financial Record id: ");
				int recId = sc.nextInt();
				try {
					FinancialRecord financialRecord = financialRecordService.getFinancialRecordById(recId);
					System.out.println("Financial Record Details for given record id :");
					System.out.println(financialRecord);
					System.out.println();
				} catch (FinancialRecordException | SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				// To get financial record by employee id
				System.out.println("Enter Employee id: ");
				int employeeID = sc.nextInt();

				try {
					int empFound = financialRecordService.verifyEmployeeId(employeeID);
					System.out.println("Employee found with id : " + empFound);
					List<FinancialRecord> list = financialRecordService.getFinancialRecordsForEmployee(employeeID);
					System.out.println("Financial Record Details: ");
					for (FinancialRecord f : list) {
						System.out.println(f);
					}
					System.out.println();
				} catch (EmployeeNotFoundException | SQLException | FinancialRecordException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				// To get financial records for specific date
				System.out.println("Enter the date for which the record is to be fetched: ");
				String date = sc.next().trim();
				LocalDate recordDate = LocalDate.parse(date);
				List<FinancialRecord> list;
				try {
					list = financialRecordService.getFinancialRecordsForDate(recordDate);
					System.out.println("Financial Records found on the date : " + date);
					for (FinancialRecord f : list) {
						System.out.println(f);
					}
					System.out.println();
				} catch (FinancialRecordException | SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				// To delete financial record for specific employee
				System.out.println("Enter the employee id for whom the records are to be deleted: ");
				int empID = sc.nextInt();
				try {
					financialRecordService.verifyEmployeeId(empID);
					financialRecordService.removeFinancialRecordByEmployee(empID);
					System.out.println("Financial Record for specified employee removed successfully");
					System.out.println();
				} catch (EmployeeNotFoundException | SQLException | FinancialRecordException e) {
					System.out.println(e.getMessage());
				}
				break;

			}// switch ends

		
		} // while end
		sc.close();
	}

}
