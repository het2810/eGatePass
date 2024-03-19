package com.bean;

public class UserBean {
	private int userId;
	private int role;
	private int enrollmentNumber;
	private int mobile;
	private int leaves,otp;
	private String firstName,lastName,email,password;
	
	
	
	
	public int getOtp() {
		return otp;
	}
	
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public int getLeaves() {
		return leaves;
	}
	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}
	boolean approve;
	
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getEnrollmentNumber() {
		return enrollmentNumber;
	}
	public void setEnrollmentNumber(int enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
