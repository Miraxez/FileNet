<%@page
	import="main.java.ru.grusha.utils.FormatUtil,
	main.java.ru.grusha.model.staff.Person,
    main.java.ru.grusha.storage.DocumentStorage,  
    main.java.ru.grusha.utils.ReportUtil,
    java.util.TreeSet,
    java.util.List,
    java.util.ArrayList,
    main.java.ru.grusha.model.documents.Document,
	main.java.ru.grusha.model.staff.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Документы</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<table id="tableDocuments">
		<tr>
			<th>ID</th>
			<th>Название</th>
			<th>Дата регистрации</th>
			<th>Регистрационный номер</th>
			<%--
				Данный фрагмент кода формирует массив документов автора, создает строки таблицы с данными документов
			--%>
			<%
				if (request.getParameter("id") != null) {
					int authorId = Integer.parseInt((String) request.getParameter("id"));
					//out.write(authorId + "");
					List<Document> documentsOfAuthor = new ArrayList<Document>();
					for (Document documentFromStorage : DocumentStorage.data) {
						if (authorId == documentFromStorage.getAuthor().getId()) {
							documentsOfAuthor.add(documentFromStorage);
							//out.write(documentFromStorage.toString());
						}
					}
					for (Document document : documentsOfAuthor) {

						out.write("<tr onclick=location.href='document.jsp?id=" + document.getId() + "'>");
						out.write("<td>" + document.getId() + "</td><td>" + document.getName() + "</td><td>"
								+ FormatUtil.formatDate(document.getRegistrationDate()) + "</td><td>"
								+ document.getRegistrationNumber() + "</td>");
						out.write("</tr>");
					}
				} else
					response.sendRedirect("authors.jsp");
			%>
		
	</table>
	<div class='button' onclick="location.href='authors.jsp'">Назад</div>
</body>
</html>