<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
	<title>Pesquisar Venda</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet" />
</head>
<body>

	<!-- menu navegação -->
	<%@ include file="menu.jsp" %>

	<div class="container">


		<div class="row">
			<div class="col-md-3">
				<h2>Produto</h2>
			</div>

			<form name="form" action="servletController.do" onsubmit="false;" method="post">
				<div class="col-md-6">
					<div class="input-group h2">
						<input type="number" name="id"  class="form-control" placeholder="Digite o id cliente" /> 
						<span class="input-group-btn">
							<button id="btn" class="btn btn-primary"  type="submit" name="command" value="" >
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</form>
		</div>

		<c:if test="${not empty listaProduto }">

			<hr />
			<table id="table" class="table table-responsive table-hover">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Nome</th>
						<th>Preço</th>
						<th>Quantidade</th>
						<th>Acoes</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="produto" items="${listaProduto}">
						<tr id="${produto.codigo}" class="" >
							<td>${produto.codigo}</td>
							<td>${produto.nome}</td>
							<td>${produto.preco}</td>
							<td>${produto.quantidade}</td>
							<td class="actions">
								<a class="btn btn-default btn-xs" href="servletController.do?command=VisualizarProduto&codigo=${produto.codigo}">Visualizar</a>
								<a class="btn btn-primary btn-xs" href="servletController.do?command=EditarProduto&codigo=${produto.codigo}">Editar</a>
								<button id="btn${produto.codigo}" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-produto="${produto.codigo}">Excluir</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</c:if>

	</div>

	<!-- library JQuery -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>