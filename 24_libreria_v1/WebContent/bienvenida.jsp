<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
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
<title>Bienvenido</title>
</head>
<body>
<div class="container" align="center">
<%Cliente clienteAutenticado = (Cliente)request.getAttribute("clienteAutenticado"); %>
<h1>Bienvenido <%=clienteAutenticado.getUsuario() %></h1>
</div>
</body>
</html>