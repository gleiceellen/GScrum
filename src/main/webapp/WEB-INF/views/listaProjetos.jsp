<%@include file="partials/cabecalho.jsp" %>
<body>
        <header>
                <h3>Gscrum - Gerenciador de Projetos Scrum</h3>
        </header>
        <jsp:include page="partials/menu.jsp" />
        <div id="container">
                <jsp:include page="addprojeto.jsp" />
                <h2 id="titulo" > Projetos Cadastrados </h2>
                <table>
                        <tr>
                                <th> Nome </th>
                                <th> Descricao </th>
                                <th> Membros </th>
                                <th colspan="2"> Operacoes </th>
                        </tr>
                        <c:forEach var="p" items="${todosProjetos}">
                                <tr>
                                        <td>${p.nomeProjeto}</td>
                                        <td>${p.descricaoProjeto}</td>
                                        <td>
                                                <%--<c:forEach var="m" items="${p.membrosAssociados}">
                                                        ${m.pessoa.nome},
                                                </c:forEach>--%>
                                        </td>
                                        <td><a id="rem" href="removeProjeto?idProjeto=${p.idProjeto}"><img src="resources/remove.png"></a></td>
                                        <td><a id="alt" href="mostraProjeto?idProjeto=${p.idProjeto}"><img src="resources/edit.png"></a></td>
                                </tr>
                        </c:forEach>		
                </table>
        </div>	
</body>
<%@include file="partials/rodape.jsp" %>