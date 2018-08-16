<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h3>Store Management</h3>
<c:if test="${param.code ne null}">
	<p class="errormsg"><spring:message code="${param.code}" /></p>
</c:if>
<div>
	[<a href="/admin/store/create.do">New Store</a>]
	[<a href="/admin/store.do">Show Store</a>]
	[<a href="/admin/store.do?deleted=true">Show Deleted Store</a>]
</div><br/>
<table cellspacing="2" cellpadding="2" align="left" class="data-table">
	<thead>
		<tr>
			<td class="data">Store Name</td>
			<td class="data">Store Type</td>
			<td class="data">Branch</td>
			<td class="data">Pincode</td>
			<td class="data">Active</td>
			<td class="data">Deleted</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${fn:length(storeList) eq 0}">
			<tr>
				<td colspan="11">No record found</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${storeList}" var="st">
				<tr>
					<td>${st.storeName}</td>
					<td>${st.storeType}</td>
					<td>${st.branch}</td>
					<td>${st.pincode}</td>
					<td align="center">
						<c:choose>
							<c:when test="${st.active}">Y</c:when>
							<c:otherwise>N</c:otherwise>
						</c:choose>
					</td>
					<td align="center">
						<c:choose>
							<c:when test="${st.deleted}">Y</c:when>
							<c:otherwise>N</c:otherwise>
						</c:choose>
					</td>
					<td>[<a href="/admin/store/edit.do?storeId=${st.storeId}">Edit</a>]</td>
					<td>[<a href="/admin/store/view.do?storeId=${st.storeId}">View</a>]</td>
					<td>
						<c:if test="${param.deleted eq null}">
							<form action="/admin/store.do" method="POST" name="store-delete-frm-${st.storeId}" id="store-delete-frm-${st.storeId}">
								<input type="hidden" name="storeId" value='<c:out value="${st.storeId}"/>' />
								<input type="hidden" name="_method" value="DELETE" />
								<sec:csrfInput/>
							</form>
							[<a href="#" onclick="javascript:showDeleteConfirm('store-delete-frm-${st.storeId}');">Delete</a>]
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>
