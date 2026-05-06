<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.azienda.progetto.web.RicercaServlet" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ricerca Città</title>
</head>
<body>
	<h2>Ricerca città</h2>

	<form action="<%= request.getContextPath() %>/ricercaServlet" method="post">
		cerca <input type="text" name="<%= RicercaServlet.PARAM_RICERCA %>" required>
		<input type="submit" value="Cerca">
	</form>

	<br>
	<a href="<%= request.getContextPath() %>/jsp/start.jsp">Torna a start.jsp</a>
</body>
</html>