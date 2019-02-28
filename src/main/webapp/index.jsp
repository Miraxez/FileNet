<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="main.java.ru.grusha.exeption.DocumentExistsExeption, 
    main.java.ru.grusha.factory.Generator, 
    main.java.ru.grusha.utils.DocumentType, 
    main.java.ru.grusha.utils.FactoryUtil, 
    java.util.TreeSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Index</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%--
	Страница открывается при запуске приложения. 
	Во вставке java-кода генерируются документы.
	--%>
	<%
		Generator generator = new Generator();
		FactoryUtil.loadStaff();
		for (DocumentType type : DocumentType.values()) {
			try {
				generator.createDocument(type);
			} catch (DocumentExistsExeption ex) {
				System.out.println(ex.getMessage());
			}
		}
	%>
	<!-- Переход на страницу со списком авторов документов -->
	<div class="button" onclick="location.href='authors.jsp'">Авторы документов</div>
</body>
</html>