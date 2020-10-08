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
<title>Informacion de Paises</title>
</head>
<body>
<div class="container-fluid" align="center">
<h1>Informacion Paises</h1>
</div><br/>
<div class="container-fluid" align="left">
<h2>Seleccione País</h2>
<form action="Controller?option=doSelectPais" method="post">
<select id="pais" name="pais">
<c:forEach var="pais" items="${applicationScope.nombresPaises}">
	<option value="${pais}">${pais}</option>
</c:forEach>

</select>
<input type="submit" class="btn btn-default" value="Ver Datos" />

</form>
</div><br/>
<div class="container-fluid" align="center">
<c:if test="${!empty sessionScope.paisSeleccionado}">
<h4>Nombre: ${sessionScope.paisSeleccionado.nombre}</h4> 
<h4>Capital: ${sessionScope.paisSeleccionado.capital}</h4> 
<h4>Region: ${sessionScope.paisSeleccionado.region}</h4> 
<h4>Habitantes: ${sessionScope.paisSeleccionado.habitantes}</h4><br/>


<img height=100 width=200 alt="Bandera" src="${sessionScope.paisSeleccionado.bandera}">
</c:if>
</div>

</body>
</html>