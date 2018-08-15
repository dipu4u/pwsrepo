<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form:form action="/admin/product.do" method="POST" modelAttribute="productDataModel" >
<sec:csrfInput/>
<c:if test="${productDataModel.productId ne null}">
<input type="hidden" name="_method" value="PUT" />
</c:if>

<form:hidden path="productId" />
<table cellspacing="2" cellpadding="2" align="left">
<tr>
	<td>Product Name</td>
	<td>
		<form:input path="productName" size="30" maxlength="50" cssErrorClass="fieldError" />
		<form:errors path="productName" cssClass="errormsg" />
	</td>
</tr>
<tr>
	<td>Product Type</td>
	<td>
		<form:radiobuttons path="productType" items="${productTypeList}" />
		<form:errors path="productType" cssClass="errormsg" />
	</td>
</tr>
<tr>
	<td>Category</td>
	<td>
		<form:input path="category" size="30" maxlength="50" cssErrorClass="fieldError" />
		<form:errors path="category" cssClass="errormsg" />
	</td>
</tr>
<tr>
	<td>Active</td>
	<td><form:checkbox path="active" /></td>
</tr>
<tr>
	<td>Deleted</td>
	<td><form:checkbox path="deleted"/></td>
</tr>
<tr>
	<td></td>
	<td><button type="submit" value="Submit">Submit</button></td>
</tr>
</table>
</form:form>