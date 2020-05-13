<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String idBus = request.getParameter("idBus");
	String nombrePr = request.getParameter("nombrePr");
	String precioPr = request.getParameter("precioPr");
	String cantidadPr = request.getParameter("cantidadPr");
	String totalPr = request.getParameter("totalPr");

	if (idBus==null) {
		idBus = "";
		nombrePr = "";
		cantidadPr = "";
		precioPr = "";
		totalPr = "";
	}
	
%>
<body>
	<form action="ServletController">
		<table align="center">
			<thead>
			</thead>
			<tbody>
				<tr>
					<td>
						<p>Id</p>
						<input type="text" name="Id" id="idcarga" value="<%=idBus%>">
						<p>Nombre de Producto</p>
						<input type="text" name="Nproductos" id="nombrePr"
						value="<%=nombrePr%>">
						<p>Precio de Producto</p>
						<input type="text" name="Pproductos" id="precioPr"
						value="<%=precioPr%>">
						<p>Cantidad de Producto</p>
						<input type="text" name="Cproductos" id="cantidadPr"
						value="<%=cantidadPr%>">
						<p>Total de Producto</p>
						<input type="text" name="Tproductos" id="totalPr"
						value="<%=totalPr%>"> <br> <br>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" class="btn btn-info" value="Guardar" name="btn">
		<input type="submit" class="btn btn-info" value="Actualizar"
			name="btn">

	</form>
	
		<script type="text/javascript">
		
	 var caja2 = document.getElementById('cantidadPr');

	 caja2.addEventListener('keyup', function(){

	 	var valordato1 = document.getElementById('precioPr').value;
	 	var valordato2 = document.getElementById('cantidadPr').value;
	 	var operacion =  Number (valordato1) * Number(valordato2);

	 	document.getElementById('totalPr').value = operacion;

	 	

	 	console.log(operacion);

	 });
	 </script>
</body>
</html>