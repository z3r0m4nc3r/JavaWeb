<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%int contador=(Integer)session.getAttribute("contador"); 
	int megusta=(Integer)application.getAttribute("megusta");
	int activos=(Integer)application.getAttribute("contadorActivos");%>
	<h1>Total de visitas a mi página: <%=contador %></h1>
	<h1>Total megusta: <%=megusta %></h1>
	<h1>Total usuarios activos: <%=activos%></h1>
	<br/><br/>
	<a href="inicio.jsp">Volver</a>
</body>
</html>