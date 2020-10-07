<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
<fmt:setBundle basename="resources.descripciones"/>
<title><fmt:message key="autentificacion.principal"/></title>
</head>
<body>

<div class="container-fluid" align="center">

	<form action="Controller?option=doAutenticar" method="post">

		<fmt:message key="autentificacion.usuario"/>:<input type="text" class="form-check-input" style="width:20%" required name="user" /><br />
		<fmt:message key="autentificacion.pwd"/><input type="password" class="form-check-input" style="width:20%" required name="pwd"><br /> 
		<input type="submit" class="btn btn-default" value=<fmt:message key="autentificacion.entrar"/> />
	</form>
	<br/>
	<form action="Controller?option=toAltaNuevo" method="post">
	<input type="submit" class="btn btn-default" value=<fmt:message key="autentificacion.registro"/> />
	</form>
	<form action="Controller?option=toAdministrador" method="post">
	<input type="submit" class="btn btn-default" value="Administrador"/>
	</form>
</div>

</body>
</html>