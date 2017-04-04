<%@include file="partials/cabecalho.jsp" %>
<body>
        <h2 id="titulo"> Nova Tarefa </h2>
	<form action="adicionaTarefa" method="post">
        <section id="desc">
            <div id="faixa"></div>
                Descricao:<br/>
                <textarea id="desc-pro" name="descricao" rows="5" cols="82"></textarea>
                <br />
                
        </section>
        <section id="desc2">
            <div id="faixa"></div>
                Pessoa Responsável:<br/>
                <select id="combo_respons" name="pessoa.idPessoa">
                        <c:forEach var="pessoa" items="${pessoas}">
                                <option value="${pessoa.idPessoa}">${pessoa.nomePessoa}</option>
                        </c:forEach>
                </select><br/>
                <br />
        
                Sprint:<br/>
                <select id="combo_sprints" name="sprint.idSprint">
                        <c:forEach var="sprint" items="${sprints}">
                                <option value="${sprint.idSprint}">${sprint.productBacklog}</option>
                        </c:forEach>
                </select><br/>
        </section>
		<input type="submit" value="Adicionar">
	</form>
</body>
<%@include file="partials/rodape.jsp" %>