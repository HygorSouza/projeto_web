<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
	<head>
		<title>Insert title here</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	    <link href="css/bootstrap.min.css" rel="stylesheet"/>
	   	<link href="css/style.css" rel="stylesheet"/>
	</head>
	<body>
		<c:import url="navbar-default.html" />
		<jsp:useBean id="cliente" class="remap.to.ClienteTO" scope="request"/>
		<div class="container">
			<input name="id" type="hidden" value="${cliente.id}" />
			<div class="row">
				<label><strong>Nome:</strong></label> 
				<label>${cliente.nome}</label>
			</div>
			<div class="row">
				<label><strong>Fone:</strong></label>
				<label>${cliente.fone}</label>
			</div>
			<div class="row">
				<a class="btn btn-default" href="ManterCliente.do?acao=editar&id=${cliente.id}" type="button" >Editar</a>
			</div>
			
		</div>
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>