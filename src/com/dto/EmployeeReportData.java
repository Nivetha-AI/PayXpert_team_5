package com.dto;

import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

public class EmployeeReportData {
 private int id;
 private String firstName;
 private String lastName;
 private double taxableIncome;
 private Year taxYear;
 private double taxAmount;
 private LocalDate recordDate;
 private String recordType;
 private double amount;
public EmployeeReportData() {}
public EmployeeReportData(int id, String firstName, String lastName, double taxableIncome, Year taxYear,
		double taxAmount, LocalDate recordDate, String recordType, double amount) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.taxableIncome = taxableIncome;
	this.taxYear = taxYear;
	this.taxAmount = taxAmount;
	this.recordDate = recordDate;
	this.recordType = recordType;
	this.amount = amount;
}
public EmployeeReportData(String firstName, String lastName, double taxableIncome, Year taxYear, double taxAmount,
		LocalDate recordDate, String recordType, double amount) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.taxableIncome = taxableIncome;
	this.taxYear = taxYear;
	this.taxAmount = taxAmount;
	this.recordDate = recordDate;
	this.recordType = recordType;
	this.amount = amount;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
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
	return recordDate;
}
public void setRecordDate(LocalDate recordDate) {
	this.recordDate = recordDate;
}
public String getRecordType() {
	return recordType;
}
public void setRecordType(String recordType) {
	this.recordType = recordType;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "EmployeeReportData [id=" + id + ", FirstName=" + firstName + ", LastName=" + lastName + ", taxableIncome="
			+ taxableIncome + ", taxYear=" + taxYear + ", taxAmount=" + taxAmount + ", RecordDate=" + recordDate
			+ ", RecordType=" + recordType + ", amount=" + amount + "]";
}
@Override
public int hashCode() {
	return Objects.hash(amount, firstName, id, lastName, recordDate, recordType, taxAmount, taxYear, taxableIncome);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	EmployeeReportData other = (EmployeeReportData) obj;
	return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
			&& Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
			&& Objects.equals(recordDate, other.recordDate) && Objects.equals(recordType, other.recordType)
			&& Double.doubleToLongBits(taxAmount) == Double.doubleToLongBits(other.taxAmount)
			&& Objects.equals(taxYear, other.taxYear)
			&& Double.doubleToLongBits(taxableIncome) == Double.doubleToLongBits(other.taxableIncome);
}


}
