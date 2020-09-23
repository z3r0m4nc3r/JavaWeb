<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table border=1>
<% for(int col=1;col<=10;col++) {%>
			<tr>
			
			<%for(int fila=1;fila<=10;fila++) {%>
				
				<td><%=col*fila%></td>
			<%}%>
		
			</tr>
		<%}%>

</table>
</center>
</body>
</html>