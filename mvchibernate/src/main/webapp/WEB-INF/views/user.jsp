<%@ page import="java.util.List"%>
<%@ page import="wbjp.webmvc.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Username</th>
				<th>Name</th>
				<th>Email</th>
				<th>City</th>
			</tr>
		</thead>
		<tbody>
			<%
				@SuppressWarnings("unchecked")
				List<User> list = (List<User>) request.getAttribute("userList");
				
				for (User user : list) {
			%>
			<tr>
				<td><%=user.getUserName() %></td>
				<td><%=user.getName() %></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getCity() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>