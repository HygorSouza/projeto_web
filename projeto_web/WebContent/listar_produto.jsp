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
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                           </button>
                           <h4 class="modal-title" id="modalLabel">Excluir Produto</h4>
                    </div>
                    <div class="modal-body">
                        Deseja realmente excluir este Item?
                    </div>
                    	<form action="ManterProduto.do" method="post">
                   			<div class="modal-footer">
	                        	<input type="hidden" name="codigo" id="codigo_excluir" />
	                            <button id="btn_excluir" type="submit" name="acao" value="excluir" class="btn btn-primary" >Sim</button>
	                            <button  type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
	                        </div>
                        </form>
                  </div>
              </div>
         </div>
         <!-- /.modal -->

	<!-- menu navegação -->
	<%@ include file="menu.jsp" %>

	<div class="container">


		<div class="row">
			<div class="col-md-3">
				<h2>Produto</h2>
			</div>

			<form name="form" action="servletController.do" method="post">
				<div class="col-md-6">
					<div class="input-group h2">
						<input type="text" name="key" class="form-control" placeholder="Digite o nome do produto" /> 
						<span class="input-group-btn">
							<button id="btn" class="btn btn-primary"  type="submit" name="command" value="ListarProduto">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</form>

			<div class="col-md-3">
				<a href="cadastro_produto.jsp" class="btn btn-primary pull-right h2">Novo produto</a>
			</div>
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
								<a class="btn btn-default btn-xs" href="ManterProduto.do?acao=consultar&codigo=${produto.codigo}">Visualizar</a>
								<a class="btn btn-primary btn-xs" href="ManterProduto.do?acao=editar&codigo=${produto.codigo}">Editar</a>
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
    	<script type="text/javascript">
             $("#delete-modal").on('show.bs.modal', function(event) {
                 var button = $(event.relatedTarget); //botao que disparou a modal
  	             var recipient = button.data('produto');
                $("#codigo_excluir").val(recipient);
             });
        </script>
</body>
</html>