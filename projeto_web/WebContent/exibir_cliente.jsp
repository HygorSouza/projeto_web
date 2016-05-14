<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
	<head>
		<title>Insert title here</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	    <link href="css/bootstrap.min.css" rel="stylesheet"/>
	   	<link href="css/style.css" rel="stylesheet"/>
	</head>
	<body>
		<%@ include file="modal_cliente.jsp" %>
	
		<!-- Barra superior com os menus de navegação -->
		<%@ include file="menu.jsp" %>
		
		<div class="container">
			<input name="id" type="hidden" value="${cliente.id}" />
			
			<div class="">
				
				<div class="row">
					<div class="page-header" >
						<h3> Cliente #${cliente.id} </h3>
					</div>
					
					<div class="col-md-12" >
						<div>
							<label class="col-sm-1"> <strong>Nome</strong> </label> 
							<label >${cliente.nome}</label>
						</div>
					</div>
					
					<div class="col-md-12" >
						<div class="">
							<label class="col-sm-1"> <strong>Fone</strong> </label>
							<c:if test="${not empty cliente.fone}"> 
								<label>${cliente.fone}</label>
							</c:if>
							<c:if test="${empty cliente.fone}">
								<label>não informado </label>
							</c:if>
						</div>
					</div>
					
				</div>
				
				<div class="row col-md-12">
					<a class="btn btn-primary btn-xs" href="servletController.do?command=EditarCliente&id=${cliente.id}" >Editar</a>
					<button class="btn btn-danger btn-xs" id="btn${cliente.id}" type="button" data-toggle="modal" data-target="#delete-modal" data-cliente="${cliente.id}">Excluir</button>
					<a class="btn btn-default btn-xs" href="listar_cliente.jsp" >Voltar</a>
				</div>
				
			</div>
		</div>
		
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