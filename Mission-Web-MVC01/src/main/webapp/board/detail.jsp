<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 상세</h2>
	<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css">

<script>

	function goMemberList(){
		
		location.href="list.jsp"
	}
	

</script>


</head>
<body>

	
	<header>
		<%-- <jsp:include page="/jsp/include/topMenu.jsp"/>  <!-- action include  --> --%>
	</header>
	<section>
		
		<div align="center">
		<hr width="80%">
		<h2>게시판 상세</h2>
		<hr width="80%">
		
		<br>
		<table border ="1" style="width: 80%" id="list">
		
			<tr>
				<th width="25%">번호</th> 
				<td><c:out value="${ board.no }" /></td>  <!-- no 컬럼이 가지고 있는 값을 넣자  -->
			</tr>
			<tr>
				<th width="25%">제목</th> 
				<td><c:out value="${ board.title }" /></td>
			</tr>
			<tr>
				<th width="25%">작성자</th> 
				<td><c:out value="${ board.writer }"/></td>
			</tr>
			<tr>
				<th width="25%">내용</th> 
				<td><c:out value="${ board.content }"/></td>
			</tr>
			<tr>
				<th width="25%">조회수</th> 
				<td><c:out value="${ board.viewCnt }"/></td>
			</tr>
			<tr>
				<th width="25%">등록일</th> 
				<td><c:out value="${ board.regDate }"/></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:forEach items= "${ fileList }" var="file">
						<a href="/Mission-Web/upload/${ file.fileSaveName }" download>  <!--elipse-work폴더에 저장된 이미지들 -->
						<c:out value="${ file.fileOriName }" />
						</a>
						( ${ file.fileSize } bytes)
						<br>
					</c:forEach>
				</td>
			</tr>
		
		
		</table>
		<br>
		<input type="button" onclick="goMemberList()" value="게시판 목록">
	 	<!-- remove에서 해당 게시판 번호를 인식해야함 -->
		<c:if test="${ board.writer eq userVO.id }">
			<a href="modifyForm.jsp?no=${ board.no }"><input type="button" value="수정"></a>
			<a href="remove.jsp?no=${ board.no }"><input type="button" value="삭제"></a>
		</c:if>

	</div>

	</section>
	<footer>
		<!-- bottom.jsp는 지시자 include를 사용해서 넣어보자 -->
		<!-- xml, include, forward의 '/'도 web.xml과 마찬가지로 /는  -->
		<!-- http://localhost:9999/Mission-Web'/' 바로 여기!! jsp/board/list.jsp  -->
		
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
	
	


	
</body>
</html>
</body>
</html>