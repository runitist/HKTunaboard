<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h3>홈쇼핑 회원 등록</h3>
			<form name="frm" action="memberJoin" method="post">
				<table>
					<tr>
						<th>회원번호(자동발생)</th>
						<td><input type="text" name="custno" autocomplete="off"
							required="required" readonly="readonly" value="${custno}" /></td>
					</tr>
					<tr>
						<th>회원성명</th>
						<td><input type="text" autofocus="autofocus" name="custname"
							autocomplete="off" required="required" value="" /></td>
					</tr>
					<tr>
						<th>회원전화</th>
						<td><input type="text" name="phone" autocomplete="off"
							required="required" value="" /></td>
					</tr>
					<tr>
						<th>회원주소</th>
						<td><input type="text" name="address" autocomplete="off"
							required="required" value="" /></td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td><input type="text" name="joindate" autocomplete="off"
							required="required" value="" /></td>
					</tr>
					<tr>
						<th>고객등급[A:VIP,B:일반,C:직원]</th>
						<td><input type="text" name="grade" autocomplete="off"
							required="required" value="" /></td>
					</tr>
					<tr>
						<th>도시코드</th>
						<td><input type="text" name="city" autocomplete="off"
							required="required" value="" /></td>
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