function showDeleteConfirm(formName) {
	if(confirm("Are you sure want to delete it?")) {
		document.forms[formName].submit();
	}
}