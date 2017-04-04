<%@include file="partials/cabecalho.jsp" %>
<body>
        <h2 id="titulo"> Nova Tarefa </h2>
	<form action="adicionaTarefa" method="post">
                Descricao:
                <textarea id="desc-pro" name="descricao" rows="5" cols="100"></textarea>
                <br />
                
                Pessoa Responsavel:
                <select name="pessoa.idPessoa">
                        <c:forEach var="pessoa" items="${pessoas}">
                                <option value="${pessoa.idPessoa}">${pessoa.nomePessoa}</option>
                        </c:forEach>
                </select>
                <br />
                
                Sprint:
                <select name="sprint.idSprint">
                        <c:forEach var="sprint" items="${sprints}">
                                <option value="${sprint.idSprint}">${sprint.productBacklog}</option>
                        </c:forEach>
                </select>
                
		<input type="submit" value="Adicionar">
	</form>
</body>
<%@include file="partials/rodape.jsp" %>