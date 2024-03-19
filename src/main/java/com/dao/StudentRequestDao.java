package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.RequestBean;

public class StudentRequestDao {
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
	
	
	public ArrayList<RequestBean> getParticularStudent(int enrollment) {
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
	public ArrayList<RequestBean> getRequestByStatus(int enrollment,int status) {
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from requests where enrollment_number = ? and approve = ? order by request_id desc");
			pstmt.setInt(1, enrollment);
			pstmt.setInt(2, status);
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
