package com.dto;

import java.time.LocalDate;
import java.time.Year;

public class EmployeeReportData {
 private int id;
 private String FirstName;
 private String LastName;
 private double taxableIncome;
 private Year taxYear;
 private double taxAmount;
 private LocalDate RecordDate;
 private String RecordType;
 private double amount;
public EmployeeReportData() {}
public EmployeeReportData(int id, String firstName, String lastName, double taxableIncome, Year taxYear,
		double taxAmount, LocalDate recordDate, String recordType, double amount) {
	this.id = id;
	FirstName = firstName;
	LastName = lastName;
	this.taxableIncome = taxableIncome;
	this.taxYear = taxYear;
	this.taxAmount = taxAmount;
	RecordDate = recordDate;
	RecordType = recordType;
	this.amount = amount;
}
public EmployeeReportData(String firstName, String lastName, double taxableIncome, Year taxYear, double taxAmount,
		LocalDate recordDate, String recordType, double amount) {
	FirstName = firstName;
	LastName = lastName;
	this.taxableIncome = taxableIncome;
	this.taxYear = taxYear;
	this.taxAmount = taxAmount;
	RecordDate = recordDate;
	RecordType = recordType;
	this.amount = amount;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public double getTaxableIncome() {
	return taxableIncome;
}
public void setTaxableIncome(double taxableIncome) {
	this.taxableIncome = taxableIncome;
}
public Year getTaxYear() {
	return taxYear;
}
public void setTaxYear(Year taxYear) {
	this.taxYear = taxYear;
}
public double getTaxAmount() {
	return taxAmount;
}
public void setTaxAmount(double taxAmount) {
	this.taxAmount = taxAmount;
}
public LocalDate getRecordDate() {
	return RecordDate;
}
public void setRecordDate(LocalDate recordDate) {
	RecordDate = recordDate;
}
public String getRecordType() {
	return RecordType;
}
public void setRecordType(String recordType) {
	RecordType = recordType;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "EmployeeReportData [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", taxableIncome="
			+ taxableIncome + ", taxYear=" + taxYear + ", taxAmount=" + taxAmount + ", RecordDate=" + RecordDate
			+ ", RecordType=" + RecordType + ", amount=" + amount + "]";
}


}
