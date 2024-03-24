package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.exception.EmployeeNotFoundException;
import com.exception.PayrollGenerationException;
import com.model.Payroll;
import com.service.PayrollService;

public class PayrollController {
	
	// Parkkavan
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		PayrollService payrollService=new PayrollService();
		while(true)
		{
			System.out.println("Press 1. Get Payroll by ID");
			System.out.println("Press 2. GetPayrollsForEmployee");
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
					System.out.println("Enter payroll Id");
					int id = s.nextInt();
					try {
						Payroll p = payrollService.getPayrollById(id);
						System.out.println("********************************* Payroll of id: "+id+" *******************************");
						System.out.println();
						System.out.println("payroll_id "+" employee_id "+" payperiod_startdate "+" payperiod_enddate "+" Basic_salary "+" overtime_pay "+" Deductions "+" net_salary ");
						System.out.println(p.getPayrollId()+"\t\t"+p.getEmployeeId()+"\t\t"+p.getPayPeriodStartDate()+"\t"+p.getPayPeriodEndDate()+"\t   "+p.getBasicSalary()+"\t"+p.getOverTimePay()+"\t      "+p.getDeductions()+"\t   "+p.getNetSalary());
						System.out.println();
						System.out.println("*****************************************************************************");
					} catch (SQLException | PayrollGenerationException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.println("Enter the Employee Id");
					int eid = s.nextInt();
					try {
						List<Payroll> list = payrollService.getPayrollByEmployeeId(eid);
						System.out.println("**************************** Payrolls of EmployeeId: "+eid+" *************************");
						System.out.println();
						System.out.println("payroll_id "+" employee_id "+" payperiod_startdate "+" payperiod_enddate "+" Basic_salary "+" overtime_pay "+" Deductions "+" net_salary ");
						for(Payroll p:list)
						{
							System.out.println(p.getPayrollId()+"\t\t"+p.getEmployeeId()+"\t\t"+p.getPayPeriodStartDate()+"\t"+p.getPayPeriodEndDate()+"\t   "+p.getBasicSalary()+"\t"+p.getOverTimePay()+"\t      "+p.getDeductions()+"\t   "+p.getNetSalary());
						}
						System.out.println();
						System.out.println("*******************************************************************************");
					} catch (SQLException | EmployeeNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Invalid Input");
					break;
				
			}// Switch ends
		}//while Ends
		s.close();
	}//main ends
}//class ends



