package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.EmployeeNotFoundException;
import com.exception.TaxCalculationException;
import com.model.Tax;
import com.util.DBUtil;

public class TaxDaoImpl implements TaxDao {

	@Override
	public Tax getTaxById(int id) throws SQLException, TaxCalculationException {
       
		Connection conn=DBUtil.getDBConn();
		
		String sql="Select * from employee where id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		
		ResultSet rst= pstmt.executeQuery();
		
		if(rst.next())
		{
			int tid=rst.getInt("id");
			int empid=rst.getInt("employee_id");
			int taxyear=rst.getInt("tax_year");
			Double taxableincome =rst.getDouble("taxable_income");
			Double taxamount =rst.getDouble("tax_amount");
			
			Tax tax=new Tax(tid,empid,taxyear,taxableincome,taxamount);
			
			return tax;
		}
		DBUtil.dbClose();
		throw new TaxCalculationException("Invalid Tax Id");
		
	}

	@Override
	public List<Tax> getTaxByEmployeeId(int eid) throws SQLException, EmployeeNotFoundException {
		Connection conn=DBUtil.getDBConn();
		List<Tax> list=new ArrayList<>();
		String sql="Select * from tax where employee_id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1, eid);
		
		ResultSet rst= pstmt.executeQuery();
		
		while(rst.next())
		{
			int tid=rst.getInt("id");
			int empid=rst.getInt("employee_id");
			int taxyear=rst.getInt("tax_year");
			Double taxableincome =rst.getDouble("taxable_income");
			Double taxamount =rst.getDouble("tax_amount");
			
			Tax tax=new Tax(tid,empid,taxyear,taxableincome,taxamount);
			
			list.add(tax);
		}
		DBUtil.dbClose();
		if(list.isEmpty())
		{
			throw new EmployeeNotFoundException("Invalid Employee Id");
		}
		return list;
	}

	@Override
	public List<Tax> getTaxForYear(int year) throws TaxCalculationException, SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from tax where tax_year>=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setObject(1, year);
		List<Tax> list=new ArrayList<>();
		
		ResultSet rst= pstmt.executeQuery();
		
		while(rst.next())
		{
			int tid=rst.getInt("id");
			int empid=rst.getInt("employee_id");
			int taxyear=rst.getInt("tax_year");
			Double taxableincome =rst.getDouble("taxable_income");
			Double taxamount =rst.getDouble("tax_amount");
			
			Tax tax=new Tax(tid,empid,taxyear,taxableincome,taxamount);
			
			list.add(tax);
		}
		DBUtil.dbClose();
		if(list.isEmpty())
		{
			throw new TaxCalculationException("No tax in the specified year");
		}
		return list;

	}

	@Override
	public double calculateTax(int empid, int taxyear) throws SQLException {
Connection conn=DBUtil.getDBConn();
		
		String sql="select Tax_Amount from tax where employee_id=? and Tax_year=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1,empid);
		pstmt.setInt(2, taxyear);
		
		ResultSet rst=pstmt.executeQuery();
		double tax = 0;
		if(rst.next())
		{
			tax=rst.getDouble("Tax_Amount");
		}
		
		DBUtil.dbClose();
		
		return tax;
	}


	}

	
	
