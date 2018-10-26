<%@page import="java.util.ArrayList"%>
<%@page import="dbpkg.MemberSaleVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MemberSaleVO> slv = null;
	if (request.getAttribute("slv") != null) {
		slv = (List<MemberSaleVO>) request.getAttribute("slv");
	} else {
		slv = new ArrayList<MemberSaleVO>();
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
		<section class="joinsec">
			<br />
			<h3>회원매출조회</h3>
			<br />
			<table>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>고객등급</th>
					<th>매출</th>
				</tr>
				<%
					for (int i = 0; i < slv.size(); i++) {
				%>
				<tr>
					<td><%=slv.get(i).getCustno()%></td>
					<td><%=slv.get(i).getCustname()%></td>
					<td><%=slv.get(i).getGrade()%></td>
					<td><%=slv.get(i).getTotalprice()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</section>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>