<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div style="width:100%">
	Welcome&nbsp;<b><sec:authentication property="principal.userName"/></b>&nbsp;&nbsp;[<a href="/admin/home.do">Home</a>]&nbsp;&nbsp;
	<span>[<a href="#" onclick="document.forms['frm-signout'].submit();" >Logout</a>]</span>
	<form action="/signout" method="POST" name="frm-signout" id="frm-signout">
		<sec:csrfInput/>
	</form>
</div>