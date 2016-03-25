<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Cadastro de produtos</h3>
	<hr/>
	<form action="ManterProduto.do" method="post">
	
		<tag:campo name="codigo" value="Codigo:"/> <br/>
		<tag:campo name="nome" value="Nome:" /> <br/>
		<tag:campo name="preco" value="Preço:" /> <br/>
		<tag:campo name="descricao"  value="Descricao:"/> <br/>
		
		<input type="submit" name="acao" value="salvar" />
		<input type="submit" name="acao" value="consultar" />
	</form>
</body>
</html>