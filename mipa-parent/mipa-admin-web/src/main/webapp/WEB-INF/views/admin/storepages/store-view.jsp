<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div>
<table cellspacing="3" cellpadding="3" align="left">
<tr>
	<td>Store Name</td>
	<td><c:out value="${storeDataModel.storeName}" /></td>
</tr>
<tr>
	<td>Store Type</td>
	<td><c:out value="${storeDataModel.storeType}" /></td>
</tr>
<tr>
	<td>Branch</td>
	<td><c:out value="${storeDataModel.branch}" /></td>
</tr>
<tr>
	<td>Address</td>
	<td><c:out value="${storeDataModel.address}" /></td>
</tr>
<tr>
	<td>Pincode</td>
	<td><c:out value="${storeDataModel.pincode}" /></td>
</tr>
<tr>
	<td>Latitude</td>
	<td><c:out value="${storeDataModel.latitude}" /></td>
</tr>
<tr>
	<td>Longitude</td>
	<td><c:out value="${storeDataModel.longitude}" /></td>
</tr>
<tr>
	<td>Create Time</td>
	<td><c:out value="${storeDataModel.createdDate}" /></td>
</tr>
<tr>
	<td>Longitude</td>
	<td><c:out value="${storeDataModel.longitude}" /></td>
</tr>
<tr>
	<td>Active</td>
	<td>
		<c:choose>
			<c:when test="${storeDataModel.active}">Y</c:when>
			<c:otherwise>N</c:otherwise>
		</c:choose>
	</td>
</tr>
<tr>
	<td>Deleted</td>
	<td>
		<c:choose>
			<c:when test="${storeDataModel.deleted}">Y</c:when>
			<c:otherwise>N</c:otherwise>
		</c:choose>
	</td>
</tr>
<tr>
	<td></td>
	<td><br/>
	[<a href='/admin/store/edit.do?storeId=<c:out value="${storeDataModel.storeId}"/>'>Edit</a>]&nbsp;&nbsp;
	[<a href="#" onclick="javascript:showDeleteConfirm('store-delete-frm');">Delete</a>]
	<form action="/admin/store.do" method="POST" name="store-delete-frm" id="store-delete-frm">
		<input type="hidden" name="storeId" value='<c:out value="${storeDataModel.storeId}"/>' />
		<input type="hidden" name="_method" value="DELETE" />
		<sec:csrfInput/>
	</form>
	</td>
</tr>
</table>
</div>