<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome ${objUser.name }</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Category Name</th>
				<th>Category Description</th>
				<th>Category Image</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categoryList }" var="c">
				<tr>
					<td><a href="product">${c.categoryName }</a></td>
					<td>${c.categoryDescription }</td>
					<td><img
						src="${pageContext.request.contextPath }/Images/${c.imageURL}"
						height="100px" width="100px" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>