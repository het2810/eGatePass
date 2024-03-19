<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.dao.UserDao"%>
<%@page import="com.bean.UserBean"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

    <style>
        body {

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

        .py-2 {
            font-size: 20px;
            font-weight: bold;
        }

        body::before {
            opacity: 0.4;
        }

        .parent {
            width: 40%;
            margin: auto;
            margin-top: 10%;
        }

        .first-container {
            display: flex;
            justify-content: center;
            gap: 2rem;
            margin-bottom: 2rem;
        }

        .details {
            /* border: 2px solid blue; */
            border-radius: 10px;
            padding: 0.4rem;
            font-weight: bold;
            background-color: rgba(17, 102, 117, 0.5);
        }

        .btn {
            font-size: 20px;
            /* font-weight: bold; */
        }
    </style>
</head>

<body>
<%
		// getting enrollment and userId from cookie so that leaves can be modified and changed
		int enrollmentNumber = -1,userId=-1;
		Cookie c[] = request.getCookies();
		for (Cookie x : c) {
			if (x.getName().equals("enrollment")) {
				enrollmentNumber = Integer.parseInt(x.getValue());
			}
			if (x.getName().equals("userId")) {
				userId = Integer.valueOf(x.getValue());
			}
		}
		UserBean user = UserDao.getDetailsForRequest(enrollmentNumber);
%>
    <div class="parent">
        <div class="card text-center" style="flex:1; ">
            <div class="card-header h5 " style="background-color: rgba(17, 102, 117, 0.6); font-weight: bold;">Leave Confirmation</div>
            <div class="card-body px-5" style="padding: 3rem;">
                <div class="first-container">
                    <p class="details" >Leaves left:</p>
                    <p class="details" id="leave">
                        <%=user.getLeaves()%>
                    </p>
                </div>
                <p class="card-text py-2">
                    Do you still wanna continue with your leave?
                </p>
                <div>
                    <a href="new-request.jsp" class="btn w-100"
                        style="margin-top: 1rem;background-color: rgba(17, 102, 117, 0.6);font-weight: bold; ">Confirm</a>
                    <a href="StudentDashboardServlet" class="btn w-100"
                        style="margin-top: 1rem;background-color: rgba(17, 102, 117, 0.6);font-weight: bold;">Not Now</a>
                </div>

            </div>

        </div>
</body>

</html>