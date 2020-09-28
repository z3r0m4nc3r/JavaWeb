<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align:center">
		<%
			int numero = Integer.parseInt(request.getParameter("numero"));
		%>
		<h3>
			Tabla del numero
			<%=numero%></h3>
		<table style="margin: 0 auto" border=1>
			<%
				for (int fila = 1; fila <= 10; fila++) {
			%>
			<tr>
				<td><%=numero%>X<%=fila%></td>
				<td><%=numero * fila%></td>
			</tr>
			<%}%>

		</table>
		<br/>
		<a href="Tabla.html"><input type="submit" value="Volver" /></a>
	</div>
</body>
</html>