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

<body>
<%
	int admin = 0;
	admin = Integer.parseInt(request.getParameter("admin"));
%>
    <div class="form-container signup-form-container">
        <form action="RegistrationServlet?admin=<%=admin %>" class="user-form" method="post">
            <h3 class="form-title">Sign Up</h3>
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
                        <label for="RegEmail">email</label>
                    </div>
                    <div class="input-box">
                        <input type="tel" required name="en-no" id="en-no">
                        <label for="en-n">Enroll-NO</label>
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
                <input type="submit" value="Register">
            </div>
            <div class="new-old-user">
                <span>Already a user? <a href="login.jsp">Login</a> here!</span>
            </div>
        </form>
    </div>
</body>

</html>