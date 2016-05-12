<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
	<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<!-- modal produto -->
	<%@ include file="modal_produto.jsp" %>>

	<%@ include file="menu.jsp"%>

	<div class="container">
		<div class="">
			<div class="page-header">
				<h3>Item # ${produto.codigo}</h3>
			</div>
			
			<div class="row">
				<label class="col-sm-1"><span>Nome:</span></label>
				<label class="col-md-11">${produto.nome}</label>

			</div>
			
		    <div class="row col-md-12">
				<a class="btn btn-primary " href="servletController.do?command=EditarProduto&codigo=${produto.codigo}" >Editar</a>
				<button id="btn${produto.codigo}" type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal" data-produto="${produto.codigo}">Excluir</button>
				<a class="btn btn-default" href="listar_produto.jsp" >Voltar</a>
		    </div>
			
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#delete-modal").on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget); //botao que disparou a modal
			var recipient = button.data('produto');
			$("#id_excluir").val(recipient);
		});
	</script>
</body>
</html>