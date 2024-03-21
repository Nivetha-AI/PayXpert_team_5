package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.EmployeeNotFoundException;
import com.exception.TaxCalculationException;
import com.model.Tax;

public interface TaxDao {

	public Tax getTaxById(int id) throws SQLException,TaxCalculationException;


	public List<Tax> getTaxByEmployeeId(int eid) throws SQLException,EmployeeNotFoundException;



	public List<Tax> getTaxForYear(int year) throws SQLException, TaxCalculationException ;


	public double calculateTax(int empid, int taxyear)throws SQLException;
	

}

