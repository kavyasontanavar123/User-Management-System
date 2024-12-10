<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String message=(String)request.getAttribute("errorMessage");
String url=(String)request.getAttribute("redirectTo");
%>
<h2 ><%= message%></h2>
<a href= "<%=url %>">Back</a>

</body
</html>