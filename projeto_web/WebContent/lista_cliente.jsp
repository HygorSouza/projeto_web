<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List , remap.to.ClienteTO" %>
<!DOCTYPE html >
<html>
<head>
	<title>Insert title here</title>
	<meta charset="ISO-8859-1"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>  
					<th>Id</th>
					<th>Nome</th>
					<th>Fone</th>
				</tr>
			</thead>
			<tbody>
				<% List<ClienteTO> lista = ( List<ClienteTO> )request.getAttribute("lista"); 
					for( ClienteTO to:lista){
				%>
					<tr>
						<td><%= to.getId() %></td>
						<td><%= to.getNome() %></td>
						<td><%= to.getFone() %></td>
					</tr>
				<%  } %>
			</tbody>
		</table>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery/jquery-1.11.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>