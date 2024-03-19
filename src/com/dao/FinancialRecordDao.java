package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.exception.EmployeeNotFoundException;
import com.exception.FinancialRecordException;
import com.model.FinancialRecord;

public interface FinancialRecordDao {

	int verifyEmployeeId(int empId)throws EmployeeNotFoundException, SQLException;

	void AddFinancialRecord(int recordId, int empId, LocalDate recordDate, String description, double amount,
			String recordType)throws SQLException;

	FinancialRecord getFinancialRecordById(int recId) throws FinancialRecordException, SQLException;

	List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId)throws FinancialRecordException, SQLException;

}
