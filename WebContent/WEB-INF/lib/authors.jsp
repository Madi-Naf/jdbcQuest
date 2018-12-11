<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.wcsjdbcquest.bdd.JediMaster" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC QUEST</title>
</head>
<body>
	<h1>JDBC QUEST</h1>

	<% String[] names = (String[])request.getAttribute("names"); %>
	<% String[] surnames = (String[])request.getAttribute("surnames"); %>

	<ul>
	<% for(int i = 0; i < 3; i++ ){ %>
		<li>Name: <%= names[i]%>
			,Surname: <%= surnames[i]%>
		</li>
	<%} %>
	</ul>
</body>
</html>