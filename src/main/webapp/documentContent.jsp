<%@page
	import="ru.grusha.storage.DocumentStorage,  
    ru.grusha.model.documents.Document,
    ru.grusha.model.documents.Incoming,
    ru.grusha.model.documents.Outgoing,
    ru.grusha.model.documents.Task"%>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Документ</title>
</head>
<body>
<% 
String chosenDocumentId = (String) request.getAttribute("chosenDocumentId");
int documentId = Integer.parseInt(chosenDocumentId);
for (Document documentFromStorage : DocumentStorage.data) {
	if (documentFromStorage.getId()==documentId){
		out.write(documentFromStorage.toString());
	}
}
%>
</body>
</html>