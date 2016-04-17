<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
	<head>
		<title>Insert title here</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	
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
                        	<form action="ManterCliente.do" method="post" >
                                <input type="hidden" name="id" id="id_excluir" />
                                <button id="btn_excluir" type="submit" class="btn btn-primary" name="acao" value="excluir">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.modal -->
	
		<!-- Barra superior com os menus de navega��o -->
		<%@ include file="menu.jsp" %>
		
		<div class="container">
			<input name="id" type="hidden" value="${cliente.id}" />
			
			<div class="jumbotron">
				
				<div class="row">
					<div>
						<h2>Cliente #${cliente.id}</h2>
					</div>
					
					<div class="col-md-12" >
						<div>
							<label> <strong>Nome</strong> </label> 
							<label>${cliente.nome}</label>
						</div>
					</div>
					
					<div class="col-md-12" >
						<div>
							<label> <strong>Fone</strong> </label> 
							<label>${cliente.fone}</label>
						</div>
					</div>
					
				</div>
				
				<div class="row">
					<a class="btn btn-primary" href="ManterCliente.do?acao=editar&id=${cliente.id}" >Editar</a>
					<button id="btn${cliente.id}" type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal" data-cliente="${cliente.id}">Excluir</button>
					<a class="btn btn-default" href="listar_cliente.jsp" >Voltar</a>
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