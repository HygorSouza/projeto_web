<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
			<form action="ManterCliente.do" method="post">
				<input name="id" type="hidden" value="${cliente.id}"/>
				
					<div class="row">
						<div class="input-group">
							<span class="input-group-addon">Nome:</span>
							<input class="form-control" name="nome" required type="text" value="${cliente.nome}"/>
						</div>
					</div>
					<div class="row">
						<span>Fone:</span>
						<input name="fone" type="tel" value="${cliente.fone}"/>
					</div>
					<div class="row">
						<input type="submit" name="acao" value="atualizar"/>
					</div>
				
			</form>
		</div>
		
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>