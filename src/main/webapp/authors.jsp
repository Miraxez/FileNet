<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="main.java.ru.grusha.model.staff.Person,
    main.java.ru.grusha.storage.DocumentStorage,  
    main.java.ru.grusha.utils.ReportUtil,
    java.util.TreeSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Авторы документов</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<table id="tableAuthors">
		<tr>
			<th>ID</th>
			<th>Фамилия</th>
			<th>Имя</th>
			<th>Отчество</th>
			<th>Должность</th>
			<%--
				Данный фрагмент кода формирует массив авторов, создает строки таблицы с данными авторов
			--%>
			<%
				TreeSet<Person> setOfAuthors = ReportUtil.authorsToSet(DocumentStorage.data);
				for (Person authorFromSet : setOfAuthors) {

					out.write("<tr onclick=location.href='documentsOfAuthor.jsp?id=" + authorFromSet.getId() + "'>");
					out.write("<td>" + authorFromSet.getId() + "</td><td>" + authorFromSet.getLastName() + "</td><td>"
							+ authorFromSet.getFirstName() + "</td><td>" + authorFromSet.getPatronymic() + "</td><td>"
							+ authorFromSet.getPosition() + "</td>");
					out.write("</tr>");
				}
			%>
	</table>
</body>
</html>