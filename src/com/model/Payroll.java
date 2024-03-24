package com.model;

import java.time.LocalDate;
import java.util.Objects;

public class Payroll {
	private int payrollId;
	private int employeeId;
	private LocalDate payPeriodStartDate;
	private LocalDate payPeriodEndDate;
	private double basicSalary;
	private double overTimePay;
	private double deductions;
	private double netSalary;
	
	public Payroll() {}

	public Payroll(int payrollId, int employeeId, LocalDate payPeriodStartDate, LocalDate payPeriodEndDate,
			double basicSalary, double overTimePay, double deductions, double netSalary) {
		this.payrollId = payrollId;
		this.employeeId = employeeId;
		this.payPeriodStartDate = payPeriodStartDate;
		this.payPeriodEndDate = payPeriodEndDate;
		this.basicSalary = basicSalary;
		this.overTimePay = overTimePay;
		this.deductions = deductions;
		this.netSalary = netSalary;
	}

	public Payroll(int employeeId, LocalDate payPeriodStartDate, LocalDate payPeriodEndDate, double basicSalary,
			double overTimePay, double deductions, double netSalary) {
		super();
		this.employeeId = employeeId;
		this.payPeriodStartDate = payPeriodStartDate;
		this.payPeriodEndDate = payPeriodEndDate;
		this.basicSalary = basicSalary;
		this.overTimePay = overTimePay;
		this.deductions = deductions;
		this.netSalary = netSalary;
	}

	public Payroll(int payrollId, int employeeId, double basicSalary, double overTimePay, double deductions,
			double netSalary) {
		super();
		this.payrollId = payrollId;
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
		this.overTimePay = overTimePay;
		this.deductions = deductions;
		this.netSalary = netSalary;
	}

	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getPayPeriodStartDate() {
		return payPeriodStartDate;
	}

	public void setPayPeriodStartDate(LocalDate payPeriodStartDate) {
		this.payPeriodStartDate = payPeriodStartDate;
	}

	public LocalDate getPayPeriodEndDate() {
		return payPeriodEndDate;
	}

	public void setPayPeriodEndDate(LocalDate payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getOverTimePay() {
		return overTimePay;
	}

	public void setOverTimePay(double overTimePay) {
		this.overTimePay = overTimePay;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", employeeId=" + employeeId + ", payPeriodStartDate="
				+ payPeriodStartDate + ", payPeriodEndDate=" + payPeriodEndDate + ", basicSalary=" + basicSalary
				+ ", overTimePay=" + overTimePay + ", deductions=" + deductions + ", netSalary=" + netSalary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(basicSalary, deductions, employeeId, netSalary, overTimePay, payPeriodEndDate,
				payPeriodStartDate, payrollId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payroll other = (Payroll) obj;
		return Double.doubleToLongBits(basicSalary) == Double.doubleToLongBits(other.basicSalary)
				&& Double.doubleToLongBits(deductions) == Double.doubleToLongBits(other.deductions)
				&& employeeId == other.employeeId
				&& Double.doubleToLongBits(netSalary) == Double.doubleToLongBits(other.netSalary)
				&& Double.doubleToLongBits(overTimePay) == Double.doubleToLongBits(other.overTimePay)
				&& Objects.equals(payPeriodEndDate, other.payPeriodEndDate)
				&& Objects.equals(payPeriodStartDate, other.payPeriodStartDate) && payrollId == other.payrollId;
	}
	
	
	
}	

