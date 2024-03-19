package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.exception.EmployeeNotFoundException;
import com.exception.PayrollGenerationException;
import com.model.Payroll;

public interface PayrollDao {

	public Payroll getPayrollById(int id) throws SQLException,PayrollGenerationException;

	List<Payroll> generatePayroll() throws SQLException;

	public Payroll getPayrollByEmployeeId(int empid) throws SQLException,EmployeeNotFoundException;

	public List<Payroll> getPayrollForPeriod(LocalDate startDate, LocalDate endDate) throws SQLException, PayrollGenerationException;
	

}
