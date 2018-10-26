<%@page import="java.util.ArrayList"%>
<%@page import="dbpkg.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MemberVO> lv = null;
	if (request.getAttribute("lv") != null) {
		lv = (List<MemberVO>) request.getAttribute("lv");
	} else {
		lv = new ArrayList<MemberVO>();
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
			<h3>회원목록조회/수정</h3>
			<br />
			<table>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>가입일자</th>
					<th>고객등급</th>
					<th>거주지역</th>
				</tr>
				<%
					for (int i=0; i < lv.size(); i++) {
				%>
				<tr>
					<td><%=lv.get(i).getCustno() %></td>
					<td><%=lv.get(i).getCustname() %></td>
					<td><%=lv.get(i).getPhone() %></td>
					<td><%=lv.get(i).getAddress() %></td>
					<td><%=lv.get(i).getJoindate() %></td>
					<td><%=lv.get(i).getGrade() %></td>
					<td><%=lv.get(i).getCity() %></td>
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