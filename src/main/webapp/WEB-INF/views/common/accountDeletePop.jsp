<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${requestScope.title }</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./resources/css/login.css">
    <link rel="stylesheet" href="./resources/css/reset.css">
    <link rel="stylesheet" href="./resources/css/logo_nav_footer.css">
    <style>
        p {
            margin-top: 25%;
            font-family: 'Nanum Gothic', sans-serif;
            font-size: 30px;
            text-align: center; 
        }
        #closebtn {
            display: flex;
            justify-content: center;
        }
        button {
            width: 250px;
            height: 80px;
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
        #deleteBtn {
            background-color: #402022;
        }
    </style>
</head>
<body>
    <div id="container">
        <section>
        <p>정말 탈퇴하시겠습니까?<br>
        탈퇴 후 취소할 수 없습니다.</p>
        <div id="closebtn">
        <button id="deleteBtn" onclick="accountDelete()">탈퇴하기</button>
        <button onclick="window.close()">취소</button>
        </div>
        </section>
    </div>
    <script>
        function accountDelete() {
            location.href="/member/deletePop.do";
//             window.close();

        }
    </script>
</body>
</html>