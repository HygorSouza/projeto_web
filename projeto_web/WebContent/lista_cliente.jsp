<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html >
<html>
	<head>
		<title>Insert title here</title>
		<meta charset="ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    
	    <!-- Bootstrap -->
	    <link href="css/bootstrap.min.css" rel="stylesheet"/>
		<link href="css/style.css" rel="stylesheet"/>
	</head>
	<body>
		<jsp:useBean id="lista" class="remap.to.ListaDeClienteTO" scope="request" />
	
		<div class="container">
			<table class="table table-responsive table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Fone</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cliente" items="${lista.lista}" >
						<tr>
							<td>${cliente.id}</td>
							<td>${cliente.nome}</td>
							<td>${cliente.fone}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
			
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>