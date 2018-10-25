<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String url = request.getContextPath();
	response.sendRedirect(url + "/home");
%>