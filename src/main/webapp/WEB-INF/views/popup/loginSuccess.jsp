<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 완료</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./resources/css/login.css">
    <link rel="stylesheet" href="./resources/css/reset.css">
    <link rel="stylesheet" href="./resources/css/logo_nav_footer.css">
    <style>
        p {
            margin-top: 25%;
            font-family: 'Nanum Gothic', sans-serif;
            font-size: 40px;
            text-align: center; 
        }
        #closebtn {
            display: flex;
            justify-content: center;
        }
        button {
            width: 250px;
            height: 70px;
            margin: 10px;
            border-radius: 50px;
            font-size: 30px;
            font-family: 'Nanum Gothic', sans-serif;
            border: 0px;
            font-weight: lighter;
            color: white;
            background-color: #F04DA3;
            cursor: pointer !important;
        }
    </style>
</head>
<body>
    <div id="container">
        <section>
        <p>로그인 되었습니다</p>
        <div id="closebtn">
        <button onclick="window.close()">닫기</button>
        </div>
        </section>
        </footer>
    </div>
    <script>
    </script>
</body>
</html>