<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>
<body>
	<h1>Dojos and Ninjas</h1>
	
	<c:forEach begin="1" end="${totalPages}" var="index">
		<a href="/pages/${index}">${index}</a>
	</c:forEach>
	<table>
		<tr>
			<th>Dojo Name</th>
			<th>Ninja First Name</th>
			<th>Ninja Last Name</th>
		</tr>
		<c:forEach items="${ninjas.content}" var="row">
		<tr>
			<td>${row.dojo.name}</td>
			<td>${row.firstName}</td>
			<td>${row.lastName}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>