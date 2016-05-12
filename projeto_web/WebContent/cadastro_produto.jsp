<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html >
<html>
	<head>
		<title>Insert title here</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- Bootstrap -->
	    <link href="css/bootstrap.min.css" rel="stylesheet"/>
	   	<link href="css/style.css" rel="stylesheet"/>
	</head>
	<body>
		<!--  menu de navegacao  -->
		<%@ include file="menu.jsp" %>
	    
		<div  class="container">
			
			<h3 class="page-header">Cadastro de produtos</h3>
			
			<form action="servletController.do" method="post">
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
				<button type="submit" name="command" value="SalvarProduto" class="btn btn-primary" >Salvar</button>
				<a href="listar_produto.jsp" class="btn btn-default" >Cancelar</a>
				
			</form>
		</div>
		
		<!-- library JQuery -->
		<script src="js/jquery.min.js"></script>
	    <script src="js/bootstrap.min.js"></script>
	</body>
</html>