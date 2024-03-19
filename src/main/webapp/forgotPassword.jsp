<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="assets/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="assets/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="assets/plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="assets/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="assets/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="assets/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="assets/plugins/summernote/summernote-bs4.min.css">
<!DOCTYPE html>
<body class="login-page" style="min-height: 332.4px;">
<%
	String error = (String) request.getAttribute("error");
	if(error == null){
		error = "";
	}
	int password=0,mobile=0;
	password = Integer.parseInt(request.getParameter("password"));
	mobile = Integer.parseInt(request.getParameter("mobile"));
%>
    <div class="login-box">
        <div class="login-logo">
           <b>SSIT</b>
        </div>

        <div class="card">
            <div class="card-body login-card-body">
            <%
            	if(password == 1){
            %>
                <p class="login-box-msg">You forgot your password? Here you can easily retrieve a new password.</p>
            <%}
            	else if(mobile == 1) {
            %>
            	<p class="login-box-msg">Change Your Mobile From Here!</p>
            <%} %>
                <form action="ForgotPasswordServlet?password=<%=password %>&mobile=<%=mobile %>" method="post">
                    <div class="input-group mb-3">
                        <input type="email" class="form-control" placeholder="Email" name="email">
                        <%=error %>
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-envelope"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary btn-block">Generate OTP</button>
                        </div>

                    </div>
                </form>
                <p class="mt-3 mb-1">
                    <a href="login.jsp">Login</a>
                </p>
                <p class="mb-0">
                    <a href="register.jsp" class="text-center">Register</a>
                </p>
            </div>

        </div>
    </div>


    <script src="assets/plugins/jquery/jquery.min.js"></script>

    <script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="assets/dist/js/adminlte.min.js?v=3.2.0"></script>


</body>