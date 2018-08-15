<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>MIPA Administrator Login</title>
<link rel="stylesheet" type="text/css" href="/static/css/adminpanel.css" />
</head>
<body>
<br /><br /><br /><br />
	<form:form method="POST" action="/admin-login">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<table cellspacing="8" cellpadding="8" align="center"
			style="border: 1px solid gray;">
			<tr>
				<td colspan="2" style="text-align: center;">
					<p><b>PRO WEEKLY SHOPPING</b></p>Administrator Panel
				</td>
			</tr>
			<c:if test="${not empty param.status}">
			<tr>
				<td>&nbsp;</td>
				<td>Please enter correct Username and Password</span></td>
			</tr>
			</c:if>
			<tr>
				<td>Username</td>
				<td><input type="text" name="j_username" maxlength="20"
					tabindex="1" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="j_password" maxlength="20"
					tabindex="2" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Access Account" tabindex="3" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>