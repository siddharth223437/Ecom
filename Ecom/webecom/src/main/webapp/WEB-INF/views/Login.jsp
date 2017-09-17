<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-6">
			<form:form action="${pageContext.request.contextPath}/login" modelAttribute="login" method="post">
			<div class="form-group">
            <label for="username">User Name</label>
            <form:input path="username" id="customerUserName" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <form:password path="password" id="customerPassword" class="form-Control"/>
        </div>
        <br><br>
        <input type="submit" value="Login" class="btn btn-default"/>
			</form:form>
		</div>
	</div>
</div>
</body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="${pageContext.request.contextPath}/assets/css/home.css" rel="stylesheet" >
</html>