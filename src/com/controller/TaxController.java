package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.exception.EmployeeNotFoundException;
import com.exception.TaxCalculationException;
import com.model.Tax;
import com.service.TaxService;

public class TaxController {
	
	
	public static void main(String[] args) throws TaxCalculationException {
		Scanner s=new Scanner(System.in);
		TaxService taxService=new TaxService();
		while(true)
		{
			System.out.println("Press 1. GetTaxForEmployee");
			System.out.println("Press 2. GetTaxForYear");
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
						System.out.println("Enter the Employee Id");
						int emid = s.nextInt();
						try {
							List<Tax> list = taxService.getTaxByEmployeeId(emid);
							System.out.println("**************************** Tax of EmployeeId: "+emid+" *************************");
							System.out.println();
							System.out.println("tax_id "+" employee_id "+" taxable_income "+" tax_year "+" tax_amount ");
							for(Tax t:list)
							{
								System.out.println(t.getId()+"\t\t"+t.getEmployeeId()+"\t\t"+t.getTaxableincome()+"\t"+t.getAmount()+"\t   "+t.getTaxyear());
								
								}
							System.out.println();
							System.out.println("*******************************************************************************");
					} catch (SQLException | EmployeeNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.println("Enter the tax year");
					int year=s.nextInt();
					try {
						List<Tax> list = taxService.getTaxForYear(year);
						System.out.println("**************************** Tax for period "+year+" ********************");
						System.out.println();
						System.out.println("tax_id "+" employee_id "+" taxable_income "+" tax_year "+" tax_amount ");
						for(Tax t:list)
						{
							System.out.println(t.getId()+"\t\t"+t.getEmployeeId()+"\t\t"+t.getTaxableincome()+"\t"+t.getAmount()+"\t   "+t.getTaxyear());
						}
						System.out.println();
						System.out.println("***********************************************************************************************");
					
					} catch (SQLException |TaxCalculationException e) {
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