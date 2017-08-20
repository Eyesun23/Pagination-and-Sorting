<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	
	<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
	    <form:label path="dojo">Dojo: 
	    <form:errors path="dojo"/>
	    <form:select path="dojo" items="${dojos}" itemValue="id" itemLabel="name"/></form:label>
	    
	    <br><br>
	    
	    <form:label path="firstName">First Name: 
	    <form:errors path="firstName"/>
	    <form:input path="firstName"/></form:label>
	    
	    <br><br>
	    
	    <form:label path="lastName">Last Name: 
	    <form:errors path="lastName"/>
	    <form:input path="lastName"/></form:label>
	    
	    <br><br>
	    
	    <form:label path="age">Age: 
	    <form:errors path="age"/>
	    <form:input path="age"/></form:label>
	    
	    <br><br>
	    
	    <input type="submit" value="Create"/>
	</form:form>
</body>
</html>