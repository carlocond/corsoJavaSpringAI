<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Start</title>
</head>
<body>
	<h2>Primo esempio JSP</h2>

	<form action="<%= request.getContextPath() %>/primoEsempioServlet" method="post">
		testo <input type="text" name="testoUtente" required>
		<input type="submit" value="Invia">
	</form>

	<br>
	<a href="<%= request.getContextPath() %>/jsp/ricerca.jsp">Vai a Ricerca città</a>
</body>
</html>