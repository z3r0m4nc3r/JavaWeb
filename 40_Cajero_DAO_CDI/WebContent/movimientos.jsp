<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<title>Listado de Movimientos de la cuenta ${sessionScope.cuentaSesion.numeroCuenta}</title>
</head>
<body>
<div class="container-fluid" align="center">
<h3>Listado de Movimientos de la cuenta ${sessionScope.cuentaSesion.numeroCuenta}</h3><br/>
<table class="table-striped" border="1">
<tr><th>Cantidad</th>
<th>Tipo de movimiento</th>
<th>Fecha</th>
</tr>
<c:forEach var="movimiento" items="${requestScope.listaMovimientos}">
<tr>
<td>${movimiento.cantidad}</td>
<td>${movimiento.operacion}</td>
<td><fmt:formatDate value="${movimiento.fecha}" pattern="dd/MM/yyyy HH:mm"/></td>
</tr>
</c:forEach>
</table>
<h4>Saldo Actual: ${requestScope.saldo} &#8364;</h4>
<a href="Controller?option=toMenu">Volver</a>

</div>
</body>
</html>