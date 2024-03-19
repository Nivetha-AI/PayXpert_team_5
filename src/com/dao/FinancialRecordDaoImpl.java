package com.dao;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exception.EmployeeNotFoundException;
import com.exception.FinancialRecordException;
import com.model.FinancialRecord;



public class FinancialRecordDaoImpl implements FinancialRecordDao {

	@Override
	public int verifyEmployeeId(int empId) throws EmployeeNotFoundException, SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from employee where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, empId);
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		if(rst.next()) { 
			int empID = rst.getInt("id");
			return empID;
		}
		DBUtil.dbClose();
		throw new EmployeeNotFoundException("Employee ID given is Invalid");		
	}

	@Override
	public void AddFinancialRecord(int recordId, int empId, LocalDate recordDate, String description, double amount,
			String recordType) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql="insert into financial_record values (?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, recordId);
		pstmt.setString(2, recordDate.toString());
		pstmt.setString(3, description);
		pstmt.setDouble(4, amount);
		pstmt.setString(5, recordType);
		pstmt.setInt(6, empId);
		
		pstmt.executeUpdate();
		DBUtil.dbClose();
	}

	@Override
	public FinancialRecord getFinancialRecordById(int recId) throws FinancialRecordException, SQLException{
		Connection conn=DBUtil.getDBConn();
		String sql="select * from financial_record where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, recId);
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		if(rst.next()) { 
			int id = rst.getInt("id");
			java.sql.Date sqlrecordDate = rst.getDate("record_date");
			LocalDate recordDate = sqlrecordDate.toLocalDate();
			String description = rst.getString("description");
			double amount = rst.getDouble("amount");
			String recordType = rst.getString("record_type");
			int employeeId = rst.getInt("employee_id");
			//save it in an object
			FinancialRecord financialRecord = new FinancialRecord(id, employeeId, recordDate, description, amount, recordType);
			return financialRecord; 
		}
		DBUtil.dbClose();
		throw new FinancialRecordException("Financial Record not found");
	}

	@Override
	public List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId) throws FinancialRecordException, SQLException {
		Connection conn=DBUtil.getDBConn();
		List<FinancialRecord> list = new ArrayList<>();
		String sql="select * from financial_record where employee_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, employeeId);
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		while(rst.next()) { 
			int id = rst.getInt("id");
			java.sql.Date sqlrecordDate = rst.getDate("record_date");
			LocalDate recordDate = sqlrecordDate.toLocalDate();
			String description = rst.getString("description");
			double amount = rst.getDouble("amount");
			String recordType = rst.getString("record_type");
			int employeeID = rst.getInt("employee_id");
			
			//save it in an object
			FinancialRecord financialRecord = new FinancialRecord(id, employeeID, recordDate, description, amount, recordType);
			list.add(financialRecord);
			return list; 
		}
		DBUtil.dbClose();
		throw new FinancialRecordException("No record found for the given Employee");
	}

}
