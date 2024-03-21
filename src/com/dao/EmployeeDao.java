package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dto.EmployeeReportData;
import com.exception.EmployeeNotFoundException;
import com.exception.FinancialRecordException;
import com.model.Employee;

public interface EmployeeDao {
	public Employee getEmployeeById(int emid) throws SQLException, EmployeeNotFoundException;

	public List<Employee> getAllEmployee() throws SQLException;

	public void AddEmployee(Employee emp) throws SQLException;

	public void updateEmployee(int eid, String efname, String elname, LocalDate edob, String egender, String eemail,
			String ephonenumber, String eaddress, String eposition, LocalDate ejoiningdate)
			throws SQLException, EmployeeNotFoundException;

	public void deleteEmployee(int id) throws EmployeeNotFoundException, SQLException;

	public List<EmployeeReportData> getReport(int empid, int fyear) throws SQLException, FinancialRecordException;

}
