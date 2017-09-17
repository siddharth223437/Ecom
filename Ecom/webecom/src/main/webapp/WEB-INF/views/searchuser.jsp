<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search User</title>
</head>
<body>
<div class="container">
<div class="page-header">
            <h4>Search Customer</h4>

            <p class="lead">search customer by user name</p>
        </div>
        <div class="row">
        	<div class="col-sm-6">
        	<form:form action="${pageContext.request.contextPath}/customers/searchuser" modelAttribute="searchByUsername" method="post">
        	<div class="form-group">
            <label for="searchByUserName">Enter User Name</label>
            <form:input path="customerLogin.customerUserName" id="customerLogin.customerUserName" class="form-Control"/>
        </div>
        	<br><br>
        	 <input type="submit" value="submit" class="btn btn-default"/>
        	</form:form>
        	</div>
        </div>
        <br><br>
        <div class="row">
        	<div class="col-sm-1">
        <h6>Customer id is : ${searchResult.customerId}</h6>
        </div>
        <div class="col-sm-8">
        <h6>Customer Address is : ${searchResult.customerAddress}</h6>
        </div>
         <div class="col-sm-3">
        <h6>Customer User Name is : ${searchResult.customerLogin.customerUserName}</h6>
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