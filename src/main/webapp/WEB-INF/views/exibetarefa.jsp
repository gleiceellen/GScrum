<%@include file="partials/cabecalho.jsp" %>
<body>
	<header>
		<h3>Gscrum - Gerenciador de Projetos Scrum</h3>
	</header>
	
	<div id="container">
			<h3> Alterar tarefa - ${tarefa.idTarefa}</h3>
		<form action="alteraTarefa" method="post">
			<input type="text" name="idTarefa" value="${tarefa.idTarefa}" />
			Descricao: <br/>
			<textarea name="descricao"cols="100" rows="5"> 
				${tarefa.descricao}
			</textarea>
			<br />
			
			Finalizado? <input type="checkbox" name="finalizado"
			value="true" ${tarefa.finalizado? 'checked' : ''} /> <br/>
			
			Data de finalizacao: <br/>
			<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />"/>
			<br/>
			<input type="submit"value="Alterar"/>
		</form>
	</div>
	
</body>
<%@include file="partials/rodape.jsp" %>