<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    <div class="modal-footer">
                        <input type="hidden" name="id" id="id_excluir" />
                            <button id="btn_excluir" type="button" class="btn btn-primary" data-dismiss="modal" >Sim</button>
                            <button  type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                        </div>
                  </div>
              </div>
         </div>
         <!-- /.modal -->

	<!-- menu navega��o -->
	<%@ include file="menu.jsp" %>

	<div class="container">


		<div class="row">
			<div class="col-md-3">
				<h2>Produto</h2>
			</div>

			<form name="form" action="ListaDeProduto.do" method="post">
				<div class="col-md-6">
					<div class="input-group h2">
						<input type="text" name="key" class="form-control" required placeholder="Digite o nome ou codigo do produto" /> 
						<span class="input-group-btn">
							<button id="btn" class="btn btn-primary" type="submit">
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

		<c:if test="${not empty lista }">

			<hr />
			<table id="table" class="table table-responsive table-hover">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Nome</th>
						<th>Pre�o</th>
						<th>Quantidade</th>
						<th>Acoes</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="produto" items="${lista}">
						<tr id="${produto.codigo}" class="" >
							<td>${produto.codigo}</td>
							<td>${produto.nome}</td>
							<td>${produto.preco}</td>
							<td>${produto.quantidadeEmEstoque}</td>
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
                $("#id_excluir").val(recipient);
             });
                
             $("#btn_excluir").on('click' , function(){
               	$.post("ExcluirProduto.do?codigo="+( $("#id_excluir").val() ),function(response){
           		$("#table").find("#"+( $("#id_excluir").val() ) ).remove();
               	});
             });
        </script>
</body>
</html>