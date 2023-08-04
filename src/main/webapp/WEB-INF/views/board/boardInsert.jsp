<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>1:1 문의 작성하기</title>
	    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	    <link rel="stylesheet" href="../resources/css/inquiryWrite.css">
	    <link rel="stylesheet" href="../resources/css/reset.css">
	    <link rel="stylesheet" href="../resources/css/logo_nav_footer.css">
	</head>
	<body>
	    <div id="container">
	        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	        <section>
	            <form action="/board/boardInsert.do" method="post">
		            <div id="inquiryBox">
		                <p>1:1 문의하기</p>
		                <div id="line1"></div>
		                    <div id="titles">
		                        <label for="">제목</label>
		                        <input id="titleBox" type="text" name="boardSubject" placeholder="  게시글의 제목을 입력해주세요">
		                    </div>    
		                    <div>
		                        <textarea id="writeBox" name="boardContent" placeholder="문의내용을 작성해주세요. 욕설 및 비방은 무통보 삭제될 수 있습니다."></textarea>
		                    </div>
		                <div id="buttonBox">
		                    <button type="submit" id="write">1:1 문의하기</button>
		                </div>
		            </div>
	            </form>
	        </section>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	    </div>
	    
	    <script>
        function logoLink() {
            location.href = "/index.jsp"
        }
        function loginLink() {
            location.href = "/member/login.do"
        }
        function mypageLink() {
            location.href = "/member/myPage.do"
        }
	        function basketLink() {
	            location.href = "./myBasket.html"
	        }
	        function menuLink() {
	            location.href = "../product/menu.html"
	        }
	        function storeLink() {
	            location.href = "../etc/storeSearch.html"
	        }
	    </script>
	</body>
</html>