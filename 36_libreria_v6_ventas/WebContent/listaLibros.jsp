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
<title>Lista de Libros</title>

</head>
<body>

<div class="container-fluid" align="right">

<h4>Bienvenido ${sessionScope.clienteAutenticado.usuario}</h4><br/>

</div>
<div class="container-fluid" align="center">
<h2>Lista de Libros de Tema: ${requestScope.listaLibrosTema[0].tema.tema}</h2>
<table class="table-striped">
<tr><th>ISBN</th>
<th>Titulo</th>
<th>Autor</th>
<th>Precio</th>
<th>Paginas</th>
<th>Tema</th>
</tr>
<c:forEach var="libro" items="${requestScope.listaLibrosTema}">
<tr>
<td>${libro.isbn}</td>
<td>${libro.titulo}</td>
<td>${libro.autor}</td>
<td>${libro.precio}</td>
<td>${libro.paginas}</td>
<td>${libro.tema.tema}</td>
<td><a href="Controller?temas=${param.temas}&option=doAgregarCarrito&libro=${libro.isbn}">Comprar</a></td>
</tr>
</c:forEach>
</table>
<br/>
<br/><br/>
				<h1>Carrito </h1>
		<c:if test="${!empty sessionScope.carrito}">
			<table border="1">
			    <tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>		    	
			    	<c:forEach var="carro" items="${sessionScope.carrito}" varStatus="s">
			    		<tr>
			    			<td>${carro.titulo}</td>
							<td>${carro.autor}</td>
							<td>${carro.precio}</td>
							<td><a href="Controller?temas=${param.temas}&option=doEliminarCarrito&pos=${s.index}">Eliminar</a></td>
						</tr>		    	
			    	</c:forEach>
			</table>
			</c:if>
			
		<br/><br/>
<a href="Controller?option=doListaTemas">Volver</a>

</div>

</body>
</html>