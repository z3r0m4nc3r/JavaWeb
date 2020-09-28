<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*"%>
<!DOCTYPE html>
<html>

<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<meta charset="ISO-8859-1">
<title>Carrito de la compra</title>
</head>
<body>
<%HttpSession sesion=request.getSession();%>
<%List<Producto> carrito = (List<Producto>)sesion.getAttribute("carro");%>
<%if(!carrito.isEmpty()){ %>

<div align="center">
<h1>Carrito de la compra</h1>
<table class="table table-striped table-bordered">

<%for (int fila=0;fila<carrito.size();fila++){ %>
<tr>
<td>
<%=carrito.get(fila).getNombre()%>
</td>
<td>
<%=carrito.get(fila).getPrecio()%>
</td>
<td>
<%=carrito.get(fila).getCategoria()%>
</td>
<td>

<a href="Eliminar?indice=<%=fila%>">Eliminar</a>
</td>
</tr>
<%} %>
</table>


</div>
<%}else{%>
<h2>El carrito esta vacio</h2>
<%} %>
</body>
</html>