<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
:root{
    --primary-font: 'Poppins', sans-serif;
    --main-color:grey;
    --second-color: rgba(17, 102, 117,0.5);
    --light-font: rgba(17, 102, 117,0.4);
}
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
        height: 4vh;
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
    
body{
   
    content: '';

    background-image: url(assets/dist/img/bg11.jpg);
    background-repeat: no-repeat;
    position: absolute;
    background-size: cover;
    top: 0;
    bottom: 0;
     height: 100vh;
    width: 100%;
    font-family: var(--primary-font);
    /* padding: 2rem ; */
}

body::before{
    opacity: 0.4;

}

.parent-container{
    width: 80%;
    margin: auto;
    margin-top: 8%;
    display: flex;
    flex-direction: row;
   border-radius: 12px;
   border:1px solid black;
   height:70vh;
	background-color:whitesmoke;  
}
.main-container{
    
    /* background-color: rgb(243, 240, 240,0.4); */
    /* background-image: url(/images/secure-login.gif);
    background-size: cover;
  */

    background-color: whitesmoke;
    color: black;
    display: flex;
    flex-direction: row;
    margin: auto;
    height: 55vh;
    /* background-color:var(--light-font); */
    border-radius: 12px;
}
.main-container::before{
    opacity: 0.2;  
     margin-bottom: 2px;  
        height: 40vh;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
}

.login-title{
    flex:1;
    justify-content: center;
    height: 50vh;
   
    z-index: 1;
}
.main-container::before{
    opacity: 0.4;
}
#login-title-button{
    width: 100%;
    height: 4rem;
    margin: auto;
background-color: var(--light-font);
    border-radius: 12px;
    font-size: 20px;
    border: none;
}
#login-title-button:hover{
    background-color: var(--light-font);
    font-size: 24px;
border-bottom: 3px solid black;
}
#login-title-button::before:hover{
    opacity: 0.2;
}
.image_block{
    flex: 1;
    
}
#imageee
{
margin-top:2px;
    height: 60vh;
     width: fit-content;
}

.form-container{
  	flex:1;
  	
    height:70vh;
    background-color: white; 
    font-family: var(--primary-font);
    border-radius: 12px;
    animation-name: form;
    animation-duration: 2s;
    overflow: hidden;
}
@keyframes form {
    from { width:300px}
    to {width: 500px;}
    
}
#login-form{

    margin-left: 40px;
    border-radius:10px ;
    animation-name: login-form;
    animation-duration: 1s;
    animation-direction: alternate-reverse;
    overflow: hidden;
}
@keyframes login-form {
    from{ width:500px}
    to {width:300px}
}
.form-container .user-form{
    border-radius: 10px;
    text-align: center;
    justify-content: center;
}
.form-title{
padding-top:2%;
    width: 100%;
    height: 3rem;
    background-color: var(--light-font);
    border-radius: 8px;
    text-align: center;
    font-family:'Times New Roman', Times, serif;
    font-size: 22px;
    font-weight: bold;
margin-top:0%;
    /* font-weight: bold; */
}

.user-form .input-box{
    /* border: 2px solid red; */
    position: relative;
    margin-top:2rem;
    margin-right:3.2rem;
    }
.input-box input{
    width: 100%;
    height: 2rem;
    border: 2px solid black;
    border-radius: 10px;
    padding-right: 20px; 
    margin-top: 2%;
    /* padding: 2rem; */
}
.input-box input:focus{
    outline-color: var(--main-color);
    border-radius: 10px;
}
.input-box.error input{
    border-color: red;
}
.input-box .error {
    color: #ff3860;
    font-size: 15px;
    height: 13px;
}
input:focus + label,input:valid + label{
    top: -7px;
    left: 1px;
    color: rgb(26, 78, 235);
}
.input-box label{
    position: absolute;
    top: 50%;
    left: 20px;
    transform: translateY(-50%);
    font-family: var(--primary-font);
    transition: all 0.5s;
    text-align: center;
    /* margin-top: 2px; */
}
.input-box .show-pwd-button{
    position: absolute;
    /* color: var(--light-font); */
    cursor: pointer;
    right: 20px;
    top: 50%;
    transform: translateY(-50%);
}
#invalid-email{
    color: red;
    display: none;
}
.user-form .remember-forget-pass{
    display: flex;
    justify-content: space-between;
    font-size: 0.8rem;
}
.remember-forget-pass input + label{
    color: black;
    background: transparent;
    
}
.user-info{
width:80%;
height:30vh;
margin:auto;
	display:flex;
	flex-direction:row;
	gap:1rem;
}
.user-form input[type="submit"]{
    height: 3rem;
    width: 100%;
    margin: 2rem 0 1rem;
    background-color: var(black);
    color: black;
    border: none;
    border-radius: 8px;
    font-size: 1.5rem;
    cursor: pointer;
}
/* .user-form input[type="submit"]:hover{
    border: 2px solid black;
} */
#sub{
    background-color: var(--second-color);
    font-size: 22px;
}
#sub:hover , #register_button:hover{
    opacity:1;
    font-size: 24px;
    border-bottom:2px solid black;
    border-right: 1px solid black;
   
}
.gender-box{
display:flex;
flex-direction:row;
height:7Vh;
width:100%;
margin:auto;
margin-top:20px;
margin-left:70px;
}

.tnc-box{
    text-align: left;
    /* border: 1px solid black;  */
    margin-left:70px;
}
/* .submit-box{
    border: 1px solid black; 
    height: 2rem;
    margin-top: 2%;
} */
#register_button{
    height: 2.5rem;
    margin-top: 2.5%; 
    font-size: 20px;
    background-color: var(--light-font);
    width:80%;
}

    
</style>
</head>
<body >

<%
	String error = (String) request.getAttribute("error");
	if(error == null){
		error = "";
	}
%> 
<div class="parent-container">
    
              

<div class="main-container">
     <!-- sign up description -->
     <div class="login-title" id="signup-id">
        <p>New To GatePass? SIGN UP NOW!!</p>
        <img src="assets/dist/img/signup.gif" alt="">
   
    </div>
    <!-- sign up form -->
    </div>
    <div class="form-container signup-form-container" id="signup-form">
        <h3 class="form-title">Sign Up</h3>

        <form action="RegistrationServlet?admin=1" class="user-form" method="post">
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
 
</div>
</body>
</body>
</html>