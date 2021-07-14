<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css">


<!-- DB를 통해 모든 회원을 조회해야함 증가시켜야하는 것은 tr -->

<script>

	function goSingUp(){
		
		location.href ="siginUpForm.jsp"

	}

</script>


</head>
<body>


	<header>
		<%-- <jsp:include page="/jsp/include/topMenu.jsp" /> --%>
		<!-- action include  -->
	</header>
	<section>
		<div align="center">
		<h2 style="font-weight: bold;">[회원 목록]</h2>
		<hr>
		<table>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>이메일</th>
				<th>주소</th>
				<th>전화번호</th>
			</tr>
			<c:forEach items="${ memberList }" var="member" >
				<tr>
					<%-- <td><a href="memberDetail.jsp?id=${ member.id }"></a></td> --%>
					<td><a href="<%=request.getContextPath() %>/member/memberDetail.do?id=${member.id}">${ member.id }</a></td>
					<td><c:out value="${ member.name }"/></td>
					<td><c:out value="${ member.email }"/></td>
					<td><c:out value="${ member.addr }"/></td>
					<td><c:out value="${ member.telphone }"/></td>			
				</tr>
			</c:forEach>

		</table>
		<br>
		<input type="button" onclick="goSingUp()" value="회원등록">
	</div>
		

	</section>
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp"%> --%>
	</footer>