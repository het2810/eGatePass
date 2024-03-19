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
    <link rel="stylesheet" href="style-detail.css">
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
<div class="parent">
    <h2 id="heading-detail">Apply For Leave</h2>        
    <div class="main-container">
        
        <div class="form-container" >
            <form action="RequestServlet" class="request-form">
            	<div class="form-parent" id="main_form">
                <div class="input-box1">
                    <p>
                    <label for="date">Date : </label>
                    <input type="text" name="" id="time" value="<%=today%>" readonly>
                    </p>
                    <p style="margin-top: 5px;">
                    <label for="time">Time : </label> 
                    <input type="time" name="askTime" id="time">
                </p>
                </div>
                <div class="input-box">
                    <input type="text" name="reason" id="req">
                    <label for="req" id="abc">Enter Reason:</label>
                    
                </div>
                     <input class="submit-me" type="submit" value="SUBMIT" onclick="done()">
            </div>
            </form>
        </div>

            <div id="confirmed">
                <img src="assets/dist/img/done.gif" alt="" id="confirmed_img">
            </div>
    </div>
</div>

<script>
    function done(){
        document.getElementById("confirmed").style.display="block";
        document.getElementById("main_form").style.display="none";
    }
</script>
</body>
</html>