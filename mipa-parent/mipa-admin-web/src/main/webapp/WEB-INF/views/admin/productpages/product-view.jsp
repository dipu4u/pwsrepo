<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div>
<table cellspacing="3" cellpadding="3" align="left">
<tr>
	<td>Product Name</td>
	<td><c:out value="${productDataModel.productName}" /></td>
</tr>
<tr>
	<td>Product Type</td>
	<td><c:out value="${productDataModel.productType}" /></td>
</tr>
<tr>
	<td>Category</td>
	<td><c:out value="${productDataModel.category}" /></td>
</tr>
<tr>
	<td>Create Time</td>
	<td><c:out value="${productDataModel.createdDate}" /></td>
</tr>
<tr>
	<td>Active</td>
	<td>
		<c:choose>
			<c:when test="${productDataModel.active}">Y</c:when>
			<c:otherwise>N</c:otherwise>
		</c:choose>
	</td>
</tr>
<tr>
	<td>Deleted</td>
	<td>
		<c:choose>
			<c:when test="${productDataModel.deleted}">Y</c:when>
			<c:otherwise>N</c:otherwise>
		</c:choose>
	</td>
</tr>
<tr>
	<td></td>
	<td><br/>
	[<a href='/admin/product/edit.do?productId=<c:out value="${productDataModel.productId}"/>'>Edit</a>]&nbsp;&nbsp;
	[<a href="#" onclick="javascript:showDeleteConfirm('product-delete-frm');">Delete</a>]
	<form action="/admin/product.do" method="POST" name="product-delete-frm" id="product-delete-frm">
		<input type="hidden" name="productId" value='<c:out value="${productDataModel.productId}"/>' />
		<input type="hidden" name="_method" value="DELETE" />
		<sec:csrfInput/>
	</form>
	</td>
</tr>
</table>
</div>