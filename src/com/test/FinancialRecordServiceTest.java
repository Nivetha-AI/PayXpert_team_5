package com.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.exception.FinancialRecordException;
import com.model.FinancialRecord;
import com.service.FinancialRecordService;

public class FinancialRecordServiceTest {
	FinancialRecordService financialRecordService = new FinancialRecordService();

	@Test
	public void getFinancialRecordByIdTest() {

		// Use case 1
		int id = 103;
		FinancialRecord expectedRecord = new FinancialRecord(103, 3, LocalDate.parse("2024-02-21"), "Bills", 3000,
				"Expense");
		try {
			Assert.assertEquals(expectedRecord, financialRecordService.getFinancialRecordById(id));
		} catch (FinancialRecordException e) {
			Assert.assertEquals("Financial Record not found", e.getMessage());
		} catch (SQLException e) {
		}

		// Use case 2
		id = 104;
		expectedRecord = new FinancialRecord(104, 4, LocalDate.parse("2024-01-27"), "Salary", 50000, "Payroll");
		try {
			Assert.assertEquals(expectedRecord, financialRecordService.getFinancialRecordById(id));
		} catch (FinancialRecordException e) {
			Assert.assertEquals("Financial Record not found", e.getMessage());
		} catch (SQLException e) {
		}

		// Use case 3
		id = 106;
		expectedRecord = new FinancialRecord(103, 3, LocalDate.parse("2024-02-21"), "Bills", 3000, "Expense");
		try {
			Assert.assertEquals(expectedRecord, financialRecordService.getFinancialRecordById(id));
		} catch (FinancialRecordException e) {
			Assert.assertEquals("Financial Record not found", e.getMessage());
		} catch (SQLException e) {
		}

	}

	@Test
	public void getFinancialRecordsForEmployeeTest() {

		// Use case 1
		List<FinancialRecord> list = new ArrayList<>();
		int empId = 3;
		FinancialRecord expectedRecord = new FinancialRecord(103, 3, LocalDate.parse("2024-02-21"), "Bills", 3000,
				"Expense");
		list.add(expectedRecord);
		try {
			Assert.assertEquals(list, financialRecordService.getFinancialRecordsForEmployee(empId));
		} catch (FinancialRecordException e) {
			Assert.assertEquals("No financial record found for the given employee", e.getMessage());
		} catch (SQLException e) {
		}

		// Use case 2
		list = new ArrayList<>();
		empId = 1;
		expectedRecord = new FinancialRecord(103, 3, LocalDate.parse("2024-02-21"), "Bills", 3000, "Expense");
		list.add(expectedRecord);
		try {
			Assert.assertEquals(list, financialRecordService.getFinancialRecordsForEmployee(empId));
		} catch (FinancialRecordException e) {
			Assert.assertEquals("No financial record found for the given employee", e.getMessage());
		} catch (SQLException e) {
		}

		// Use case 3
		List<FinancialRecord> list1 = new ArrayList<>();
		empId = 104;
		expectedRecord = new FinancialRecord(104, 4, LocalDate.parse("2024-01-27"), "Salary", 50000, "Payroll");

		list1.add(expectedRecord);
		try {
			Assert.assertEquals(list1, financialRecordService.getFinancialRecordsForEmployee(empId));
		} catch (FinancialRecordException e) {
			Assert.assertEquals("No financial record found for the given employee", e.getMessage());
		} catch (SQLException e) {
		}

	}

	@Test
	public void getFinancialRecordsForDateTest() {

		// Use case 1
		List<FinancialRecord> list = new ArrayList<>();
		LocalDate recDate = LocalDate.parse("2024-02-21");
		FinancialRecord expectedRecord = new FinancialRecord(103, 3, LocalDate.parse("2024-02-21"), "Bills", 3000,
				"Expense");
		list.add(expectedRecord);
		try {
			Assert.assertEquals(list, financialRecordService.getFinancialRecordsForDate(recDate));
		} catch (FinancialRecordException e) {
			Assert.assertEquals("No financial record found for the given date", e.getMessage());
		} catch (SQLException e) {
		}

		// Use case 2
		list = new ArrayList<>();
		recDate = LocalDate.parse("2023-02-21");
		expectedRecord = new FinancialRecord(103, 3, LocalDate.parse("2024-02-21"), "Bills", 3000, "Expense");
		list.add(expectedRecord);
		try {
			Assert.assertEquals(list, financialRecordService.getFinancialRecordsForDate(recDate));
		} catch (FinancialRecordException e) {
			Assert.assertEquals("No financial record found for the given date", e.getMessage());
		} catch (SQLException e) {
		}

		// Use case 3
		List<FinancialRecord> list1 = new ArrayList<>();
		recDate = LocalDate.parse("2024-01-27");
		expectedRecord = new FinancialRecord(104, 4, LocalDate.parse("2024-01-27"), "Salary", 50000, "Payroll");

		list1.add(expectedRecord);
		try {
			Assert.assertEquals(list1, financialRecordService.getFinancialRecordsForDate(recDate));
		} catch (FinancialRecordException e) {
			Assert.assertEquals("No financial record found for the given date", e.getMessage());
		} catch (SQLException e) {
		}

	}

}
