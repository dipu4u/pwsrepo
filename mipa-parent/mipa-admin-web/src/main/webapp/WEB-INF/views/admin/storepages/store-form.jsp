<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form action="/admin/store.do" method="POST" modelAttribute="storeDataModel" >
<sec:csrfInput/>
<c:if test="${storeDataModel.storeId ne null}">
<input type="hidden" name="_method" value="PUT" />
</c:if>

<form:hidden path="storeId" />
<table cellspacing="2" cellpadding="2" align="left">
<tr>
	<td>Store Name</td>
	<td>
		<form:input path="storeName" size="30" maxlength="50" cssErrorClass="fieldError" />
		<form:errors path="storeName" cssClass="errormsg" />
	</td>
</tr>
<tr>
	<td>Store Type</td>
	<td>
		<label for="store-type-id">
			<form:radiobutton path="storeType" cssErrorClass="fieldError" value="STORE" id="store-type-id"/>
			Store
		</label>
		<label for="supermarket-type-id">
			<form:radiobutton path="storeType" cssErrorClass="fieldError" value="SUPER_MARKET" id="supermarket-type-id"/>
			Super Market
		</label>
		<form:errors path="storeType" cssClass="errormsg" />
	</td>
</tr>
<tr>
	<td>Branch</td>
	<td>
		<form:input path="branch" size="40" maxlength="50" cssErrorClass="fieldError" />
		<form:errors path="branch" cssClass="errormsg" />
	</td>
</tr>
<tr>
	<td>Address</td>
	<td>
		<form:input path="address" size="50" maxlength="150" cssErrorClass="fieldError"/>
		<form:errors path="address" cssClass="errormsg" />
	</td>
</tr>
<tr>
	<td>Pincode</td>
	<td>
		<form:input path="pincode" size="10" maxlength="10" cssErrorClass="fieldError" />
		<form:errors path="pincode" cssClass="errormsg"/>
	</td>
</tr>
<tr>
	<td>Latitude</td>
	<td>
		<form:input path="latitude" size="10" maxlength="10" cssErrorClass="fieldError" />
		<form:errors path="latitude" cssClass="errormsg"/>
	</td>
</tr>
<tr>
	<td>Longitude</td>
	<td>
		<form:input path="longitude" size="10" maxlength="10" cssErrorClass="fieldError" />
		<form:errors path="longitude" cssClass="errormsg"/>
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