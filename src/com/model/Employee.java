package com.model;


import java.time.LocalDate;
import java.util.Objects;

public class Employee {
  private int id;
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private String gender;
  private String email;
  private String phoneNum;
  private String address;
  private String position;
  private LocalDate joiningDate;
  private LocalDate terminationDate;
public Employee() {}
public Employee(int id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String email,
		String phoneNum, String address, String position, LocalDate joiningDate, LocalDate terminationDate) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.email = email;
	this.phoneNum = phoneNum;
	this.address = address;
	this.position = position;
	this.joiningDate = joiningDate;
	this.terminationDate = terminationDate;
}
public Employee(String firstName, String lastName, LocalDate dateOfBirth, String gender, String email, String phoneNum,
		String address, String position, LocalDate joiningDate, LocalDate terminationDate) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.email = email;
	this.phoneNum = phoneNum;
	this.address = address;
	this.position = position;
	this.joiningDate = joiningDate;
	this.terminationDate = terminationDate;
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
	return phoneNum;
}
public void setPhoneNum(String phoneNum) {
	this.phoneNum = phoneNum;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public LocalDate getJoiningDate() {
	return joiningDate;
}
public void setJoiningDate(LocalDate joiningDate) {
	this.joiningDate = joiningDate;
}
public LocalDate getTerminationDate() {
	return terminationDate;
}
public void setTerminationDate(LocalDate terminationDate) {
	this.terminationDate = terminationDate;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
			+ ", gender=" + gender + ", email=" + email + ", PhoneNum=" + phoneNum + ", Address=" + address
			+ ", Position=" + position + ", JoiningDate=" + joiningDate + ", TerminationDate=" + terminationDate + "]";
}
@Override
public int hashCode() {
	return Objects.hash(address, dateOfBirth, email, firstName, gender, id, joiningDate, lastName, phoneNum, position,
			terminationDate);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	return Objects.equals(address, other.address) && Objects.equals(dateOfBirth, other.dateOfBirth)
			&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
			&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(joiningDate, other.joiningDate)
			&& Objects.equals(lastName, other.lastName) && Objects.equals(phoneNum, other.phoneNum)
			&& Objects.equals(position, other.position) && Objects.equals(terminationDate, other.terminationDate);
}




  
  
}
