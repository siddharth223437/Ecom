<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-Com here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">E-Com</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/productlist">Products</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
	<div class="page-header">
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now!</p>
        </div>
	<div class="row">
		<div class="col-md-10">
			<table class="table table-striped table-hover">
				<tr class="bg-success">	
					<th>Photo Thumb</th>
                		<th>Product Name</th>
                		<th>Category</th>
                		<th>Condition</th>
                		<th>Price</th>
				</tr>
				<c:forEach items="${products}" var="pList">
					<tr>
						<td>Image File</td>
						<td>${pList.productName}</td>
						<td>${pList.productCategory}</td>
						<td>${pList.productCondition}</td>
						<td>${pList.productPrice}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

</body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="${pageContext.request.contextPath}/assets/css/home.css" rel="stylesheet" >
</html>