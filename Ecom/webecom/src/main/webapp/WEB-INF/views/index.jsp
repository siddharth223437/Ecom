<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body >
<br><br><br><br>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<form:form action="${pageContext.request.contextPath}/login" modelAttribute="login" method="post">
			<div class="form-group">
            <label for="username">User Name</label>
            <form:input path="username" id="customerUserName" class="form-Control"/>
            <form:errors path="username" cssClass="error"></form:errors>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <form:password path="password" id="customerPassword" class="form-Control"/>
            <form:errors path="password" cssClass="error"></form:errors>
        </div>
        <br><br>
        <input type="submit" value="Login" class="btn btn-default"/>
			</form:form>
		</div>
	</div>
</div>
</body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<link href="${pageContext.request.contextPath}/assets/css/home.css" rel="stylesheet" >
</html>