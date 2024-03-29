package com.service;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.FinancialRecordDao;
import com.dao.FinancialRecordDaoImpl;

import com.exception.EmployeeNotFoundException;
import com.exception.FinancialRecordException;
import com.model.FinancialRecord;

public class FinancialRecordService {
	FinancialRecordDao financialRecordDao = new FinancialRecordDaoImpl();

	public int verifyEmployeeId(int empId) throws EmployeeNotFoundException, SQLException{
		return financialRecordDao.verifyEmployeeId(empId);
	}

	public void addFinancialRecord(int recordId, int empId, LocalDate recordDate, String description, double amount,
			String recordType) throws SQLException {
		financialRecordDao.addFinancialRecord(recordId, empId, recordDate, description, amount, recordType);	
	}

	public FinancialRecord getFinancialRecordById(int recId) throws FinancialRecordException, SQLException{
		return financialRecordDao.getFinancialRecordById(recId);
	}

	public List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId) throws FinancialRecordException, SQLException {
		return financialRecordDao.getFinancialRecordsForEmployee(employeeId);
	}

	public List<FinancialRecord> getFinancialRecordsForDate(LocalDate recordDate) throws FinancialRecordException, SQLException {
		return financialRecordDao.getFinancialRecordsForDate(recordDate);
	}

	public void removeFinancialRecordByEmployee(int empID) throws SQLException, FinancialRecordException {
		financialRecordDao.removeFinancialRecordByEmployee(empID);	
	}

}
