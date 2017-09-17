<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Primary Account</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <ul class="navbar-nav pull-right">
    <li><a>Welcome <b>${username}</b></a></li>
    </ul>
  </div>
</nav>
<br><br>
<div class="container">

	<br><br>
	<div class="row">
		<div class="col-sm-8">
			<p>Customer Primary Account Balance is : <b>${primAct.accountBalance}</b></p>
		</div>
		<div class="col-sm-4">
			<p>Customer Account Number is : <b>${primAct.accountNumber}</b></p>
		</div>
	</div>
	<%-- <br><br>
	<div class="row">
		<div class="col-sm-6">
			<h4>Customer Account Number is : <b>${primact.accountNo}</b></h4>
		</div>
	</div>
	<br><br>
	<div class="row">
		<div class="col-sm-6">
			<h4>Customer Address is : <b>${primact.customers.customerAddress}</b></h4>
		</div>
	</div>
	<br><br>
	<div class="row">
		<div class="col-sm-6">
			<h4>Customer First Name : <b>${primact.customers.customerfirstName}</b></h4>
		</div>
	</div>
	<br><br>
	<div class="row">
		<div class="col-sm-6">
			<h4>Customer First Name : <b>${primact.customers.customerlastName}</b></h4>
		</div>
	</div> --%>
	
	<div class="row">
		<div class="col-sm-8">
		<table class="table table-hover">
            <thead>
            <tr>
                <th>Date</th>
                <th>Action</th>
                <th>Account Balance</th>
              
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${getPrimList}" var="primactlist">
                <tr>
                    <td>${primactlist.primaryTransactionDate}</td>
                    <td>${primactlist.primaryTransactionAction}</td>
                    <td>${primactlist.primaryAccount.accountBal} USD</td>
                </tr>
            </c:forEach>
        </table>
		</div>
	</div>
	
	
</div>

</body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="${pageContext.request.contextPath}/assets/css/home.css" rel="stylesheet" >
</html>