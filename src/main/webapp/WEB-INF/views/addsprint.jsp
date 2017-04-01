<%@include file="partials/cabecalho.jsp" %>
<body>
    <div id="container">
	<form action="adicionaSprint" method="post">
		
		Data de Inicio:<br/>
		<input type="text" name="dtini"> 
		<br/>
		Data de Fim:<br/>
                <input type="text" name="dtfim"> 
		<br/>
		Product Backlog:<br/>
		<input type="text" name="pbacklog">
                <br/>
		Estado Sprint:<br/>
                <input type="radio" name="estsprint" value="1">Iniciado
                <input type="radio" name="estsprint" value="2">Executando
                <input type="radio" name="estsprint" value="3">Finalizado
                
	</form>
    </div>

<%@include file="partials/rodape.jsp" %>
