
package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.TaxDaoImpl;
import com.exception.EmployeeNotFoundException;
import com.exception.TaxCalculationException;
import com.model.Tax;
import com.dao.TaxDao;

public class TaxService {

	static TaxDao taxDao=new TaxDaoImpl();
	
	public List<Tax> getTaxByEmployeeId(int eid) throws SQLException, EmployeeNotFoundException {
		
		return taxDao.getTaxByEmployeeId(eid);
	}
	public List<Tax> getTaxForYear(int year) throws SQLException, TaxCalculationException {
		return taxDao.getTaxForYear(year);
	
	
	
	}
	public static Tax getTaxById(int id) throws SQLException, TaxCalculationException {
		return taxDao.getTaxById(id);
	}
	
	public double calculateTax(int empid, int taxyear) throws SQLException {
		return taxDao.calculateTax(empid,taxyear);
	}
	public void createEmployees(int years, double taxincome, double amount, int emid) throws SQLException {
		taxDao.createEmployees(years,taxincome,amount,emid);
		
	}

			


	}
	



