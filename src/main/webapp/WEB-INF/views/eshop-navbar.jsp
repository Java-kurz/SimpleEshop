<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="sidenav">
  <a href="<c:url value='index' />"><spring:message code="eshop.menu.index" /></a>
  
  
  
			 <c:choose>
					<c:when test="${not empty categoryMap}">
						
						<c:forEach items="${categoryMap}" var="category">
						<a href="<c:url value='category?id=${category.getKey()}' />">-${category.value}</a>
  													
								
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="3"><spring:message code="admin.categoryList.emptyList" /></td>
						</tr>
					</c:otherwise>
				</c:choose> 

			
  <a href="#">&nbsp;</a>
  <a href="#">&nbsp;</a>
  <a href="<c:url value='cart' />"><spring:message code="eshop.menu.cart" /></a>
  <a href="<c:url value='admin/products' />">Admin</a>
</div>
