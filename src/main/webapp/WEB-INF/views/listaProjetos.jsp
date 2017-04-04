<%@include file="partials/cabecalho.jsp" %>
<body>
        <header>
                <h3>Gscrum - Gerenciador de Projetos Scrum</h3>
        </header>
        <jsp:include page="partials/menu.jsp" />
        <div id="container">
                <jsp:include page="addprojeto.jsp" />
                <section id="lista-pro"> 
                <h2 id="titulo" > Projetos Cadastrados </h2>
                <table>
                        <tr>
                                <th> Nome </th>
                                <th> Descricao </th>
                                <th> Membros </th>
                                <th colspan="2"> Operacoes </th>
                        </tr>
                        <c:choose>
                                <c:when test="${fn:length(todosProjetos) gt 0}">
                                        <tr><td colspan="6">Nenhum projeto adicionado.</td></tr>
                                </c:when>
                                <c:otherwise>
                                        <c:forEach var="p" items="${todosProjetos}">
                                                <tr>
                                                        <td>${p.nomeProjeto}</td>
                                                        <td>${p.descricaoProjeto}</td>
                                                        <td>
                                                                <c:forEach var="m" items="${p.membrosAssociados}">
                                                                        ${m.pessoa.nomePessoa},
                                                                </c:forEach>
                                                        </td>
                                                        <td><a id="rem" href="removeProjeto?idProjeto=${p.idProjeto}"><img src="resources/remove.png"></a></td>
                                                        <td><a id="alt" href="mostraProjeto?idProjeto=${p.idProjeto}"><img src="resources/edit.png"></a></td>
                                                </tr>
                                        </c:forEach>
                                </c:otherwise>
                        </c:choose>
                </table>
                </section>
        </div>	
</body>
<%@include file="partials/rodape.jsp" %>