<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
	<title>Cadastro de Clientes</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<!-- Barra superior com os menus de navegação -->
	<%@ include file="menu.jsp" %>

	<div class="container">
		<div class="">
			<h3 class="page-header">Cadastro de clientes</h3>
			<form  action="servletController.do" method="post">
				<div class="row">
					
						<div class="form-group col-md-12">
							<div class="input-group">
								<span class="input-group-addon">Nome</span> 
								<input type="text" name="nome" required class="form-control" />
							</div>
						</div>
					
						<div class="form-group col-md-6">
							<div class="input-group">
								<span class="input-group-addon">Fone</span> 
								<input type="text" name="fone" class="form-control" />
							</div>
						</div>
						
						<div class="form-group col-md-12">
							<input class="btn btn-primary" type="submit" name="command" value="SalvarCliente" /> 
							<a class="btn btn-default" href="listar_cliente.jsp">Cancelar</a>
						</div>
		
				</div>
			</form>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="jquery/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>