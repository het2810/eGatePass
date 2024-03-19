package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.bean.RequestBean;

public class RequestDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/egate";
			String userName="root";
			String password="root";
			Class.forName(driver);
			con = DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static int addRequest(RequestBean req) {
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("insert into requests (request_id,enrollment_number,reason,leaves_left,askTime,passDate,approve,name) values (?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,req.getRequestId());
			pstmt.setInt(2,req.getEnrollmentNumber());
			pstmt.setString(3, req.getReason());
			pstmt.setInt(4, req.getLeavesLeft());
			pstmt.setString(5, req.getAskTime());
			pstmt.setString(6, req.getPassDate());
			pstmt.setBoolean(7, false);
			pstmt.setString(8, req.getName());
			
			int temp = pstmt.executeUpdate();
			if(temp == 1) return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static ArrayList<RequestBean> getAllRequests(){
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests order by request_id desc");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setApprove(rs.getInt("approve"));
				request.setEnrollmentNumber(rs.getInt("enrollment_number"));
				request.setLeavesLeft(rs.getInt("leaves_left"));
				request.setAskTime(rs.getString("askTime"));
				request.setPassDate(rs.getString("passDate"));
				request.setRequestId(rs.getInt("request_id"));
				request.setReason(rs.getString("reason"));
				request.setName(rs.getString("name"));
				request.setOutTime(rs.getString("outTime"));
				
				requests.add(request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}
	
	public static int getStatus(int requestId) {
		int status=0;
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from requests where request_id =  ? order by request_id desc");
			pstmt.setInt(1, requestId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				status = rs.getInt("approve");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

	public static void changeRequestStatus(Integer requestId,Integer status) {
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("update requests set approve = ? where request_id = ?");
			pstmt.setInt(1, status);
			pstmt.setInt(2, requestId);
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<RequestBean> getParticularStudent(int enrollment) {
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests where enrollment_number = ? order by request_id desc");
			pstmt.setInt(1, enrollment);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setApprove(rs.getInt("approve"));
				request.setEnrollmentNumber(rs.getInt("enrollment_number"));
				request.setLeavesLeft(rs.getInt("leaves_left"));
				request.setAskTime(rs.getString("outtime"));
				request.setPassDate(rs.getString("passDate"));
				request.setRequestId(rs.getInt("request_id"));
				request.setReason(rs.getString("reason"));
				request.setName(rs.getString("name"));
				request.setOutTime(rs.getString("outTime"));
				
				requests.add(request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}
	public static ArrayList<RequestBean> getParticularStudentAccepted(int enrollment) {
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests where enrollment_number = ? and approve = 1 order by request_id desc");
			pstmt.setInt(1, enrollment);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setApprove(rs.getInt("approve"));
				request.setEnrollmentNumber(rs.getInt("enrollment_number"));
				request.setLeavesLeft(rs.getInt("leaves_left"));
				request.setAskTime(rs.getString("outtime"));
				request.setPassDate(rs.getString("passDate"));
				request.setRequestId(rs.getInt("request_id"));
				request.setReason(rs.getString("reason"));
				request.setName(rs.getString("name"));
				request.setOutTime(rs.getString("outTime"));
				
				requests.add(request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}
	public static ArrayList<RequestBean> getParticularStudentRejected(int enrollment) {
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests where enrollment_number = ? and approve = 2 order by request_id desc");
			pstmt.setInt(1, enrollment);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setApprove(rs.getInt("approve"));
				request.setEnrollmentNumber(rs.getInt("enrollment_number"));
				request.setLeavesLeft(rs.getInt("leaves_left"));
				request.setAskTime(rs.getString("outtime"));
				request.setPassDate(rs.getString("passDate"));
				request.setRequestId(rs.getInt("request_id"));
				request.setReason(rs.getString("reason"));
				request.setName(rs.getString("name"));
				request.setOutTime(rs.getString("outTime"));
				
				requests.add(request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}
	public static ArrayList<RequestBean> getParticularStudentWaiting(int enrollment) {
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests where enrollment_number = ? and approve = 0 order by request_id desc");
			pstmt.setInt(1, enrollment);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setApprove(rs.getInt("approve"));
				request.setEnrollmentNumber(rs.getInt("enrollment_number"));
				request.setLeavesLeft(rs.getInt("leaves_left"));
				request.setAskTime(rs.getString("outtime"));
				request.setPassDate(rs.getString("passDate"));
				request.setRequestId(rs.getInt("request_id"));
				request.setReason(rs.getString("reason"));
				request.setName(rs.getString("name"));
				request.setOutTime(rs.getString("outTime"));
				
				requests.add(request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}
	public static ArrayList<RequestBean> getParticularStudent() {
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests order by request_id desc");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setApprove(rs.getInt("approve"));
				request.setEnrollmentNumber(rs.getInt("enrollment_number"));
				request.setLeavesLeft(rs.getInt("leaves_left"));
				request.setAskTime(rs.getString("outtime"));
				request.setPassDate(rs.getString("passDate"));
				request.setRequestId(rs.getInt("request_id"));
				request.setReason(rs.getString("reason"));
				request.setName(rs.getString("name"));
				request.setOutTime(rs.getString("outTime"));
				
				requests.add(request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}
	public static ArrayList<RequestBean> getParticularStudentAccepted() {
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests where approve = 1 order by request_id desc");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setApprove(rs.getInt("approve"));
				request.setEnrollmentNumber(rs.getInt("enrollment_number"));
				request.setLeavesLeft(rs.getInt("leaves_left"));
				request.setAskTime(rs.getString("outtime"));
				request.setPassDate(rs.getString("passDate"));
				request.setRequestId(rs.getInt("request_id"));
				request.setReason(rs.getString("reason"));
				request.setName(rs.getString("name"));
				request.setOutTime(rs.getString("outTime"));
				
				requests.add(request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}
	public static ArrayList<RequestBean> getParticularStudentRejected() {
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests where approve = 2 order by request_id desc");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setApprove(rs.getInt("approve"));
				request.setEnrollmentNumber(rs.getInt("enrollment_number"));
				request.setLeavesLeft(rs.getInt("leaves_left"));
				request.setAskTime(rs.getString("outtime"));
				request.setPassDate(rs.getString("passDate"));
				request.setRequestId(rs.getInt("request_id"));
				request.setReason(rs.getString("reason"));
				request.setName(rs.getString("name"));
				request.setOutTime(rs.getString("outTime"));
				
				requests.add(request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}
	public static ArrayList<RequestBean> getParticularStudentWaiting() {
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests where approve = 0 order by request_id desc");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setApprove(rs.getInt("approve"));
				request.setEnrollmentNumber(rs.getInt("enrollment_number"));
				request.setLeavesLeft(rs.getInt("leaves_left"));
				request.setAskTime(rs.getString("outtime"));
				request.setPassDate(rs.getString("passDate"));
				request.setRequestId(rs.getInt("request_id"));
				request.setReason(rs.getString("reason"));
				request.setName(rs.getString("name"));
				request.setOutTime(rs.getString("outTime"));
				
				requests.add(request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}


	public static void setOutTime(Integer requestId) {
		LocalTime t = LocalTime.now();
		String time = t.getHour() + ":" + t.getMinute();
		System.out.println(time);
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("update requests set outTime = ? where request_id = ?");
			pstmt.setString(1, time);
			pstmt.setInt(2, requestId);
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<RequestBean> getSpecificRequest(int status) {
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests where approve = ? order by request_id desc");
			pstmt.setInt(1, status);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setApprove(rs.getInt("approve"));
				request.setEnrollmentNumber(rs.getInt("enrollment_number"));
				request.setLeavesLeft(rs.getInt("leaves_left"));
				request.setAskTime(rs.getString("outtime"));
				request.setPassDate(rs.getString("passDate"));
				request.setRequestId(rs.getInt("request_id"));
				request.setReason(rs.getString("reason"));
				request.setName(rs.getString("name"));
				request.setOutTime(rs.getString("outTime"));
				
				requests.add(request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}
}