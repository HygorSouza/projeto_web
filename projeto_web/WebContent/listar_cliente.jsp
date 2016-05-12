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
		<%@ include file="modal_cliente.jsp" %>
		
		<!-- Barra superior com os menus de navegação -->
		<%@ include file="menu.jsp" %>
		
		<div class="container">
			
			<div class="row">
				<div class="col-md-3" >
					<h2>Cliente</h2>
				</div>
				
				<form action="servletController.do" method="post">
					<div class="col-md-6">
						<div class="input-group h2">
							<input type="text" name="key"  class="form-control" placeholder="Digite o nome do cliente" />
							<span class="input-group-btn">
			                <button id="btn" class="btn btn-primary" type="submit" name="command" value="ListarCliente" >
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
									<a class="btn btn-default btn-xs" href="servletController.do?command=VisualizarCliente&id=${cliente.id}" >Visualizar</a>
									<a class="btn btn-primary btn-xs" href="servletController.do?command=EditarCliente&id=${cliente.id}" >Editar</a>
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