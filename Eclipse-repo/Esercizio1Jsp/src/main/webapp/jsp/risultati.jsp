<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Risultati Ricerca</title>
	<style>
		table, th, td { border: 1px solid black; border-collapse: collapse; padding: 8px; }
	</style>
</head>
<body>
	<h2>Risultati ricerca</h2>

	<%
		List<String> risultati = (List<String>) request.getAttribute("risultati");
		String testoRicerca = (String) request.getAttribute("testoRicerca");
	%>

	<p>Ricerca effettuata: <b><%= testoRicerca %></b></p>

	<% if (risultati != null && !risultati.isEmpty()) { %>
		<table>
			<tr>
				<th>Città trovata</th>
			</tr>
			<% for (String citta : risultati) { %>
				<tr>
					<td><%= citta %></td>
				</tr>
			<% } %>
		</table>
	<% } else { %>
		<p>Nessun risultato trovato.</p>
	<% } %>

	<br>
	<a href="<%= request.getContextPath() %>/jsp/ricerca.jsp">Torna alla ricerca</a>
</body>
</html>