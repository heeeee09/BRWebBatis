<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메뉴</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/menu.css">
    <link rel="stylesheet" href="../resources/css/reset.css">
    <link rel="stylesheet" href="../resources/css/logo_nav_footer.css">
</head>
<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <section>
            <div>
                <div id="menuTitle">ICE CREAM</div>
                <div class="menus">
                    <div>
                        <a href="./menuDetail_01_31yogurt.html"><img src="/resources/image/menu/31요거트.jpg" alt="31요거트"></a>
                        <p class="iceName">31 요거트</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="./menuDetail_02_GreenTea.html"><img src="/resources/image/menu/그린티.jpg" alt="그린티"></a>
                        <p class="iceName">그린티</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="./menuDetail_03_Rainbow.html"><img src="/resources/image/menu/레인보우 샤베트.jpg" alt="레인보우 샤베트"></a>
                        <p class="iceName">레인보우 샤베트</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="./menuDetail_04_Mintchoco.html"><img src="/resources/image/menu/민트초콜릿칩.jpg" alt="민트초콜릿칩"></a>
                        <p class="iceName">민트 초콜릿칩</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="./menuDetail_05_windy.html"><img src="/resources/image/menu/바람과 함께 사라지다.jpg" alt="바람과 함께 사라지다"></a>
                        <p class="iceName">바람과 함께 사라지다</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="./menuDetail_06_verystrawberry.html"><img src="/resources/image/menu/베리베리-스트로베리.jpg" alt="베리베리 스트로베리"></a>
                        <p class="iceName">베리베리 스트로베리</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="./menuDetail_07_Shootinstar.html"><img src="/resources/image/menu/슈팅스타.jpg" alt="슈팅스타"></a>
                        <p class="iceName">슈팅스타</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="./menuDetail_08_Almondbongbong.html"><img src="/resources/image/menu/아몬드-봉봉.jpg" alt="아몬드 봉봉"></a>
                        <p class="iceName">아몬드 봉봉</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="./menuDetail_09_MomIsAlien.html"><img src="/resources/image/menu/엄마는외계인.jpg" alt="엄마는 외계인"></a>
                        <p class="iceName">엄마는 외계인</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="./menuDetail_10_CottonCandy.html"><img src="/resources/image/menu/이상한-나라의-솜사탕.jpg" alt="이상한 나라의 솜사탕"></a>
                        <p class="iceName">이상한 나라의 솜사탕</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="./menuDetail_11_ChocoTree.html"><img src="/resources/image/menu/초코나무-숲.jpg" alt="초코나무 숲"></a>
                        <p class="iceName">초코나무 숲</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="./menuDetail_12_CookieAndCream.html"><img src="/resources/image/menu/쿠키-앤-크림.jpg" alt="쿠키 앤 크림"></a>
                        <p class="iceName">쿠키 앤 크림</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
            </div>
        </section>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>

    <script>
    	<jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
    function orderLink() {
            location.href = "../member/order.html"
        }
    </script>
</body>
</html>