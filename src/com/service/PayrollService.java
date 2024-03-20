package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.PayrollDao;
import com.dao.PayrollDaoImpl;
import com.exception.EmployeeNotFoundException;
import com.exception.PayrollGenerationException;
import com.model.Payroll;

public class PayrollService {

	PayrollDao payrollDao=new PayrollDaoImpl();
	public Payroll getPayrollById(int id) throws SQLException,PayrollGenerationException {
		return payrollDao.getPayrollById(id);
	}
	public List<Payroll> generatePayroll() throws SQLException {
		
		return payrollDao.generatePayroll();
	}
	public List<Payroll> getPayrollByEmployeeId(int eid) throws SQLException, EmployeeNotFoundException {
		
		return payrollDao.getPayrollByEmployeeId(eid);
	}
	public List<Payroll> getPayrollForPeriod(LocalDate startDate, LocalDate endDate) throws SQLException, PayrollGenerationException {
		return payrollDao.getPayrollForPeriod(startDate,endDate);
	}
	public void createEmployees(LocalDate startDate, LocalDate endDate, double salary, double opay, double deductions,
			double netSalary, int eid) throws SQLException {
		payrollDao.createEmployees(startDate,endDate,salary,opay,deductions,netSalary,eid);
	}

}
