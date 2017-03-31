<%@include file="partials/cabecalho.jsp" %>
<body>
<h2 id="titulo" > Nova Tarefa </h2>
	<form action="adicionaTarefa" method="post">
		Descricao: <br />
		<textarea name="descricao" rows="5" cols="140"></textarea><br />

		<!-- <input type="checkbox" name="finaliza" value="finalizado" disabled> Finalizado <br/> -->
		<input type="submit" value="Adicionar">
	</form>
</body>
<%@include file="partials/rodape.jsp" %>