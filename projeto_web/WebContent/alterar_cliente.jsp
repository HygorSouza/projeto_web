<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
		<!-- Barra superior com os menus de navegação -->
		<c:import url="navbar-default.jsp"/>
		
		
		<div class="container">
			<form action="ManterCliente.do" method="post">
				<input name="id" type="hidden" value="${cliente.id}"/>
				
					<div class="row">
						<div class="form-group col-md-12">
							<div class="input-group">
								<span class="input-group-addon">Nome:</span>
								<input class="form-control" name="nome" required type="text" value="${cliente.nome}"/>
							</div>
						</div>
						
						<div class="form-group col-md-6">
							<div class="input-group">
								<span class="input-group-addon">Fone:</span>
								<input class="form-control" name="fone" type="tel" value="${cliente.fone}"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<input class="btn btn-primary" type="submit" name="acao" value="atualizar"/>
							<a 	class="btn btn-default" href="pesquisar_cliente.jsp" >Cancelar</a>
						</div>
					</div>
				
			</form>
		</div>
		<!--  library jQuery  -->
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>