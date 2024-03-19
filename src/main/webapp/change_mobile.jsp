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
  <head>
    <title>Mobile CHange</title>
    <style>
          body{
            content: '';
            width: 100%;
            height: 100vh;
            background-image: url(assets/dist/img/bg11.jpg);
            background-repeat: no-repeat;
               position: absolute;
               top: 0;
                bottom: 0;
                background-size: cover;
        }
        body::before{
           opacity: 0.4;

        }
        .main-contain{
            margin: auto;
            margin-top: 10%;
            /* border: 7px solid green; */
            width:70%;
            height:50vh;
            display: flex;
            flex-direction: row;
            
        }
        .card{
            border:1px solid black;
            flex: 1;
            height: 50vh;
            margin: auto;
            background-color: whitesmoke;
        }
        .pass_img{
            flex: 1;
           height:50vh;
        }
        .login-box-msg{
        background-color: rgba(17, 102, 117, 0.4);
        height: 3rem;
        font-size: 22px;
        padding: 10px;
        font-weight: bold;
        text-align: center;
        margin-top: 0%;

        }

        .input-group{
            /* border:1px solid black; */
            margin: auto;
            margin-top: 2%;
            width: 80%;
            align-items: center;
            text-align: center;
            font-size: 18px;
        }
        input ,button{
            width: 80%;
            height: 2.5rem;
            border-radius: 8px;
        }
        input:hover{
            outline:1px solid black;
        }
        .btn:hover{
            font-size: 22px;
            border-bottom:2px solid black;
            border-right: 1px solid black;
        }
        .btn{
            background-color: rgba(17, 102, 117, 0.4);
            font-size: 20px;
            border: none;
            margin: auto;
            margin-top: 5%;
        }
    </style>
  </head>
<body class="login-page" style="min-height: 332.4px;">
<!-- <%
	String error = (String) request.getAttribute("error");
	if(error == null){
		error = "";
	}
%> -->
 
<div class="main-contain">
    <div class="img">
        <img src="assets/dist/img/otp.gif" alt="" class="pass_img">
    </div>
        <div class="card">
            <div class="login-box-msg">Update Your Mobile</div>

            <div class="card-body login-card-body">
        
                <form action="ChangeMobileServlet" method="post">
                    <!-- Asking for OTP -->
                    
                    <div class="input-group mb-3">
                        <label for="otp">Enter OTP:</label>
                        <p>
                        <input type="number" class="form-control" placeholder="Enter OTP" name="otp">
                    </p>
                        <!-- <%=error %> -->
                    </div>
                    <!-- Reseting New Mobile -->
                    <div class="input-group mb-3" id="newmobile">
                        <label for="otp">Enter New Mobile Number:</label>
                            <p>
                        <input type="number" class="form-control" placeholder="Enter New Mobile Number" name="mobile">
                    </p>
                        <!-- <%=error %> -->
                    <div class="row">
                        <div class="col-12">
                            <input type="submit" class="btn btn-primary btn-block"></button>
                        </div>
                    </div>
                </div>
                    </form>  
                
            </div>
        </div>
    </div>


    <script src="assets/plugins/jquery/jquery.min.js"></script>

    <script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="assets/dist/js/adminlte.min.js?v=3.2.0"></script>


</body>