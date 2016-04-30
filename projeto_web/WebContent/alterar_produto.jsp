<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
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
	<%@ include file="menu.jsp" %>
		
	<div class="container">
		<div class="">
		
			<h3>Item # ${produto.codigo}</h3>
		
			<form action="ManterProduto.do" method="post">
				<input type="hidden" name="codigo"  value="${produto.codigo}" />
				<input type="hidden" name="quantidade" value="${produto.quantidade}"/>
				
				<div class="row">
					<div class="form-group col-md-12">
						<div class="input-group">
							<span class="input-group-addon" >Nome</span>
							<input type="text" name="nome" value="${produto.nome}" class="form-control" />
						</div>
					</div>
					
					<div class="form-group col-md-6">
						<div class="input-group">
							<span class="input-group-addon" >Preço</span>
							<input type="number" step="0.01" name="preco" value="${produto.preco}" class="form-control" />
						</div>
					</div>
					
					<div class="form-group col-md-12" >
						<div  class="input-group">
							<span class="input-group-addon">Descrição</span>
							<c:if test="${not empty produto.descricao}">
								<textarea name="descricao"  class="form-control" >${produto.descricao}</textarea>
							</c:if>
							<c:if test="${empty produto.descricao}">
								<textarea name="descricao"  class="form-control" placeholder="Descricão do produto não informada" ></textarea>
							</c:if>
						</div>
					</div>
					
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<input class="btn btn-primary" type="submit" name="acao" value="atualizar"/>
						<a 	class="btn btn-default" href="listar_produto.jsp" >Cancelar</a>
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