package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.exception.TaxCalculationException;
import com.model.Tax;
import com.service.TaxService;

public class MTaxController {
	public static void main(String[] args) throws TaxCalculationException {
		Scanner s=new Scanner(System.in);
		TaxService taxService=new TaxService();
		while(true)
		{
			System.out.println("Press 1. Calculate Tax");
			System.out.println("Press 2. Get Tax by ID");
			System.out.println("Press 3. Add Tax Record");
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
					System.out.println("Enter Tax Id");
					int id = s.nextInt();
					try {
						Tax t = TaxService.getTaxById(id);
						System.out.println("********************************* Tax of id: "+id+" *******************************");
						System.out.println();
						System.out.println("tax_id "+" employee_id "+" taxable_income "+" tax_year "+" tax_amount ");
						System.out.println(t.getId()+"\t\t"+t.getEmployeeId()+"\t\t"+t.getTaxableincome()+"\t"+t.getAmount()+"\t   "+t.getTaxyear());
						System.out.println();
						System.out.println("*****************************************************************************");
					} catch (SQLException | TaxCalculationException e) {
						System.out.println(e.getMessage());
					}
					break;
			    case 3:
					System.out.println("Enter the tax year");
					int years=s.nextInt();
					System.out.println("Enter the taxable income");
					double taxincome=s.nextDouble();
					System.out.println("Enter the tax amount");
					double amount=s.nextDouble();
					System.out.println("Enter the employee Id");
					int emid=s.nextInt();
					
					try {
						taxService.createEmployees(years, taxincome, amount, emid);
						System.out.println("Employee Inserted");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Invalid Input");
					break;
				
				
			}
			}
		s.close();
		}
	}

