package com.mindtree.entity.Employee;

import javax.persistence.*;

@Entity
@Table(name="EMP")
public class Employee {
	
@Id
@Column(name="EmployeeNo")
@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int employeeNo;
	
 private String employeeName;
 
 private String email;
 
 private java.util.Date dateOfBirth;
 
 private double salary;
 
public int getEmployeeNo() {
	return employeeNo;
}
public void setEmployeeNo(int employeeNo) {
	this.employeeNo = employeeNo;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public java.util.Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(java.util.Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
}
