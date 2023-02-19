<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록출력</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>id</th>
				<th>pwd</th>
				<th>name</th>
				<th>number</th>
				<th>email</th>
				<th>joindate</th>
			</tr>
		</thead>
		
		<tbody>
		<%
	// 		List listMember = (List)request.getAttribute("list");
	// 		if(listMember.size() == 0){
	// 			//////
	// 		} else {
				
	// 			for(int i=0; i<listMember.size(); i++){
	// 				///////
	// 			}
				
	// 		}
		%>
		
		<c:choose>
				<c:when test="${ empty list }">
					<tr>
						<td colspan=5 style="text-align: center;">등록된 회원이 없습니다</td>
					</tr>
				</c:when>
				
				<c:when test="${ not (empty list) }">
					<c:forEach var="item" items="${list}" varStatus="vs" >
						<tr data-id="${ item.id }">
							<td class="id">${ item.id }</td>
							<td id="pwd">${ item.pwd }</td>
							<td>${ item["name"] }</td>
							<td>${ item["number"] }</td>
							<td>${ item.email }</td>
							<td>${ item.joinDate }</td>
						</tr>
					</c:forEach>
	<%--
	 				${list[0].id}
					<%= ( (MemberVO)( (List)request.getAttribute("list") ).get(0) ).getId() %>
	 --%>
	 			</c:when>
		</c:choose>
		</tbody>
	</table>
</body>
</html>