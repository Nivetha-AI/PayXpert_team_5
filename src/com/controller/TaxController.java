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
			System.out.println("Press 1. Calculate Tax");
			System.out.println("Press 2. Get Tax by ID");
			System.out.println("Press 3. GetTaxForEmployee");
			System.out.println("Press 4. GetTaxForYear");
			System.out.println("Press 5. Add Tax Record");
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
				    System.out.println("Calculate Tax");
				    System.out.println("Enter employee id ");
					int empid=s.nextInt();
					System.out.println("Enter the Tax Year");
					int taxyear=s.nextInt();
					try {
						double tax=taxService.calculateTax(empid,taxyear);
						System.out.println("The tax amount for "+empid+" is "+tax);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					
				
				case 2:
					System.out.println("Get Tax By Id");
					System.out.println("Enter Tax Id");
					int id = s.nextInt();
					try {
						Tax tax = TaxService.getTaxById(id);
						System.out.println(tax);
					} 
					catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 3:
					System.out.println("Get Tax for Employee");
					System.out.println("Enter the Employee Id");
					int eid = s.nextInt();
					try {
						List<Tax> tax = taxService.getTaxByEmployeeId(eid);
						System.out.println(tax);
					} catch (SQLException | EmployeeNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Tax for year");
					System.out.println("Enter the tax");
					int year=s.nextInt();
					try {
						List<Tax> list = taxService.getTaxForYear(year);
						for (Tax t : list) {
							System.out.println(t);
						}
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