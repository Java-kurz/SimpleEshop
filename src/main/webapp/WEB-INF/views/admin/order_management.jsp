<%@page import="com.mysql.cj.jdbc.PreparedStatement.ParseInfo"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>

<head>
	<title>Administrace objednávek</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/stylesheet.css' />" rel="stylesheet"></link>
</head>

<body>

<%@include file="navbar.jsp" %>

<div class="main">
	<div class="panel panel-default">

		<div class="panel-heading">
			<span class="lead"><spring:message code="admin.orderList.header" /></span>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th><spring:message code="admin.orderList.table.th.id" /></th>
					<th><spring:message code="admin.orderList.table.th.status" /></th>
					<th width="100"></th>
					<th width="100"></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty orders}">
						<c:forEach items="${orders}" var="order">
							<tr>
								<td>${order.id}</td>
								<td>
								<c:choose>
							    	<c:when test="${order.status == 1}">
							     	   	NEZPRACOVÁNA
							    	</c:when>
							   		<c:when test="${order.status == 2}">
							        	PŘIPRAVENA K OSOBNÍMU ODBĚRU
							    	</c:when>
							    	<c:when test="${order.status == 3}">
							        	ČEKÁ NA ZBOŽÍ
							    	</c:when>
							    	<c:when test="${order.status == 4}">
							        	ODESLÁNA
							    	</c:when>
								</c:choose>				         
								</td>
								
								<td>
									<a href="<c:url value='order_detail_${order.id}' />" class="btn btn-primary">
										<spring:message code="admin.orderList.table.btn.detail" />
									</a>
								</td>
								<td>
								
								
								<form:form action="change_order_status" method="POST" modelAttribute="${order}" class="form-horizontal">
										<form:input type="hidden" path="id" id="id"/> 
										
										<form:input type="text" path="status" id="status" class="form-control input-sm" />
												
											
													
								 	
		    					<input type="submit" value="<spring:message code="admin.orderList.table.btn.editstatus" />" class="btn btn-success"/> 
								</form:form>
								</td>
								
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="3"><spring:message code="admin.orderList.emptyList" /></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
</div>

</body>
</html>