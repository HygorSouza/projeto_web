<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Codigo: ${produto.codigo} <br/>
	Nome: ${produto.nome} <br/>
	Pre�o: ${produto.preco} <br/>
	Descri��o:<br/>
	<textarea disabled> ${produto.descricao} </textarea>
	<br/>
</body>
</html>