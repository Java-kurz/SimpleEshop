<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>

<head>
	<title>Products List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/stylesheet.css' />" rel="stylesheet"></link>
</head>

<body>

<%@include file="eshop-navbar.jsp" %>

<div class="main">


 <div class="well lead"><spring:message code="customer.header" /></div>


		<form:form action="customer_administration" method="POST" modelAttribute="checkOutModel" class="form-horizontal">
			<form:input type="hidden" path="orderId" id="orderId"/>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">
						<spring:message code="customer.name" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="street	">
						<spring:message code="customer.street" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="street" id="street" class="form-control input-sm"/>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="city">
						<spring:message code="customer.city" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="city" id="city" class="form-control input-sm"/>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="psc">
						<spring:message code="customer.psc" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="psc" id="psc" class="form-control input-sm"/>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="phone">
						<spring:message code="customer.phone" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="phone" id="phone" class="form-control input-sm"/>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">
						<spring:message code="customer.email" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email" class="form-control input-sm"/>
					</div>
				</div>
			</div>
			
			<input type="submit" value="<spring:message code="admin.productAdmin.form.btn.save" />" class="btn btn-success"/> 
			</form:form>
		
	</div>

</body>
</html>