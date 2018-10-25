<%@page import="dbpkg.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MemberVO> lv = null;
	if(request.getAttribute("lv")!=null){
		lv = (List<MemberVO>)request.getAttribute("lv");
	}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Common.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tuna Board</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<section>회원 조회</section>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>