<%@page import="dbpkg.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberVO vo = (MemberVO)request.getAttribute("vo");
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
			<h3>홈쇼핑 회원 정보수정</h3>
			<br />
			<form name="frm" action="memberMod" method="post">
				<table>
					<tr>
						<th>회원번호(자동발생)</th>
						<td><input type="text" name="custno" autocomplete="off"
							required="required" readonly="readonly"
							value="<%=vo.getCustno()%>" /></td>
					</tr>
					<tr>
						<th>회원성명</th>
						<td><input type="text" autofocus="autofocus" name="custname"
							autocomplete="off" required="required"
							value="<%=vo.getCustname()%>" /></td>
					</tr>
					<tr>
						<th>회원전화</th>
						<td><input type="tel" name="phone" autocomplete="off"
							required="required" value="<%=vo.getPhone()%>" /></td>
					</tr>
					<tr>
						<th>회원주소</th>
						<td><input type="text" name="address" autocomplete="off"
							required="required" value="<%=vo.getAddress()%>" /></td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td><input type="text" readonly="readonly" name="joindate"
							autocomplete="off" required="required"
							value="<%=vo.getJoindate()%>" /></td>
					</tr>
					<tr>
						<th>고객등급[A:VIP,B:일반,C:직원]</th>
						<td><input type="text" name="grade" autocomplete="off"
							required="required" value="<%=vo.getGrade()%>" maxlength="1" /></td>
					</tr>
					<tr>
						<th>도시코드</th>
						<td><input type="text" name="city" autocomplete="off"
							required="required" value="<%=vo.getCity()%>" maxlength="2" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" value="등록" />
							<button value="조회" onclick="location.href='memberSelect'">조회</button></td>
					</tr>
				</table>
			</form>
		</section>
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>