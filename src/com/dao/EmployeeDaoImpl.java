package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.dto.EmployeeReportData;
import com.exception.EmployeeNotFoundException;
import com.exception.FinancialRecordException;
import com.model.Employee;

import com.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee getEmployeeById(int emid) throws SQLException, EmployeeNotFoundException {
		Connection conn = DBUtil.getDBConn();
		// step 1:prepare the statement
		String sql = "select * from employee where id=?";
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		// Attach the value to ?
		pstmt.setInt(1, emid);
		// execute the statement
		ResultSet rst = pstmt.executeQuery();
		// Iterate over the result set and read db column
		if (rst.next()) {

			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			LocalDate dateOfBirth = LocalDate.parse(rst.getString("date_of_Birth"));
			String gender = rst.getString("gender");
			String email = rst.getString("email");
			String phoneNum = rst.getString("phone_num");
			String address = rst.getString("address");
			String position = rst.getString("position");
			LocalDate joiningDate = LocalDate.parse(rst.getString("joining_date"));
			LocalDate terminationDate = null; // I am initializing it with null
			String terminationDateString = rst.getString("termination_date");
			if (terminationDateString != null) {
				terminationDate = LocalDate.parse(terminationDateString);
			}

			// save it in object
			Employee e = new Employee(emid, firstName, lastName, dateOfBirth, gender, email, phoneNum, address,
					position, joiningDate, terminationDate);
			return e;
		}
		DBUtil.dbClose();
		throw new EmployeeNotFoundException("Invalid ID given");

	}

	@Override
	public List<Employee> getAllEmployee() throws SQLException {
		Connection conn = DBUtil.getDBConn();
		List<Employee> list = new ArrayList<>();// container

		String sql = "select * from Employee";

		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			int id = rst.getInt("Id");
			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			String dateOfBirth = rst.getString("date_of_Birth");
			String gender = rst.getString("gender");
			String email = rst.getString("email");
			String PhoneNum = rst.getString("phone_num");
			String address = rst.getString("address");
			String position = rst.getString("position");
			String joiningDate = rst.getString("joining_date");
			String terminationDate = rst.getString("termination_date");

			Employee e = new Employee();
			e.setId(id);
			e.setFirstName(firstName);
			e.setLastName(lastName);
			e.setDateOfBirth(LocalDate.parse(dateOfBirth));
			e.setGender(gender);
			e.setEmail(email);
			e.setPhoneNum(PhoneNum);
			e.setAddress(address);
			e.setPosition(position);
			e.setJoiningDate(LocalDate.parse(joiningDate));

			if (terminationDate != null) {
				e.setTerminationDate(LocalDate.parse(terminationDate));
			} else {
				e.setTerminationDate(null);

			}

			// save it in object

			list.add(e);
		}

		DBUtil.dbClose();
		return list;

	}

	public void addEmployee(Employee emp) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "insert into employee(first_name ,last_name , date_of_birth, gender , email , Phone_num, address, position , Joining_date) values (?,?,?,?,?,?,?,?,?)";
		// prepare the statement
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		// attach the values to ?
		pstmt.setString(1, emp.getFirstName());
		pstmt.setString(2, emp.getLastName());
		pstmt.setString(3, emp.getDateOfBirth().toString());
		pstmt.setString(4, emp.getGender());
		pstmt.setString(5, emp.getEmail());
		pstmt.setString(6, emp.getPhoneNum());
		pstmt.setString(7, emp.getAddress());
		pstmt.setString(8, emp.getPosition());
		pstmt.setString(9, emp.getJoiningDate().toString());

		// execute the query
		pstmt.executeUpdate();

		DBUtil.dbClose();

	}

	@Override
	public void updateEmployee(int eid, String efname, String elname, LocalDate edob, String egender, String eemail,
			String ephonenumber, String eaddress, String eposition, LocalDate ejoiningdate)
			throws SQLException, EmployeeNotFoundException {
		Connection conn = DBUtil.getDBConn();

		String sql = "update employee set first_name=? ,last_name=? , date_of_birth=? ,"
				+ " gender=? , email=?,phone_num=?,address=? , position=?, joining_date=?  where id =?";
		// prepare the statement

		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		// attach the values to ?
		pstmt.setString(1, efname);
		pstmt.setString(2, elname);
		pstmt.setDate(3, java.sql.Date.valueOf(edob));
		pstmt.setString(4, egender);
		pstmt.setString(5, eemail);
		pstmt.setString(6, ephonenumber);
		pstmt.setString(7, eaddress);
		pstmt.setString(8, eposition);
		pstmt.setDate(9, java.sql.Date.valueOf(ejoiningdate));
		pstmt.setInt(10, eid);
		// execute the query
		int rowsUpdated = pstmt.executeUpdate();

		if (rowsUpdated == 0) {
			throw new EmployeeNotFoundException("Employee not found to update");
		}

		DBUtil.dbClose();

	}

	@Override
	public void deleteEmployee(int id) throws EmployeeNotFoundException, SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "delete from employee where id =?";
		// prepare the statement

		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		// attach the values to ?
		pstmt.setInt(1, id);
		// execute the query
		int rowsDeleted = pstmt.executeUpdate();
		if (rowsDeleted == 0) {
			throw new EmployeeNotFoundException("Employee not found to delete");
		}

		DBUtil.dbClose();

	}

	@Override
	public List<EmployeeReportData> getReport(int empid, int fyear) throws SQLException, FinancialRecordException {
		Connection conn = DBUtil.getDBConn();
		List<EmployeeReportData> list = new ArrayList<>();// container
		// step 1:prepare the statement
		String sql = "select e.first_name , e.last_name , t.taxable_income ,t.tax_year, t.tax_amount , f.record_date , f.record_type,f.amount "
				+ " from tax t join employee e on e.id=t.employee_id join financial_record f on e.id=f.employee_id where e.id=? and year(f.record_date)=?";

		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		// Attach the value to ?
		pstmt.setInt(1, empid);
		pstmt.setInt(2, fyear);
		// execute the statement
		ResultSet rst = pstmt.executeQuery();
		// Iterate over the result set and read db column
		if (rst.next()) {
			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			Double taxableIncome = rst.getDouble("taxable_income");
			Year taxYear = Year.of(rst.getInt("tax_year"));
			double taxAmount = rst.getDouble("tax_amount");
			LocalDate recordDate = LocalDate.parse(rst.getString("record_date"));
			String recordType = rst.getString("record_type");
			double amount = rst.getDouble("amount");

			// save it in object
			EmployeeReportData empReport = new EmployeeReportData(firstName, lastName, taxableIncome, taxYear,
					taxAmount, recordDate, recordType, amount);

			list.add(empReport);
		}

		DBUtil.dbClose();
		if (list.isEmpty()) {
			throw new FinancialRecordException(
					"Detail report for employee ID " + empid + " and financial year " + fyear + " not available.");

		}
		return list;

	}

}
