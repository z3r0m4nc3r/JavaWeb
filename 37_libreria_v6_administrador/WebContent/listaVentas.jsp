<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 2px solid black;
  border-collapse: collapse;
  padding: 15px;
  text-align: center;
}
th, tr {
  text-align: center;
}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<meta charset="ISO-8859-1">

<title>Lista de Ventas</title>
</head>
<body>
<div class="container-fluid" align="center">
<h2>Lista de Libros Vendidos:</h2>
<table style="width:100%">
<tr>
<th>Titulo</th>
<th>Cliente</th>
<th>Fecha</th>
</tr>
<c:forEach var="venta" items="${requestScope.listaVentas}">
<tr>
<td>${venta.libro.titulo}</td>
<td>${venta.comprador.usuario}</td>
<td>${venta.fecha}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>