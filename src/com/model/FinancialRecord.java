package com.model;

import java.time.LocalDate;

public class FinancialRecord {
	private int id;
	private int employeeId;
	private LocalDate recordDate;
	private String description;
	private double amount;
	private String recordType;
	
	// constructor without arguments
	public FinancialRecord() {	}

	// constructor with all fields
	public FinancialRecord(int id, int employeeId, LocalDate recordDate, String description, double amount,
			String recordType) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.recordDate = recordDate;
		this.description = description;
		this.amount = amount;
		this.recordType = recordType;
	}

	// constructor without id
	public FinancialRecord(int employeeId, LocalDate recordDate, String description, double amount, String recordType) {
		super();
		this.employeeId = employeeId;
		this.recordDate = recordDate;
		this.description = description;
		this.amount = amount;
		this.recordType = recordType;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(LocalDate recordDate) {
		this.recordDate = recordDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	// to string method
	@Override
	public String toString() {
		return "FinancialRecord [id=" + id + ", employeeId=" + employeeId + ", recordDate=" + recordDate
				+ ", description=" + description + ", amount=" + amount + ", recordType=" + recordType + "]";
	}
	
}


