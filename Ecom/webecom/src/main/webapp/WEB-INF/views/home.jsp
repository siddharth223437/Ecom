<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sid Store</title>
</head>
<body>


<div class="container">
	<div class="page-header">
            <h4>Customer Registration</h4>

            <p class="lead">Fill the below information to add Customer:</p>
        </div>
	<div class="row">
		<div class="col-sm-6">
		<form:form action="${pageContext.request.contextPath}/signup" method="post" modelAttribute="user">
			
		<div class="form-group">
            <label for="firstname">Fisrt Name</label>
            <form:input path="firstName" id="customerfirstName" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="lastname">Last Name</label>
            <form:input path="lastName" id="customerlastName" class="form-Control"/>
        </div>
       
        <%--  <div class="form-group">
            <label for="city">Country</label>
            <form:select path="customerCountry" class="form-Control">
            <form:option value="NONE" label="--SELECT--"></form:option>
            <form:options items="${listRess}" />
            </form:select>
        </div>
        <div class="form-group">
            <label for="state">State</label>
            <form:select path="customerState" class="form-Control">
            <form:option value="NONE" label="--SELECT--"></form:option>
            <form:options items="${liststate}" />
            </form:select>
        </div> --%>
        <div class="form-group">
            <label for=customerUserName>Username</label>
            <form:input path="username" id="customerUserName" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for=customerPassword>Password</label>
            <form:input path="password" id="customerPassword" class="form-Control"/>
        </div>
        <br><br>
        <input type="submit" value="submit" class="btn btn-default"/>
		</form:form>
		
		</div>
	
	</div>

</div>


	
</body>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="${pageContext.request.contextPath}/assets/css/home.css" rel="stylesheet" >
  

</html>