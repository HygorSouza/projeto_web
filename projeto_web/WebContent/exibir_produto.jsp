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
	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Produto</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este produto?
				</div>
				<div class="modal-footer">
					<form action="ManterProduto.do" method="post">
						<input type="hidden" name="codigo" id="id_excluir" />
						<button id="btn_excluir" type="submit" class="btn btn-primary" name="acao" value="excluir">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->

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
				<a class="btn btn-primary " href="ManterProduto.do?acao=editar&codigo=${produto.codigo}" >Editar</a>
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