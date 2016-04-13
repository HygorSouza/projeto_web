<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html>
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
		<!-- Barra superior com os menus de navegação -->
		<c:import url="navbar-default.jsp"/>
		
		<div class="container">
			<div class="row">
				<div class="col-md-3" >
					<h2>Clientes</h2>
				</div>
				
				<form action="lista_de_clientes.do" method="post">
					<div class="col-md-6">
						<div class="input-group h2">
							<input type="text" name="key"  class="form-control"  required placeholder="Digite o nome do cliente" />
							<span class="input-group-btn">
			                <button class="btn btn-primary" type="submit">
			                    <span class="glyphicon glyphicon-search"></span>
			                </button>
		            		</span>
						</div>
					</div>
				</form>
				
				<div class="col-md-3">
					<a href="cadastro_cliente.jsp" class="btn btn-primary pull-right h2" >Novo cliente</a>
				</div>	
			</div>
			
		</div>
		
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>