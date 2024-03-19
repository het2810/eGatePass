package com.bean;

public class RequestBean {
	private int requestId,enrollmentNumber,leavesLeft;
	private String reason;
	private String outTime,passDate,name,askTime;
	private int approve;
	
	
	
	
	
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getAskTime() {
		return askTime;
	}
	public void setAskTime(String askTime) {
		this.askTime = askTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassDate() {
		return passDate;
	}
	public void setPassDate(String passDate) {
		this.passDate = passDate;
	}
	
	public int getApprove() {
		return approve;
	}
	public void setApprove(int approve) {
		this.approve = approve;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getLeavesLeft() {
		return leavesLeft;
	}
	public void setLeavesLeft(int leavesLeft) {
		this.leavesLeft = leavesLeft;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getEnrollmentNumber() {
		return enrollmentNumber;
	}
	public void setEnrollmentNumber(int enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}
	
	
}
