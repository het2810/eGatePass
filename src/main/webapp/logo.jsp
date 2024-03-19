<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
      .main{
        width: 80%;
        margin: auto;
        margin-top: 15%;
        /* border:1px solid black; */
        height: 30vh;
        text-align: center;
        color:rgb(21, 32, 106);
        padding: 2px;
        font-size: 200px;
        font-style: italic;
        border-radius: 20px;
        text-decoration: underline;
        animation-duration: 4s;
        animation-name: title;
        animation-iteration-count: infinite;
        overflow: hidden;


      }
      @keyframes title {
            0% {width:0px }
            5% {width:50px}
            10% {width:100px}
            15% {width:150px}
            20% {width:200px}
            25% {width:250px}
            30% {width:300px}
            35% {width:350px}
            40% {width:400px}
            45% {width:450px}
            50% {width:500px}
            55% {width:550px}
            60% {width:600px}
            65% {width:650px}
            70% {width:700px}
            75% {width:750px}
            80% {width:800px}
            85% {width:850px}
            90% {width:900px}
            795% {width:950px}
            1000% {width:1000px}

      }
      p{
        font-size: 36px;
        width: 80%;
        margin: auto;
        font-weight: bolder;
        color:rgb(172, 80, 41);
        /* border:1px solid black; */
        height: 5.5vh;
        text-align: center;
        animation-duration: 10s;
        animation-iteration-count: infinite;
        animation-name: start;
        overflow: hidden;
        letter-spacing: 3px;
    }
    @keyframes start {
            0% {width:0px }
            10% {width:100px }
            20% {width:200px}
            30% {width:300px}
            40% {width:400px}
            50% {width:500px}
            60% {width:600px}
            70% {width:700px}
            80% {width:800px}
            90% {width:900px}
            100% {width:10 00px}
    }
    a{
    	text-decoration:none;
    	color:rgb(172, 80, 41);
    }
      </style>
</head>
<body>
    <div class="main">
        GATEPASS
    </div>
    <p><a href="login4.jsp" >Let's Get Started!!</a></p>

</body>
</html>