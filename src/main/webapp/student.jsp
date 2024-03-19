<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style-details.css">
    <title>Document</title>
</head>

<body>
<%
	Date d = new Date();
	DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	String today = df.format(d);
	int userId=0,enrollment=-1;
	Cookie c[] = request.getCookies();
	for (Cookie x : c) {
		if (x.getName().equals("userId")) {
			userId = Integer.valueOf(x.getValue());
		}
		if (x.getName().equals("enrollment")) {
			enrollment = Integer.valueOf(x.getValue());
		}
	}
	UserBean user;
	user = UserDao.getDetailsForRequest(enrollment);
%>
    <h2 id="heading-detail">GatePass</h2>        
    <div class="main-container">
        <div class="first-container">
            <p class="details">Leaves left</p>
            <p class="details" id="leave"><%=user.getLeaves()%></p>
        </div>
        <div class="form-container">
            <form action="RequestServlet" class="request-form">
            	<div class="input-box1">
                    <label for="date">Date : </label>
                    <input type="text" name="" id="time" value="<%=today%>" readonly>
                </div>
                <div class="input-box1">
                    <label for="time">Time : </label>
                    <input type="time" name="askTime" id="time">
                </div>
                <div class="input-box">
                    <input type="text" name="reason" id="req">
                    <label for="req" id="abc">Reason</label>
                </div>
                <input class="submit-me" type="submit" value="Apply For Leave">
            </form>
        </div>
    </div>
</body>
</html>