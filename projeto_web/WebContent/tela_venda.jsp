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
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	<input type="hidden" id="produto_max_qtd" value="-1"/>
	
	<div class="container">
		<div class="row">
		
			<form action="CarrinhoDeCompra.do" method="post">
			
				<div class="form-group col-md-3">

						<div class="input-group ">
							<span class="input-group-addon">Codigo</span>
							<input type="number" required  name="codigo" class="form-control" />
						</div>
				</div>
				
				<div class="form-group col-md-3">		
						<div class="input-group ">
							<span class="input-group-addon">Quantidade</span>
							<input type="number" required  name="quantidade" min="1" class="form-control" />
						</div>
						
						<div class="input-group">
							<button type="submit" name="acao" value="adicionar" >
								<span class="glyphicon glyphicon-plus-sign">add</span>
							</button>
						</div>
						<c:if test="${not empty carrinhoDeCompra}">
							<a type="submit" href="CarrinhoDeCompra.do?acao=cancelar" >
								<span class="glyphicon glyphicon-plus-sign">cancelar</span>
							</a>
						</c:if>
				</div>
			</form>
		</div>
			<c:if test="${not empty carrinhoDeCompra}">
				<table class="table table-responsive table-hover">
					<thead>
						<tr>
						<th>Codigo</th>
						<th>Nome</th>
						<th>Quantidade</th>
						<th>Preço(Unidade)</th>
						<th>Acões</th>
						</tr>
					</thead>
					<c:forEach var="item" items="${carrinhoDeCompra.itens}">
						<tbody>
							<tr>
								<td>${item.produto.codigo}</td>
								<td>${item.produto.nome}</td>
								<td>${item.quantidade}</td>
								<td>${item.produto.preco}</td>
								<td>
									<a href="CarrinhoDeCompra.do?acao=remover&codigo=${item.produto.codigo}" >
										<span class="glyphicon glyphicon-remove btn">Remover item</span>
									</a>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</c:if>
			
			<c:if test="${ not empty produto }">
				<input type="hidden" id="max_qtd" value="${produto.quantidade}"/>
			  	
			  	<script>
					var max_qtd =  document.getElementById("max_qtd").value;
					
					document.getElementById("produto_max_qtd").value = max_qtd;
   				
				</script>
			</c:if>
		
	</div>
	
	<!--  library jQuery  -->
	<script src="js/jquery.min.js"></script>
   	<script src="js/bootstrap.min.js"></script>
   	<script>
   
   		var max = parseInt( document.getElementById("produto_max_qtd").value );
   		
		if(  max != -1 ){
			var msg = "Quantidade em estoque insulficiente !\nQuantidade em estoque: "+max;
			alert(msg);
		}
		
   	</script>
</body>
</html>