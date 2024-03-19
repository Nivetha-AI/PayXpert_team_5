package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import com.exception.EmployeeNotFoundException;
import com.exception.PayrollGenerationException;
import com.model.Payroll;
import com.service.PayrollService;

public class PayrollController {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		PayrollService payrollService=new PayrollService();
		while(true)
		{
			System.out.println("Press 1. Generate Payroll");
			System.out.println("Press 2. Get Payroll by ID");
			System.out.println("Press 3. GetPayrollsForEmployee");
			System.out.println("Press 4. GetPayrollsForPeriod");
			System.out.println("Press 0. Exit");
			int input=s.nextInt();
			if(input==0)
			{
				System.out.println("Exiting... Thank you");
				break;
			}
			switch(input)
			{
				case 1:
					System.out.println("Generating Payroll");
					try {
						List<Payroll> list = payrollService.generatePayroll();
						for (Payroll p : list) {
							System.out.println(p);
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.println("Get Payroll By Id");
					System.out.println("Enter payroll Id");
					int id = s.nextInt();
					try {
						Payroll payroll = payrollService.getPayrollById(id);
						System.out.println(payroll);
					} catch (SQLException | PayrollGenerationException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.println("Get Payroll for Employee");
					System.out.println("Enter the Employee Id");
					int eid = s.nextInt();
					try {
						Payroll payroll = payrollService.getPayrollByEmployeeId(eid);
						System.out.println(payroll);
					} catch (SQLException | EmployeeNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Payroll for Period");
					System.out.println("Enter the payroll start date");
					String date1=s.next();
					System.out.println("Enter the payroll end date");
					String date2=s.next();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			        LocalDate startDate=LocalDate.parse(date1, formatter);
					LocalDate endDate = LocalDate.parse(date2, formatter);
					try {
						List<Payroll> list = payrollService.getPayrollForPeriod(startDate, endDate);
						for (Payroll p : list) {
							System.out.println(p);
						}
					} catch (SQLException |PayrollGenerationException e) {
						System.out.println(e.getMessage());
					}
			        break;
				default:
					System.out.println("Invalid Input");
					break;
				
			}// Switch ends
		}//while Ends
	}//main ends
}//class ends
