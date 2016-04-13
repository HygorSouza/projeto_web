<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Clientes</title>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="navbar-default.jsp"/>

	<div class="container">
		<div class="jumbotron">
			<h3 class="page-header">Cadastro de clientes</h3>
			<form name="form1" action="ManterCliente.do" method="post">
				<div class="row">
					<div class="input-group">
						<span class="input-group-addon">Nome</span> <input type="text"
							name="nome" required class="form-control" />
					</div>
				</div>
				<div class="row">
					<div class="input-group">
						<span class="input-group-addon">Fone</span> <input type="text"
							name="fone" class="form-control" />
					</div>
				</div>
				<div class="row">
					<input class="btn btn-primary" type="submit" name="acao"
						value="salvar" /> <a class="btn btn-default"
						href="pesquisar_cliente.html">Cancelar</a>
				</div>
			</form>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="jquery/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>