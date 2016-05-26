<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastros</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegaÃ§Ã£o -->
	<%@ include file="menu_index.jsp" %>
	
    <!-- Container Principal -->
    <div id="main" class="container">
       <h3 class="page-header">Cadastro Usuario</h3>
       <!-- Formulario de Login -->
        <form action="servletController.do" method="post" onsubmit="return valida();" >
				<div class="row col-md-12">
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></div> 
					   <input type="email" name="username" id="username" class="form-control" maxlength="60" placeholder="E-mail" required/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span></div> 
					   <input type="text" name="passwd" id="passwd" class="form-control" placeholder="Senha" required/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span></div> 
					   <input type="text"  id="passwd2" class="form-control" placeholder="Confirmar Senha" required/>
					</div>
				</div>
				</div>
				<div class="row col-md-12">
					<button type="submit" class="btn btn-primary" name="command" value="CadastroUsuario"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Ok</button>
					<a href="index.jsp" class="btn btn-default" >Cancelar</a>
				</div>
			</form>    
			</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
    	function valida(){
    		var senha = $("#passwd2").val();
    		var senha2 = $("#passwd").val();
    		var flag = false;
    			
    			if( senha === senha2 )
    				flag = true;	
    			else{
    				window.alert("Verifique as senhas !");
    			}
    			
    		return flag;
    	}
    </script>
</body>
</html>