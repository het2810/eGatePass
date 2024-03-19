package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bean.UserBean;
import com.lov.Role;

public class UserDao {
	
	static Connection getConnection() {
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
	
	public static int addUser(UserBean user) {
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("insert into users(FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,MOBILE,ROLE,ENROLLMENT_NUMBER,approve) values (?,?,?,?,?,?,?,?)");
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setInt(5, user.getMobile());
			pstmt.setInt(6, user.getRole());
			pstmt.setInt(7, user.getEnrollmentNumber());
			pstmt.setBoolean(8, user.isApprove());
			
			int result = pstmt.executeUpdate();
			
			if(result == 0) {
				System.out.println("Error Occured!");
				return 0;
			}
			else {
				System.out.println("Registered!");
				return 1;
			}
		}
		catch(SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static ArrayList<UserBean> listUsers(){
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from users");
			// now pstmt will not return single value , it will return all the records of the relation
			
			ResultSet rs = pstmt.executeQuery(); // easy concept hi hai
			
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("USER_ID"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setMobile(rs.getInt("MOBILE"));
				user.setRole(rs.getInt("ROLE"));
				user.setEnrollmentNumber(rs.getInt("ENROLLMENT_NUMBER"));
				
				users.add(user);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public static boolean checkCredentials(String email,String password) {

		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select EMAIL,PASSWORD from users");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("EMAIL").equals(email) && rs.getString("PASSWORD").equals(password)) {
					return true;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static UserBean getDetails(String email){
		UserBean user = new UserBean();
		
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select EMAIL,FIRST_NAME,LAST_NAME,ENROLLMENT_NUMBER,MOBILE,leaves,user_id from users where EMAIL = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("EMAIL").equals(email)) {
					user.setFirstName(rs.getString(2));
					user.setLastName(rs.getString(3));
					user.setEnrollmentNumber(rs.getInt(4));
					user.setMobile(rs.getInt(5));
					user.setLeaves(rs.getInt("leaves"));
					user.setUserId(rs.getInt("user_id"));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static void updateEmail(String email,int enrollment) {
		try {
			// establish connection
			Scanner sc = new Scanner(System.in);
			Connection con = getConnection();
			
			// We need a PreparedStatement object to execute our query
			PreparedStatement pstmt = con.prepareStatement("update users set EMAIL = ? where ENROLLMENT_NUMBER = ?");
			
			pstmt.setString(1,email);
			pstmt.setInt(2,enrollment);
			int record = pstmt.executeUpdate();  // this executes our update
			if(record == 0) {
				System.out.println("USerId not Found");
			}
			else {
				System.out.println("Record Updated!!!");				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	public static void updateMobile(int mobile,int userId) {
		try {
			// establish connection
			Scanner sc = new Scanner(System.in);
			Connection con = getConnection();
			
			// We need a PreparedStatement object to execute our query
			PreparedStatement pstmt = con.prepareStatement("update users set MOBILE = ? where user_id= ?");
			
			pstmt.setInt(1,mobile);
			pstmt.setInt(2,userId);
			int record = pstmt.executeUpdate();  // this executes our update
			if(record == 0) {
				System.out.println("USerId not Found");
			}
			else {
				System.out.println("Record Updated!!!");				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void updatePassword(String password,int userId) {

		try {
			// establish connection
			Scanner sc = new Scanner(System.in);
			Connection con = getConnection();
			
			// We need a PreparedStatement object to execute our query
			PreparedStatement pstmt = con.prepareStatement("update users set PASSWORD = ? where user_id = ?");
			
			pstmt.setString(1,password);
			pstmt.setInt(2,userId);
			int record = pstmt.executeUpdate();  // this executes our update
			if(record == 0) {
				System.out.println("USerId not Found");
			}
			else {
				System.out.println("Record Updated!!!");				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public static ArrayList<UserBean> showUsers(int role) {
		ArrayList<UserBean> students = new ArrayList<UserBean>();
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where role = ?");
			pstmt.setInt(1, role);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("USER_ID"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setMobile(rs.getInt("MOBILE"));
				user.setEnrollmentNumber(rs.getInt("ENROLLMENT_NUMBER"));
				user.setApprove(rs.getBoolean("approve"));
				students.add(user);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return students;
	}
	public static int getStatus(int userId) {
		int status=0;
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where USER_ID =  ?");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				status = rs.getInt("approve");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println(status);
		if(status == 1) return 0;
		else return 1;
	}

	public static void changeStudentStatus(Integer userId) {
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set approve = ? where USER_ID = ?");
			pstmt.setInt(1, UserDao.getStatus(userId));
			pstmt.setInt(2, userId);
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getRole(String email) {
		int role = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select ROLE from users where EMAIL = ?");
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				role = rs.getInt("ROLE");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	public static int getApprove(String email) {
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ?");
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getBoolean("approve") == true) {
					return 1;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void setLeaves(int leavesLeft, int enrollment) {
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set leaves = ? where enrollment_number = ? ");
			pstmt.setInt(1, leavesLeft);
			pstmt.setInt(2, enrollment);
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public boolean findEmail(String email) {
		try {
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select EMAIL from users");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("EMAIL").equals(email)) {
					System.out.println("Yes I am here!");
					return true;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void setOtp(int userId, int otp) {
		
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set otp = ? where user_id = ?");
			pstmt.setInt(1, otp);
			pstmt.setInt(2, userId);
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean checkOTP(int userId, int otp) {

		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select otp from users where user_id = ?");
			pstmt.setInt(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt("otp") == otp) {
					return true;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static UserBean getDetailsForRequest(int userId) {
		try {
			Connection con = getConnection();
			System.out.println(userId);
			PreparedStatement pstmt = con.prepareStatement("select * from users where enrollment_number = ?");
			pstmt.setInt(1, userId);
			// now pstmt will not return single value , it will return all the records of the relation
			
			ResultSet rs = pstmt.executeQuery(); // easy concept hi hai
			
			UserBean user1 = new UserBean();
			if(rs.next()) {
				user1.setUserId(rs.getInt("USER_ID"));
				user1.setFirstName(rs.getString("FIRST_NAME"));
				user1.setLastName(rs.getString("LAST_NAME"));
				user1.setEmail(rs.getString("EMAIL"));
				user1.setPassword(rs.getString("PASSWORD"));
				user1.setMobile(rs.getInt("MOBILE"));
				user1.setRole(rs.getInt("ROLE"));
				user1.setEnrollmentNumber(rs.getInt("ENROLLMENT_NUMBER"));
				user1.setLeaves(rs.getInt("leaves"));
				return user1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static UserBean getDetailsForRequestForUser(int userId) {
		try {
			Connection con = getConnection();
			System.out.println(userId);
			PreparedStatement pstmt = con.prepareStatement("select * from users where USER_ID = ?");
			pstmt.setInt(1, userId);
			// now pstmt will not return single value , it will return all the records of the relation
			
			ResultSet rs = pstmt.executeQuery(); // easy concept hi hai
			
			UserBean user1 = new UserBean();
			if(rs.next()) {
				user1.setUserId(rs.getInt("USER_ID"));
				user1.setFirstName(rs.getString("FIRST_NAME"));
				user1.setLastName(rs.getString("LAST_NAME"));
				user1.setEmail(rs.getString("EMAIL"));
				user1.setPassword(rs.getString("PASSWORD"));
				user1.setMobile(rs.getInt("MOBILE"));
				user1.setRole(rs.getInt("ROLE"));
				user1.setEnrollmentNumber(rs.getInt("ENROLLMENT_NUMBER"));
				user1.setLeaves(rs.getInt("leaves"));
				return user1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int getTotalUsersByRole(int role) {
		int count=0;
		try {
//			ArrayList<UserBean> userList = new ArrayList<UserBean>();
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where role = ?");
			pstmt.setInt(1,role);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
//				UserBean users = new UserBean();
				count++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
