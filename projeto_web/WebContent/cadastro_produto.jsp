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
		
		<!-- Bootstrap -->
	    <link href="css/bootstrap.min.css" rel="stylesheet"/>
	   	<link href="css/style.css" rel="stylesheet"/>
	</head>
	<body>
		<!--  menu de navegacao  -->
		<%@ include file="navbar-default.jsp" %>
	    
		<div  class="container">
			
			<form action="ManterProduto.do" method="post">
				<div class="row">
					<div class="form-group col-md-12">
						<div class="input-group" >
							<span class="input-group-addon" >Nome</span>
							<input type="text"  name="nome"  required class="form-control" /> 
						</div>
					</div>
					
					<div class="form-group col-md-6">
						<div class="input-group" >
							<span class="input-group-addon" >Preço</span>
							<input type="text" name="preco" required class="form-control" />
						</div>
					</div>
					
					<div class="form-group col-md-6">
						<div class="input-group" >
							<span class="input-group-addon" >Quantidade</span>
							<input type="text" name="quantidade" required class="form-control" />
						</div>
					</div>
					
					<div class="form-group col-md-12">
						<div class="input-group">
							<span class="input-group-addon">Descricao</span> 
							<textarea name="descricao" class="form-control"  ></textarea>
						</div>
					</div>
				</div>
				<input type="submit" name="acao" value="salvar" class="btn btn-primary" />
				<a href="#" class="btn btn-default" >Cancelar</a>
				
			</form>
		</div>
		
		<!-- library JQuery -->
		<script src="js/jquery.min.js"></script>
	    <script src="js/bootstrap.min.js"></script>
	</body>
</html>