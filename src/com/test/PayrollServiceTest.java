package com.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.exception.EmployeeNotFoundException;
import com.exception.PayrollGenerationException;
import com.model.Payroll;
import com.service.PayrollService;

import org.junit.Assert;
import org.junit.Test;

public class PayrollServiceTest {
	
	PayrollService payrollService=new PayrollService();
	
	@Test
	public void getPayrollByIdTest()
	{
		/*Use case 1: Valid Id*/
		
		int id=2;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate=LocalDate.parse("2024-02-01", formatter);
		LocalDate endDate = LocalDate.parse("2024-02-29", formatter);
		Payroll expected=new Payroll(2,2,startDate,endDate,90000.0,10000.0,15000.0,85000.0);
		
		try {
			Assert.assertEquals(expected, payrollService.getPayrollById(id));
		} catch (SQLException | PayrollGenerationException e) {}
		
		/*Use case 2: Invalid Id*/
		
		id=29;
		try {
			Assert.assertEquals(expected, payrollService.getPayrollById(id));
		} catch (SQLException | PayrollGenerationException e) {
			Assert.assertEquals("Invalid Payroll Id".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	
	@Test
	public void getPayrollByEmployeeIdTest()
	{
		/*Use case 1: Valid Id*/
		List<Payroll> list=new ArrayList<>();
		int id=3;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate=LocalDate.parse("2024-02-01", formatter);
		LocalDate endDate = LocalDate.parse("2024-02-29", formatter);
		Payroll expected=new Payroll(3,3,startDate,endDate,80000.0,10000.0,13500.0,76500.0);
		list.add(expected);
		try {
			Assert.assertEquals(list, payrollService.getPayrollByEmployeeId(id));
		} catch (SQLException | EmployeeNotFoundException e) {}
		/*Use case 2: Invalid Id*/
		
		id=29;
		try {
			Assert.assertEquals(list, payrollService.getPayrollByEmployeeId(id));
		} catch (SQLException | EmployeeNotFoundException e) {
			Assert.assertEquals("Invalid Employee Id".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	
	
	@Test
	public void generatePayrollTest()
	{
		List<Payroll> list=new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate=LocalDate.parse("2024-02-01", formatter);
		LocalDate endDate = LocalDate.parse("2024-02-29", formatter);
		LocalDate startDate1=LocalDate.parse("2024-03-01", formatter);
		LocalDate endDate1= LocalDate.parse("2024-03-31", formatter);
		Payroll e1=new Payroll(1,1,startDate,endDate,100000.0,10000.0,22000.0,88000.0);
		Payroll e2=new Payroll(2,2,startDate,endDate,90000.0,10000.0,15000.0,85000.0);
		Payroll e3=new Payroll(3,3,startDate,endDate,80000.0,10000.0,13500.0,76500.0);
		Payroll e4=new Payroll(4,4,startDate,endDate,100000.0,10000.0,22000.0,88000.0);
		Payroll e5=new Payroll(5,5,startDate,endDate,60000.0,0.0,6000.0,54000.0);
		Payroll e6=new Payroll(6,1,startDate1,endDate1,100000.0,20000.0,24000.0,96000.0);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		try {
			Assert.assertEquals(list, payrollService.generatePayroll());
		} catch (SQLException e) {}
	}
	
	@Test
	public void GetPayrollsForPeriodTest()
	{
		/*Use case 1: Valid Dates*/
		List<Payroll> list=new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate=LocalDate.parse("2024-03-01", formatter);
		LocalDate endDate = LocalDate.parse("2024-03-31", formatter);
		Payroll expected=new Payroll(6,1,startDate,endDate,100000.0,20000.0,24000.0,96000.0);
		list.add(expected);
		try {
			Assert.assertEquals(list, payrollService.getPayrollForPeriod(startDate,endDate));
		} catch (SQLException | PayrollGenerationException e) {}
		
		/*Use case 2: Invalid Dates*/
		list=new ArrayList<>();
		
		startDate=LocalDate.parse("2024-01-01", formatter);
		endDate = LocalDate.parse("2023-01-01", formatter);
		try {
			Assert.assertEquals(expected, payrollService.getPayrollForPeriod(startDate,endDate));
		} catch (SQLException | PayrollGenerationException e) {
			Assert.assertEquals("no payrolls in the specified dates".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
}
