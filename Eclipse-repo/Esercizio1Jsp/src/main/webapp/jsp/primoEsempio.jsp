<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Primo Esempio</title>
	<style>
		table, th, td { border: 1px solid black; border-collapse: collapse; padding: 8px; }
	</style>
</head>
<body>
	<h2>Risposta Primo Esempio</h2>

	<%
		String testoUtente = (String) request.getAttribute("testoUtente");
	%>

	<table>
		<tr>
			<th>Campo digitato</th>
			<td><%= testoUtente %></td>
		</tr>
		<tr>
			<th>Server Name</th>
			<td><%= request.getServerName() %></td>
		</tr>
		<tr>
			<th>Server Port</th>
			<td><%= request.getServerPort() %></td>
		</tr>
		<tr>
			<th>Context Path</th>
			<td><%= request.getContextPath() %></td>
		</tr>
	</table>

	<br>
	<a href="<%= request.getContextPath() %>/jsp/start.jsp">Torna a start.jsp</a>
</body>
</html>