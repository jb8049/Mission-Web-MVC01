<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/board/list.do">게시판</a><br>
	<a href="<%= request.getContextPath() %>/board/writeForm.do">글등록</a><br>
	<a href="<%= request.getContextPath() %>/member/memberList.do">회원목록</a><br>
	
	<c:if test="${ empty sessionScope.userVO }">
		<a href="<%= request.getContextPath() %>/login/login.do">로그인</a><br>
	</c:if>
	<c:if test="${ not empty sessionScope.userVO }">
		<a href="<%= request.getContextPath() %>/logout/logout.do">로그아웃</a><br>
	</c:if>
</body>
</html>