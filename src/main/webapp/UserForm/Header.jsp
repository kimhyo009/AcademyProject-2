<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>��ܹ�jsp</title>
<style>
	* {top: 0; margin: 0; box-sizing: border-box;}
    a { text-decoration: none; }
    li { list-style: none; }
    /* h1, h2, h3, h4, h5, h6, p {margin: 10px 5px;} */
    /* h1 { font-size: 1.8em; } */

    body {
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        color: #58666e;
        background-color: #f0f3f4;
        -webkit-font-smoothing: antialiased;
        /* iphone font size ���� ���� */
        -webkit-text-size-adjus: 100%;  
    }

    .wrap {
        width: 100%; 
        margin-top: 80px;
        position:relative;
        /* background:url() no-repeat center; */
    }
    header {
        width: 100%;
        height: 80px;
        z-index: 2000;
        position: fixed;/*z-index ������ fixed*/
        background-color: #fff;
        /* box-shadow: 0 2px 2px rgba(0, 0, 0, 0.05),
                       0 1px 0 rgba(0, 0, 0, 0.05); */
    }
    .logo {
      display: inline-block;
      height: 5px;
      margin: 12px 0 12px 25px;}
    .logo > img { height: 50px;}
    nav {
    	display: flex;
        justify-content: space-around;
        }
    .nav-items {margin-right: 20px;}
    .nav-items > li {display: inline-block;}
    .nav-items > li > a {
      /* for Vertical Centering */
      line-height: 80px;
      padding: 0 30px;
      color: rgb(0, 0, 0);}
    .nav-items > li > a:hover {color: gold;}
</style>
</head>
<body>
<div class="wrap">
    <header>
        <nav id="nav">
        <ul class="nav-items">
            <li><a href="#">��ȭ</a></li>
            <li><a href="#">����</a></li>
            <li><a href="#">����</a></li>
            <a class="logo" href="#home">�ΰ�</a>
            <li><a href="#">�����</a></li>
            <li><a href="#">������</a></li>
            <li><a href="#">�α���</a></li>
        </ul></nav>
    </header></div>
</body>
</html>