<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

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
		<!-- Modal -->
        <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
             <div class="modal-dialog" role="document">
                 <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                           </button>
                           <h4 class="modal-title" id="modalLabel">Excluir Cliente</h4>
                    </div>
                    <div class="modal-body">
                        Deseja realmente excluir este cliente?
                    </div>
                    <div class="modal-footer">
                    	<form action="ManterCliente.do" method="post">
                        	<input type="hidden" name="id" id="id_excluir" />
                            <button name="acao" id="btn_excluir" type="submit" class="btn btn-primary" value="excluir" >Sim</button>
                            <button  type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                    	</form>
                    </div>
                  </div>
              </div>
         </div>
         <!-- /.modal -->
		
		<!-- Barra superior com os menus de navegação -->
		<%@ include file="menu.jsp" %>
		
		<div class="container">
			
			<div class="row">
				<div class="col-md-3" >
					<h2>Cliente</h2>
				</div>
				
				<form action="ListaDeCliente.do" method="post">
					<div class="col-md-6">
						<div class="input-group h2">
							<input type="text" name="key"  class="form-control" placeholder="Digite o nome do cliente" />
							<span class="input-group-btn">
			                <button id="btn" class="btn btn-primary" type="submit" name="acao" value="buscar" >
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
			
			<c:if test="${not empty listaCliente }" >
			
				<hr/>		
				<table id="table" class="table table-responsive table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Fone</th>
							<th>Acoes</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cliente" items="${listaCliente}" >
							<tr >
								<td>${cliente.id}</td>
								<td>${cliente.nome}</td>
								<c:if test="${not empty cliente.fone}">
									<td>${cliente.fone}</td>
								</c:if>
								<c:if test="${empty cliente.fone}">
									<td >Não informado</td>
								</c:if>
								
								<td class="actions">
									<a class="btn btn-default btn-xs" href="ManterCliente.do?acao=consultar&id=${cliente.id}" >Visualizar</a>
									<a class="btn btn-primary btn-xs" href="ManterCliente.do?acao=editar&id=${cliente.id}" >Editar</a>
									<button id="btn${cliente.id}" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${cliente.id}">Excluir</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
					
			</c:if>
		</div>
		
		<!--  Library jQuery -->
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
    	<script type="text/javascript">
             $("#delete-modal").on('show.bs.modal', function(event) {
                 var button = $(event.relatedTarget); //botao que disparou a modal
  	             var recipient = button.data('cliente');
                $("#id_excluir").val(recipient);
             });
        </script>
	</body>
</html>