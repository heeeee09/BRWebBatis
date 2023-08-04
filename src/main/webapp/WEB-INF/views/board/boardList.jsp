<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>1:1 문의 내역</title>
	    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	    <link rel="stylesheet" href="../resources/css/inquiryList.css">
	    <link rel="stylesheet" href="../resources/css/reset.css">
	    <link rel="stylesheet" href="../resources/css/logo_nav_footer.css">
	</head>
	<body>
	    <div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	        <section>
	            <div id="inquiryBox">
	                <p>${sessionScope.memberName }님이 문의하신 내용입니다</p>
	                <div id="line1"></div>
	                <table>
	                	<thead>
		                    <tr id="list1">
		                        <th>문의날짜</th>
		                        <th class="titles">제목</th>
		                        <th>답변여부</th>
		                        <th>삭제하기</th>
		                    </tr>
	                    </thead>
	                    <tbody>
	                    	<c:forEach var="board" items="${requestScope.bList }">
							<tr>
								<td>${board.boardDate }</td>
								<td><a href="/board/detail.do?boardNo=${board.boardNo }">${board.boardSubject }</a></td>
								<td>확인중</td>
								<td>X</td>
							</tr>
							</c:forEach>
							<tr>
							<td colspan="5" align="center">
								${pageNavi }
							</td>
							</tr>
	                    </tbody>
	                </table>
	                <div id="buttonBox">
	                    <a href="/board/boardInsert.do"><button type="submit" id="write">1:1 문의하기</button></a>
	                </div>
	            </div>
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