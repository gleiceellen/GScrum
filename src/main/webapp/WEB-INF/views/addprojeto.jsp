<%@include file="partials/cabecalho.jsp" %>
<script type="text/javascript" src="resources/js/app/adiciona-membro.js"></script>
<body>
        <h2 id="titulo" > Novo Projeto </h2>
        <form action="adicionaProjeto" method="post">
                <input type="hidden" name="idProjeto" value="${projeto.idProjeto}"/>
                <section id="add">
                        <div id="faixa"></div>
                        Nome:
                        <input id="nome-pro" type="text" name="nomeProjeto" value="${projeto.nomeProjeto}"> 
                        <br>

                        Descricao:
                        <textarea id="desc-pro" name="descricaoProjeto" rows="5" cols="76">${projeto.descricaoProjeto}</textarea>
                        <br />

                        Membros: 
                        <select id="combo_membros" name="choice" width="30">
                                <c:forEach var="pessoa" items="${pessoas}">
                                        <option value="${pessoa.idPessoa}" qualificacao="${pessoa.qualificacaoPessoa}" email="${pessoa.emailPessoa}">${pessoa.nomePessoa}</option>
                                </c:forEach>
                        </select>
                        <a href="#" id ="lk_simples" onclick="adicionarMembroTabela()">Incluir Novo Membro</a>
                        <br />
                </section>
                <section id="lista">
                        <div id="faixa"></div>
                        <table id="tabela_membros">
                                <thead>
                                        <tr>
                                                <th>Id</th>
                                                <th>Nome</th>
                                                <th>Email</th>
                                                <th>Qualificacao</th>
                                        </tr>
                                </thead>
                                <tbody>
                                        <c:choose>
                                                <c:when test="${fn:length(projeto.membrosAssociados) eq 0}">
                                                        <tr><td colspan="8">Nenhuma tarefa adicionada.</td></tr>
                                                </c:when>
                                                <c:otherwise>
                                                        <%-- Vai ser adicionar pelo Javascript 'adicionarMembroTabela' --%>
                                                        <c:forEach items="${projeto.membrosAssociados}" var="membro" varStatus="status">
                                                                <tr class='tr_criada_js'>
                                                                        <td>${membro.pessoa.idPessoa}
                                                                                <input type='hidden' name='membrosAssociados[${status.count-1}].pessoa.idPessoa' value='${membro.pessoa.idPessoa}' />
                                                                        </td>
                                                                        <td> ${membro.pessoa.nomePessoa} </td>
                                                                        <td> ${membro.pessoa.emailPessoa} </td>
                                                                        <td> ${membro.pessoa.qualificacaoPessoa} </td>
                                                                </tr>
                                                        </c:forEach>
                                                </c:otherwise>
                                        </c:choose>
                                </tbody>
                        </table>

                        <input type="submit" id="addpro" value="Adicionar">
                </section>
        </form>

</body>
<%@include file="partials/rodape.jsp" %>