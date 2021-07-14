<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css">
</head>
<body>

	<header>
		<%-- <jsp:include page="/include/topMenu.jsp" /> --%>

	</header>
	<section>
		<div align="center">
		<h2 style="font-weight: bold">[회원 상세 정보]</h2>
		<hr>
		<table>
			<tr>
				<th>아이디</th><td>${member.id }</td>
			</tr>
			<tr>
				<th>이름</th><td>${member.name }</td>
			</tr>
			<tr>
				<th>비밀번호</th><td>${member.password }</td>
			</tr>
			<tr>
				<th>이메일</th><td>${member.email }</td>
			</tr>
			<tr>
				<th>전화번호</th><td>${member.telphone }</td>
			</tr>
			<tr>
				<th>우편번호</th><td>${member.post }</td>
			</tr>
			<tr>
				<th>주소</th><td>${member.addr }</td>
			</tr>
			<tr>
				<th>성별</th><td>${member.type }</td>
			</tr>
			<tr>
				<th>등록일자</th><td>${member.regDate }</td>
			</tr>

		
		</table>
	
		<br>
		<input type="button" onclick="goMemberList()" value=회원목록>
	</div>
		

	</section>
	<footer>
		<%-- <%@ include file="/include/bottom.jsp"%> --%>
	</footer>

</body>
</html>