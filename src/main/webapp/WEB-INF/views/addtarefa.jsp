<%@include file="partials/cabecalho.jsp" %>
<body>
        <h2 id="titulo"> Nova Tarefa </h2>
        <form action="adicionaTarefa" method="post">
                <input type="hidden" name="idTarefa" value="${tarefa.idTarefa}"/>
                <section id="desc">
                        <div id="faixa"></div>
                        Descricao:<br/>
                        <textarea id="desc-pro" name="descricao" rows="5" cols="82">${tarefa.descricao}</textarea>
                        <br />

                </section>
                <section id="desc2">
                        <div id="faixa"></div>
                        Pessoa Responsável:<br/>
                        <select id="combo_respons" name="pessoa.idPessoa">
                                <c:forEach var="pessoa" items="${pessoas}">
                                        <option value="${pessoa.idPessoa}" ${pessoa.idPessoa eq tarefa.pessoa.idPessoa ? "selected='selected'" : ''}>${pessoa.nomePessoa}</option>
                                </c:forEach>
                        </select><br/>
                        <br />

                        Sprint:<br/>
                        <select id="combo_sprints" name="sprint.idSprint">
                                <c:forEach var="sprint" items="${sprints}">
                                        <option value="${sprint.idSprint}" ${sprint.idSprint eq tarefa.sprint.idSprint ? "selected='selected'" : ''}>${sprint.productBacklog}</option>
                                </c:forEach>
                        </select><br/>
                </section>
                <input type="submit" value="Adicionar">
        </form>
</body>
<%@include file="partials/rodape.jsp" %>