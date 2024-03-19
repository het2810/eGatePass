package com.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	public void sendOtpForForgetPassword(String email, Integer otp) {

		final String from = "viral.modi228@gmail.com";// from address
		
		// google mai jakar peehele
		// 1) two step verification
		// 2) app specific password generate krna hai
		
		
		final String appPassword = "xmjosaasxmlhrioz"; // tejas123

		Properties prop = System.getProperties();

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.enable", "false");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, appPassword);
			}
		});

		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("OTP For Update Password");
			message.setContent("Please use this OTP for Update Password.... ==> " + otp, "text/html");

			Transport.send(message);

			System.out.println("email sent.............");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong...........");
		}
	}
	public void sendRequestForVerification(String email,String name,int enrollment,String reason,int requestId,int status) {
		final String from = "viral.modi228@gmail.com";// from address
		
		// google mai jakar peehele
		// 1) two step verification
		// 2) app specific password generate krna hai
		
		final String appPassword = "xmjosaasxmlhrioz"; // tejas123

		Properties prop = System.getProperties();

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.enable", "false");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, appPassword);
			}
		});

		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("wadhwanivanshika86@gmail.com"));
			message.setSubject("Request For Verification");
			message.setContent("Respected Sir/Mam  <br> + Name :- " + name + "<br>" + 
					"Enrollment :- " + enrollment + "<br>" + "Reason :-" + reason +
					"<br>To Accept the Request Click on <a href='http://localhost:9898/E-GatePass/ChangeRequestStatus?requestId="+requestId +"&currentStatus="+status+"'>Accept</a>"
					+"<br>" + 
					"To Reject the Request Click on <a href='http://localhost:9898/E-GatePass/ChangeRequestStatus?requestId="+requestId +"&currentStatus="+status+"'>Reject</a>"
					,"text/html");

			Transport.send(message);

			System.out.println("email sent.............");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong...........");
		}
	}
	public void sendResponse(String email) {
		final String from = "viral.modi228@gmail.com";// from address
		
		// google mai jakar peehele
		// 1) two step verification
		// 2) app specific password generate krna hai
		
		final String appPassword = "xmjosaasxmlhrioz"; // tejas123

		Properties prop = System.getProperties();

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.enable", "false");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, appPassword);
			}
		});

		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Request For Verification");
			message.setContent("Your Request Has Been Accepted","text/html");

			Transport.send(message);

			System.out.println("email sent.............");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong...........");
		}
	}
}