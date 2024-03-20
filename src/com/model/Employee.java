package com.model;


import java.time.LocalDate;

public class Employee {
  private int id;
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private String gender;
  private String email;
  private String PhoneNum;
  private String Address;
  private String Position;
  private LocalDate JoiningDate;
  private LocalDate TerminationDate;
public Employee() {}
public Employee(int id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String email,
		String phoneNum, String address, String position, LocalDate joiningDate, LocalDate terminationDate) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.email = email;
	PhoneNum = phoneNum;
	Address = address;
	Position = position;
	JoiningDate = joiningDate;
	TerminationDate = terminationDate;
}
public Employee(String firstName, String lastName, LocalDate dateOfBirth, String gender, String email, String phoneNum,
		String address, String position, LocalDate joiningDate, LocalDate terminationDate) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.email = email;
	PhoneNum = phoneNum;
	Address = address;
	Position = position;
	JoiningDate = joiningDate;
	TerminationDate = terminationDate;
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
public LocalDate getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNum() {
	return PhoneNum;
}
public void setPhoneNum(String phoneNum) {
	PhoneNum = phoneNum;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getPosition() {
	return Position;
}
public void setPosition(String position) {
	Position = position;
}
public LocalDate getJoiningDate() {
	return JoiningDate;
}
public void setJoiningDate(LocalDate joiningDate) {
	JoiningDate = joiningDate;
}
public LocalDate getTerminationDate() {
	return TerminationDate;
}
public void setTerminationDate(LocalDate terminationDate) {
	TerminationDate = terminationDate;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
			+ ", gender=" + gender + ", email=" + email + ", PhoneNum=" + PhoneNum + ", Address=" + Address
			+ ", Position=" + Position + ", JoiningDate=" + JoiningDate + ", TerminationDate=" + TerminationDate + "]";
}




  
  
}
