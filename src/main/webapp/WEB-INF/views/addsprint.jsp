<%@include file="partials/cabecalho.jsp" %>
<body>
    <div id="container">
	<form action="adicionaSprint" method="post">
		
		Data de Inicio:
		<input type="text" name="dtini"> 
		
		Data de Fim:
                <input type="text" name="dtfim"> 
		
		Product Backlog:
		<input type="text" name="pbacklog">
                
		Estado Sprint:<br/>
                <input type="radio" name="estsprint" value="1">Iniciado
                <input type="radio" name="estsprint" value="2">Executando
                <input type="radio" name="estsprint" value="3">Finalizado
                <br/>
                
                <input type="submit" value="Adicionar">
                
	</form>
    </div>

<%@include file="partials/rodape.jsp" %>
