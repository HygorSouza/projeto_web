<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
		<!--  menu de navegacao  -->
		<c:import url="navbar-default.jsp" />
	    
		<div id="main" class="container">
			
			<form action="ManterProduto.do" method="post">
				
				<label>Nome:</label>
				<input type="text"  name="nome" /> <br/>
				
				<label>Preço:</label>
				<input type="text" name="preco" /> <br/>
				
				<label>Descricao:</label> <br/>
				<textarea name="descricao"  ></textarea> <br/>
				
				<input type="submit" name="acao" value="salvar" class="btn btn-primary" />
			</form>
		</div>
		<script src="js/jquery.min.js"></script>
	    <script src="js/bootstrap.min.js"></script>
	</body>
</html>