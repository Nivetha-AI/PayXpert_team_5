package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exception.EmployeeNotFoundException;
import com.exception.PayrollGenerationException;
import com.model.Payroll;
import com.util.DBUtil;

public class PayrollDaoImpl implements PayrollDao {

	@Override
	public List<Payroll> generatePayroll() throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from payroll";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		List<Payroll> list=new ArrayList<>();
		
		ResultSet rst= pstmt.executeQuery();
		
		while(rst.next())
		{
			int pid=rst.getInt("id");
			LocalDate payperiodStartDate = rst. getDate("payperiod_startdate").toLocalDate();
			LocalDate payperiodEndDate = rst. getDate("payperiod_enddate").toLocalDate();
			Double basicSalary=rst.getDouble("Basic_salary");
			Double overtimePay=rst.getDouble("overtime_pay");
			Double deductions=rst.getDouble("Deductions");
			Double netSalary=rst.getDouble("net_salary");
			int eid=rst.getInt("employee_id");
			
			Payroll payroll=new Payroll(pid,eid,payperiodStartDate,payperiodEndDate,basicSalary,overtimePay,deductions,netSalary);
			
			list.add(payroll);
		}
		DBUtil.dbClose();
		return list;
	}
	
	
	@Override
	public Payroll getPayrollById(int id) throws SQLException,PayrollGenerationException {
		
		Connection conn=DBUtil.getDBConn();
		
		String sql="Select * from payroll where id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		
		ResultSet rst= pstmt.executeQuery();
		
		if(rst.next())
		{
			int pid=rst.getInt("id");
			LocalDate payperiodStartDate = rst. getDate("payperiod_startdate").toLocalDate();
			LocalDate payperiodEndDate = rst. getDate("payperiod_enddate").toLocalDate();
			Double basicSalary=rst.getDouble("Basic_salary");
			Double overtimePay=rst.getDouble("overtime_pay");
			Double deductions=rst.getDouble("Deductions");
			Double netSalary=rst.getDouble("net_salary");
			int eid=rst.getInt("employee_id");
			
			Payroll payroll=new Payroll(pid,eid,payperiodStartDate,payperiodEndDate,basicSalary,overtimePay,deductions,netSalary);
			
			return payroll;
		}
		DBUtil.dbClose();
		throw new PayrollGenerationException("Invalid Payroll Id");
	}


	@Override
	public List<Payroll> getPayrollByEmployeeId(int empid) throws SQLException,EmployeeNotFoundException {
		Connection conn=DBUtil.getDBConn();
		List<Payroll> list=new ArrayList<>();
		String sql="Select * from payroll where employee_id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1, empid);
		
		ResultSet rst= pstmt.executeQuery();
		
		while(rst.next())
		{
			int pid=rst.getInt("id");
			LocalDate payperiodStartDate = rst. getDate("payperiod_startdate").toLocalDate();
			LocalDate payperiodEndDate = rst. getDate("payperiod_enddate").toLocalDate();
			Double basicSalary=rst.getDouble("Basic_salary");
			Double overtimePay=rst.getDouble("overtime_pay");
			Double deductions=rst.getDouble("Deductions");
			Double netSalary=rst.getDouble("net_salary");
			int eid=rst.getInt("employee_id");
			
			Payroll payroll=new Payroll(pid,eid,payperiodStartDate,payperiodEndDate,basicSalary,overtimePay,deductions,netSalary);
			
			list.add(payroll);
		}
		DBUtil.dbClose();
		if(list.isEmpty())
		{
			throw new EmployeeNotFoundException("Invalid Employee Id");
		}
		return list;
	}


	@Override
	public List<Payroll> getPayrollForPeriod(LocalDate startDate, LocalDate endDate) throws SQLException, PayrollGenerationException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from payroll where payperiod_startdate>=? and payperiod_enddate<=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setObject(1, startDate);
		pstmt.setObject(2, endDate);
		List<Payroll> list=new ArrayList<>();
		
		ResultSet rst= pstmt.executeQuery();
		
		while(rst.next())
		{
			int pid=rst.getInt("id");
			LocalDate payperiodStartDate = rst. getDate("payperiod_startdate").toLocalDate();
			LocalDate payperiodEndDate = rst. getDate("payperiod_enddate").toLocalDate();
			Double basicSalary=rst.getDouble("Basic_salary");
			Double overtimePay=rst.getDouble("overtime_pay");
			Double deductions=rst.getDouble("Deductions");
			Double netSalary=rst.getDouble("net_salary");
			int eid=rst.getInt("employee_id");
			
			Payroll payroll=new Payroll(pid,eid,payperiodStartDate,payperiodEndDate,basicSalary,overtimePay,deductions,netSalary);
			
			list.add(payroll);
		}
		DBUtil.dbClose();
		if(list.isEmpty())
		{
			throw new PayrollGenerationException("No payrolls in the specified dates");
		}
		return list;
	}


	@Override
	public void createEmployees(LocalDate startDate, LocalDate endDate, double salary, double opay, double deductions,
			double netSalary, int eid) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		
		String sql="insert into payroll(payperiod_startdate,payperiod_enddate,Basic_salary,overtime_pay,Deductions,net_salary,employee_id) values(?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setObject(1, startDate);
		pstmt.setObject(2, endDate);
		pstmt.setDouble(3,salary);
		pstmt.setDouble(4,opay);
		pstmt.setDouble(5,deductions);
		pstmt.setDouble(6,netSalary);
		pstmt.setInt(7, eid);
		
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}
	
}
