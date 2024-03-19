<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- fontawesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <!-- custom CSS -->
    <link rel="stylesheet" href="style-form.css">
    <title>Document</title>
</head>

<style>

	#email-error{
		color:red;
	}
	#email12{
	color:red;
	}
</style>
<body class="login-body">

<%
	String error = (String) request.getAttribute("error");
	if(error == null){
		error = "";
	}
%>
    <div class="form-container">
        <form action="LoginServlet" name="reg" class="user-form" method="post">
            <h3 class="form-title">Login</h3>
            <div class="input-box">
            	<%
            		if(error == "Invalid Credentials"){
            	%>
            		<style>
            			.input-box input{
            				border : 2px solid red;
            			}
            		</style>
            		<span class="show-pwd-button"><i class="fa-solid fa-circle-exclamation" id="email-error"></i></span>
            	<%
            		} 
            	%>
                <input type="text" name="email" id="email" required>
                <label for="email">email</label>
                <div id="email12"><%=error %></div>
            </div>
            <div class="input-box">
                <span class="show-pwd-button"><i class="fa-solid fa-lock"></i></span>
                <input type="password" name="password" id="password" required>
                <label for="password">Password</label>
                
            </div>
            <div class="remember-forget-pass">
                <div> 
                    <input type="checkbox" name="" id="remember">
                    <label for="remember">Remember Me</label>
                </div>
                <div>
                    <a href="forgotPassword.jsp?mobile=0&password=1">Forgot Password</a>
                </div>
            </div>
            <div class="submit-me">
                <input type="submit" name="" id="sub"   value="Login" >
            </div>
            <div class="new-old-user">
                <span>New? <a href="register.jsp?admin=0">Sign Up</a></span>
            </div>
        </form>
    </div>
</body>
<script>
	let email_error = document.getElementById('email-error');
	
</script>
</html>