<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="date" uri="/WEB-INF/date.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String roll = request.getParameter("troll"); %>
Current date and time <date:show roll=""></date:show>
</body>
</html>