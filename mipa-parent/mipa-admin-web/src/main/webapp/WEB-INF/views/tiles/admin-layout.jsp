<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><tiles:getAsString name="title" /></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" type="text/css" href="/static/css/adminpanel.css" />
	<script type="text/javascript" src="/static/js/admin-panel.js" ></script>
</head>
<body>
<table cellspacing="2" cellpadding="2" width="100%" height="100%">
<tr valign="top">
	<td align="left" colspan="2" style="border-bottom: 1px solid gray;height: 30px">
		<tiles:insertAttribute name="header" />
	</td>
</tr>
<tr valign="top">
	<td align="left" width="200px" style="border-right: 1px solid gray;">
		<tiles:insertAttribute name="leftmenu" />
	</td>
	<td><tiles:insertAttribute name="content" /></td>
</tr>
</table>
</body>
</html>