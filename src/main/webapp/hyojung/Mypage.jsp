<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지(회원정보)</title>
<style>
  * {margin: 0; padding: 0; box-sizing: border-box;}

  /*꼬리말*/
  footer{float: left;}

</style>
</head>
<body>
  <form>
<%-- !!!!!!!!!!!!!!파일 이동 시 변경해야 하는 주소!!!!!!!!!!!!!!!--%>
<jsp:include page="/hyojung/Header.jsp"></jsp:include>
    <div id="content-wrap">
      <aside>
        <h1>My Page</h1>
        <ul>
          <li><a href="#a" class="active">회원정보</a></li>
          <li><a href="#b">예매내역</a></li>
          <li><a href="#c">문의내역</a></li>
        </ul>
      </aside>
    </div>
      <section>
        <article class="UserInformation">
          <table><h2>회원정보</h2></table>
<%-- !!!!!!!!!!!!!!파일 이동 시 변경해야 하는 주소!!!!!!!!!!!!!!!--%>       
           <form action="userlist" method="dohandle" name="frm">
	        <table>
	            <tr>
	              <td id="inputset1">아이디</td>
	              <td><input id="inputset2" name="changeId" value='${id}'></td>
	              
	              <td></td>
	            </tr>
	            <tr>
	              <td id="inputset1">비밀번호</td>
	              <td><input id="inputSet2" name="changePwd" type="password" size="40" value='${pwd}'></td>
	            </tr>
	            <tr>
	              <td id="inputset1">비밀번호 확인</td>
	              <td><input id="inputSet2" name="changePwd2" type="password" size="40"></td>
	            </tr>
	            <tr>
	              <td id="inputset1">이름</td>
	              <td><input id="inputSet2" name="changeName" value='${name}'></td>
	            </tr>
	            <tr>
	              <td id="inputset1">이메일</td>
	              <td><input id="inputSet2" name="email" value='${email}'></td>
	            </tr>

	            <tr>
	              <td colspan="2">
	                <input class="button" type="button" value="수정하기"/>
	                <input class="button" type="reset" value="다시쓰기"/>
	              </td>
	            </tr>
	          </table>
	          </form>
	          
<%-- !!!!!!!!!!!!!!파일 이동 시 변경해야 하는 주소!!!!!!!!!!!!!!!--%>
	         	<form action="mypage.do">
				<br />
				<table>
				<tr>
				<td colspan="2">회원탈퇴</td>
				</tr>
				<tr>
					<td><input type="password" name="pwd"></td>
					<td ><input class="button" type="submit" value="입력"></td>
				</tr>			
				<input type="hidden" name="co_id" value="${loginUser}">
				</tr>
				</table>
			</form>
        </article>
        </section>
    </form>
</body>
</html>