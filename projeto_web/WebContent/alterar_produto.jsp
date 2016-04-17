<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
	<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<!-- menu de navegacao -->
	<c:import url="navbar-default.jsp"/>
	
	<div class="container">
		<div class="jumbotron">
			<form action="ManterProduto.do" method="post">
				<input type="hidden" name="codigo" value="${produto.codigo}" >
				
				<div class="row">
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon" >Nome</span>
							<input type="text" name="nome" value="${produto.nome}" class="form-control" />
						</div>>
					</div>
				</div>
			</form> 
		</div>
	</div>
	<!-- library JQuery -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>