<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>����Ų���</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./resource/css/index.css">
    <link rel="stylesheet" href="./resource/css/reset.css">
    <link rel="stylesheet" href="/resource/css/logo_nav_footer.css">
</head>
<body>
    <div id="container">
        <header>
            <div id="logo">
                <a href="#"><img id="logoimg" onclick="logoLink()" src="./resource/image/header_Logo.png"
                        alt="�ΰ��̹���"></a>
            </div>
            <div id="login">
            	<c:if test="${sessionScope.memberId eq null}">
                <a href="#" onclick="loginLink()" style="color: #F04DA3">LOGIN</a>
                </c:if>
            	<c:if test="${sessionScope.memberId ne null}">
                <a href="/member/logout.do" style="color: #F04DA3">LOGOUT</a>
                </c:if>
            </div>
            <div id="mypage">
                <a href="#" onclick="mypageLink()">MYPAGE</a>
            </div>
            <div id="basket">
                <a href="#" onclick="basketLink()"><img id="basketlink" src="./resource/image/header_Basket_Img.png"
                        alt="��ٱ��� ��ũ"></a>
            </div>
            <nav>
                <ul id="menu">
                    <li><a href="#" onclick="menuLink()">MENU</a></li>
                    <li style="text-align: center;"><a href="#">�������� �� <br>�˷�����</a></li>
                    <li><a href="#">EVENT</a></li>
                    <li><a href="#" onclick="storeLink()">STORE</a></li>
                    <li><a href="#">BRAND</a></li>
                    <li><a href="#">DELIVERY</a></li>
                </ul>
            </nav>
        </header>
        <main>
            <section id="main1" class="mains">
                <a href="./product/menuDetail_10_CottonCandy.html"><img id="monthFlavor" src="./resource/image/main/main_Month_Flavor.png" alt=""></a>
            </section>
            <section id="main2" class="mains">
                <div id="eventImg">
                    <div id="slide0" class="slides">
                        <a href="./product/menuDetail_11_ChocoTree.html"><img src="./resource/image/main/main_Event_1.png" alt=""></a>
                    </div>
                    <div id="slide1" class="slides">
                        <a href="./product/menuDetail_05_windy.html"><img src="./resource/image/main/main_Event_2.png" alt=""></a>
                    </div>
                    <div id="slide2" class="slides">
                        <img src="./resource/image/main/main_Event_3.png" alt="">
                    </div>
                    <div id="slide3" class="slides">
                        <img src="./resource/image/main/main_Event_4.png" alt="">
                    </div>

                    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlides(1)">&#10095;</a>
                    <br>
                    <div style="text-align:center">
                        <span class="dot" onclick="currentSlide(1)"></span>
                        <span class="dot" onclick="currentSlide(2)"></span>
                        <span class="dot" onclick="currentSlide(3)"></span>
                        <span class="dot" onclick="currentSlide(4)"></span>
                    </div>
                </div>
            </section>
            <div class="mainHeaders">
                <p id="bestMenu">BEST MENU</p>
            </div>
            <section id="main3" class="mains">
                <!-- // ����Ʈ �� �Ұ� -->
                <div id="bfLeft" class="bestFlavors">
                    <a href="./product/menuDetail_03_Rainbow.html"><img class="bfImg" src="./resource/image/menu/���κ��� ����Ʈ.jpg" alt="���κ��� ����Ʈ"></a>
                    <div class="img-caption">���κ��� ����Ʈ</div>
                </div>
                <div id="bfCenter" class="bestFlavors">
                    <a href="./product/menuDetail_05_windy.html"><img class="bfImg" src="./resource/image/menu/�ٶ��� �Բ� �������.jpg" alt="���κ��� ����Ʈ"></a>
                    <div class="img-caption">�ٶ��� �Բ� �������</div>
                </div>
                <div id="bfRight" class="bestFlavors">
                    <a href="./product/menuDetail_09_MomIsAlien.html"><img class="bfImg" src="./resource/image/menu/�����¿ܰ���.jpg" alt="���κ��� ����Ʈ"></a>
                    <div class="img-caption">������ �ܰ���</div>
                </div>
            </section>
            <div class="mainHeaders">
                <p id="withBr">WITH BASKIN ROBBINS</p>
            </div>
            <section id="main4" class="mains">
                <!-- // SNS �̵� -->
                <div id="" class="SNS">
                    <a href="https://www.facebook.com/baskinrobbinskr/" target="_blank"><img src="./resource/image/main/sns_facebook.png"
                            alt=""></a>
                </div>
                <div id="" class="SNS">
                    <a href="https://twitter.com/BaskinrobbinsKR" target="_blank"><img src="./resource/image/main/sns_twitter.png"
                            alt=""></a>
                </div>
                <div id="" class="SNS">
                    <a href="https://blog.naver.com/brgirl31" target="_blank"><img src="./resource/image/main/sns_blog.png" alt=""></a>
                </div>
                <div id="" class="SNS">
                    <a href="https://www.instagram.com/baskinrobbinskorea/" target="_blank"><img
                            src="./resource/image/main/sns_instagram.png" alt=""></a>
                </div>
                <div id="" class="SNS">
                    <a href="https://www.youtube.com/user/baskinrobbinskorea" target="_blank"><img
                            src="./resource/image/main/sns_youtube.png" alt=""></a>
                </div>
                <div id="" class="SNS">
                    <a href="https://pf.kakao.com/_xjXcmM" target="_blank"><img src="./resource/image/main/sns_kakaotalk.png" alt=""></a>
                </div>
            </section>
        </main>
        <footer class="flex">
            <section>
                <ul id="bottomMenu1" class="footers">
                    <li><a href="#">1:1 ����</a></li>
                    <li><a href="#">���ֹ�������</a></li>
                    <li><a href="#">�̿���</a></li>
                    <li><a href="#">��������ó����ħ</a></li>
                    <li><a href="#">��ġ���񽺱���̿���</a></li>
                </ul>
                <ul id="bottomMenu2">
                    <li>����� ��Ϲ�ȣ : 303-81-09535 ����ڸ���(��) ��ǥ�̻� ���ֿ�
                        ����Ư���� ���ʱ� ���μ�ȯ�� 2620(���絿 11-149����)
                    </li>
                    <li>TEL : 080-555-3131 ������������å���� : ����</li>
                    <li>Copyright�� 2016 BRKOREA Company. All Rights Reserved.</li>
                </ul>
            </section>
        </footer>
    </div>
    <script>
        function logoLink() {
            location.href = "/index.jsp";
        }
        function loginLink() {
            location.href = "/member/login.do";
        }
        function mypageLink() {
            location.href = "/member/myPage.do";
        }
        function basketLink() {
            location.href = "./member/myBasket.html";
        }
        function menuLink() {
            location.href = "./product/menu.html";
        }
        function storeLink() {
            location.href = "./etc/storeSearch.html";
        }

        var slideIndex = 1;
        showSlides(slideIndex);

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("slides");
            var dots = document.getElementsByClassName("dot");
            if (n > slides.length) { slideIndex = 1 }
            if (n < 1) { slideIndex = slides.length }
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex - 1].style.display = "block";
            dots[slideIndex - 1].className += " active";
            setTimeout(showSlides, 1000);
        }


    </script>
</body>
</html>