<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>Seleccionar Libros por tema</title>

</head>
<body>
<div class="container-fluid" align="right">

<h4>Bienvenido ${sessionScope.clienteAutenticado.usuario}</h4><br/>

</div>
<div class="container-fluid" align="center">


<h4>Temas</h4><br/>
<form action="Controller?option=doListaLibrosTema" method="post">
<select id="temas" name="temas">
<option value="todos">-Todos-</option>

<c:forEach var="tema" items="${requestScope.listaTemas}">
	<option value="${tema.idTema}">${tema.tema}</option>
</c:forEach>

</select>

<input type="submit" class="btn btn-default" value="Ver Libros" />
</form>
<a href="Controller?option=toSalir">Volver</a>
</div>
</body>
</html>