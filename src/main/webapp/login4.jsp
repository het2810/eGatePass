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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

    <title>Document</title>
</head>

<style>

	#email-error{
		color:red;
	}
	#email12{
	color:red;
	}
    
    p{
        margin: auto;
        margin-top: 0%;
        font-size: 22px;
        width:400px;
        text-align: center;
        height: 5vh;
        /* border: 1px solid black; */
        color:green;
        font-weight: bold;
        animation-name: type;
        animation: type 5s steps(80, end); 
        overflow: hidden;
    }
    @keyframes type{ 
          from { 
               width: 0; 
               } 
           }
           img{
            width:500px;
            height:30vh;
            opacity: 0.9;
           }
    label{
        font-family:Georgia, 'Times New Roman', Times, serif;
    }
    a{
    	text-decoration:none;
    	color:black;
    }
</style>
<body >

<%
	String error = (String) request.getAttribute("error");
	if(error == null){
		error = "";
	}
%> 
<div class="parent-container">
<div class="main-container">
    
    <!-- Login description -->
    <div class="login-title" id="login-title-id">
        <p>Already a user? LOGIN NOW!!</p>
        <img src="assets/dist/img/secure-login.gif">
        <button id="login-title-button" onclick="swipe(1)">Login</button>
    </div>

   <!--Login form  -->
 <div class="form-container" id="login-form">
    <div class="form-title " style="background-color: rgba(17, 102, 117, 0.6);">Login</div>

    <form action="LoginServlet" name="reg" class="user-form" method="post">

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
            <label for="email">E-mail</label>
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
                <a href="forgot_password.jsp?mobile=0&password=1">Forgot Password</a>
            </div>
        </div>
        <div class="submit-me">
            <input type="submit" name="" id="sub"   value="Login" >
        </div>
        </form>
</div>
</div>
          
<!-- sign up form -->

<div class="main-container">
    <div class="form-container signup-form-container" id="signup-form">
        <h3 class="form-title">Sign Up</h3>

        <form action="RegistrationServlet?admin=0" class="user-form" method="post">
            <div class="user-info">
                <div class="personal-info">
                    <div class="input-box">
                        <input type="text" required name="fName" id="fName">
                        <label for="fName">First Name</label>
                    </div>
                    <div class="input-box">
                        <input type="text" required name="lName" id="lName">
                        <label for="lName">Last Name</label>
                    </div>
                    <div class="input-box">
                        <input type="tel" required name="mobile" id="uMobile">
                        <label for="uMobile">Mobile Number</label>
                    </div>
                </div>
                <div class="account-info">
                    <div class="input-box">
                        <input type="text" required name="email" id="RegEmail">
                        <label for="RegEmail">E-mail</label>
                    </div>
                    <div class="input-box">
                        <input type="tel" required name="en-no" id="en-no">
                        <label for="en-n">Enroll-no</label>
                    </div>
                    <div class="input-box">
                        <span class="show-pwd-button"><i class="fa-solid fa-lock"></i></span> 
                        <input type="password" required name="password" id="RegPwd">
                        <label for="RegPwd">Password</label>
                    </div>
                </div>
            </div>
            <div class="gender-box">
                <div class="gender-color">
                    <input type="radio" name="gender" id="male">
                    <label for="male">Male</label>
                </div>
                <div class="gender-color">
                    <input type="radio" name="gender" id="female">
                    <label for="female">Female</label>
                </div>
                <div class="gender-color">
                    <input type="radio" name="gender" id="not-to-say">
                    <label for="not-to-say">Prefer Not to Say</label>
                </div>
            </div>
            <div class="tnc-box">
                <input type="checkbox" name="tnc" id="tnc">
                <label for="tnc">I agree to terms and conditions.</label>
            </div>
            <div class="submit-box">
                <input type="submit" value="Register" id="register_button">
            </div>
            
        </form>
    </div>

    
     <!-- sign up description -->
     <div class="login-title" id="signup-id">
        <p>New To GatePass? SIGN UP NOW!!</p>
        <img src="assets/dist/img/signup.gif" alt="">
        <button id="login-title-button" onclick="swipe(2)">Sign Up</button>
    </div>
    
 </div> <!--main-container2 div closing-->
 
</div>
</body>
<script>
	let email_error = document.getElementById('email-error');
	id = setInterval(frame, 5);

    function swipe(n)
    {
        var login=document.getElementById("login-title-id")
        var login_form= document.getElementById("login-form")
        var signup= document.getElementById("signup-id")
        var signup_form= document.getElementById("signup-form")

        
        if(n==1)
        {
            login_form.style.display="block";
            login.style.display="none";
            signup_form.style.display="none";
            signup.style.display="block";
            // signup.style.animationName="visible";

            // @KeyframeEffect
         }

        else if(n==2)
        {
            signup_form.style.display="block";
            signup.style.display="none";
            login_form.style.display="none";
            login.style.display="block";
         }


    }

    
</script>
</html>