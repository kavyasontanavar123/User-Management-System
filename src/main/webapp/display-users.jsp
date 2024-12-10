<%@page import="com.example.ums.entity.User"%>
<%@page import="java.util.List"%>
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
	List<User> users = (List<User>) request.getAttribute("user");
	%>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Edit</th>
				<th>Delete</th>
				
			</tr>
		</thead>
		<tbody>
			<%
			for (User user : users) {
			%>
			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getUsername()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getPassword()%></td>
				<td><a href="edit-user?id=<%=user.getId()%>">Edit</a></td>
				<td><a href="delete-user?id=<%=user.getId()%>">Delete</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>