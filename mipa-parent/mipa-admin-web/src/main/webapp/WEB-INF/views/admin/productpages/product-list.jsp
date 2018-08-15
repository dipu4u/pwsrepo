<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h3>Product Management</h3>
<c:if test="${messageTag ne null}">
	<p class="errormsg"><spring:message code="${messageTag}" /></p>
</c:if>
<div>
	[<a href="/admin/product/create.do">New Product</a>]
	[<a href="/admin/product.do">Show Product</a>]
	[<a href="/admin/product.do?deleted=true">Show Deleted Product</a>]
</div><br/>
<table cellspacing="2" cellpadding="2" align="left" class="data-table">
	<thead>
		<tr>
			<td class="data">Product Name</td>
			<td class="data">Product Type</td>
			<td class="data">Category</td>
			<td class="data">Active</td>
			<td class="data">Deleted</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${fn:length(productList) eq 0}">
			<tr>
				<td colspan="8">No record found</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${productList}" var="prd">
				<tr>
					<td>${prd.productName}</td>
					<td>${prd.productType}</td>
					<td>${prd.category}</td>
					<td align="center">
						<c:choose>
							<c:when test="${prd.active}">Y</c:when>
							<c:otherwise>N</c:otherwise>
						</c:choose>
					</td>
					<td align="center">
						<c:choose>
							<c:when test="${prd.deleted}">Y</c:when>
							<c:otherwise>N</c:otherwise>
						</c:choose>
					</td>
					<td>[<a href="/admin/product/edit.do?productId=${prd.productId}">Edit</a>]</td>
					<td>[<a href="/admin/product/view.do?productId=${prd.productId}">View</a>]</td>
					<td>
						<form action="/admin/product.do" method="POST" name="product-delete-frm-${prd.productId}" id="product-delete-frm-${prd.productId}">
							<input type="hidden" name="productId" value='<c:out value="${prd.productId}"/>' />
							<input type="hidden" name="_method" value="DELETE" />
							<sec:csrfInput/>
						</form>
						[<a href="#" onclick="javascript:showDeleteConfirm('product-delete-frm-${prd.productId}');">Delete</a>]
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>
