<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Dongle:wght@400;700&family=East+Sea+Dokdo&family=Poor+Story&display=swap');
       
       	a{text-decoration: none;}
       	
        header{
            /* font-family: 'Dongle', sans-serif; */
            /* font-family: 'East Sea Dokdo', cursive; */
            font-family: 'Poor Story', cursive;
            margin-top: 30px;
            text-decoration:none;
		
        }
        
        .header_list {
        	font-color:black;
            padding: 0 10px 0 10px;
            letter-spacing: 1px;
            opacity: 0.85;/* ���� */
            background-color: black;
            display: flex;
            justify-content: space-around;
            text-align: center;
            height: 100px;
        }
        .header_list div{
            width: 100px;
            line-height: 100px;
            font-weight: 500;
            color: white;
            font-size: 25px;
        }
        .header_list a{
        	color:white;
        }
        #logo_human{
            width: 160px;
            height: 100px;
        }
        #logo_human img{
            width: 160px;
            height: 50px;
            vertical-align: middle;
        }
        .login_signup {
            margin-top: 10px;
            display: flex;
            justify-content: flex-end;
            color:black;  
        }
        .login_signup div{
            margin-right: 40px;
            font-weight: 600;
            font-size: 20px;
        }
        .login_signup a{
        	color:black;
        }

    </style>

</head>
<body>
    <header>
 <%-- !!!!!!!!!!!!!!���� �̵� �� �����ؾ� �ϴ� �ּ�!!!!!!!!!!!!!!!--%>
        <div class="header_list">
            <div id="h1"><a href="/HumanCinema/movie1/movieTab.do">
            	<span style="cursor: pointer">��ȭ</span></a></div>
            
            <div id="h2"><a href="">
            	<span style="cursor: pointer">����</span></a></div>
            
            <div id="h3"><a href="/HumanCinema/cinema/cinema.do">
            	<span style="cursor: pointer">����</span></a></div>
            	
            <div id="logo_human"><a href="/HumanCinema/movie1/main.do">
        		<img src="../img/logoCI.png"/></a></div>
        		
			<div id="h4"><a href="/HumanCinema/menu/store.do">
            	<span style="cursor: pointer">�����</span></a></div>
            
            <div id="h5"><a href="/HumanCinema/event1/event1.do">
            	<span style="cursor: pointer">�̺�Ʈ</span></a></div>
            
            <div id="h6"><a href="/HumanCinema/board/listArticles.do">
            	<span style="cursor: pointer">������</span></a></div>
        </div>
        <div class="login_signup">
            <div id="h7"><a href="/HumanCinema/user/login">
           		<span style="cursor: pointer">�α���</span></a></div>
            <div id="h8"><a href="/HumanCinema/user/new">
            	<span style="cursor: pointer">ȸ������</span></a></div>
        </div>
    </header>
</body>
</html>