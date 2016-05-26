
   <!-- nav Barra superior com os menus de navega��o -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="home.jsp">projeto_web</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="servletController.do?command=ListarClienteReiniciar">Cliente</a>
                    </li>
                    <li><a href="servletController.do?command=ListarProdutoReiniciar">Produto</a>
                    </li>
	                <c:if test="${ not empty clienteVenda}">
	                    <li>
	                    	<a href="tela_venda.jsp">Venda</a>
	                    </li>
                    </c:if>
                    <li>
                    	<a>Pesquisar Venda </a>
                    </li>
                    <li><a href="servletController.do?command=FazerLogout">sair</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- fim nav Barra superior com os menus de navega��o -->
    