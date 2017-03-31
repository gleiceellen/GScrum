<%@include file="partials/cabecalho.jsp" %>
<body>
	<script type="text/javascript">
			
			function addTarefaNoSprint(idTarefa){
				
			}
			
	</script>
	<jsp:useBean id="dao" class="br.com.gleice.tarefas.dao.TarefaDao"></jsp:useBean>
	<jsp:useBean id="cont" class="br.com.gleice.tarefas.controller.TarefaController"></jsp:useBean>
	<jsp:useBean id="daos" class="br.com.gleice.tarefas.dao.ProjetoDao"></jsp:useBean>
	<form action="adicionaSprint" method="post">
		
		Data de Inicio:<br/>
		<input type="text" id="datepicker" name="dtInicioSprint" 
				value="<fmt:formatDate value="${sprint.dtInicioSprint.time}" pattern="dd/MM/yyyy"/>"/>
		<br/>
		
		Data de Fim:<br/>
		<input type="text" id="datepicker" name="dtFimSprint" 
				value="<fmt:formatDate value="${sprint.dtFimSprint.time}" pattern="dd/MM/yyyy"/>"/>
		<br/>
		
		Product Backlog:<br/>
		<input type="text" name="pbacklog"><br/>
		Estado Sprint:<br/>
		<select name="estadoSprint">
			<option value="criado">Iniciado</option>
			<option value="executando">Executando</option>
			<option value="finalizado">Finalizado</option>
		</select>
		<input type="submit" value="Adicionar">
		<br/><br/>
		Tarefas:
		<a href="verTarefasDisponiveis">Ver Tarefas Disponiveis!</a>
		<select name="choice" width="20">
				<c:forEach var="pro" items="${daos.lista}">
					<option onClick="">
		    			<c:out value="${pro.nomeProjeto}"></c:out>
					</option>
			    </c:forEach>
	    	</select>
	</form>
</body>
<%@include file="partials/rodape.jsp" %>