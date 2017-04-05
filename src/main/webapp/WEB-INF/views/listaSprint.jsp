<%@include file="partials/cabecalho.jsp" %>
<body>
        <header>
                <h3>Gscrum - Gerenciador de Projetos Scrum</h3>
        </header>
        <jsp:include page="partials/menu.jsp" />
        <div id="container">
                <jsp:include page="addsprint.jsp" />
                <h2 id="titulo" > Sprints Cadastradas </h2>
                <table>
                        <tr> 
                                <th>Data de Início </th>
                                <th>Data de Fim</th>
                                <th>Product Backlog</th>
                                <th>Estado do Sprint</th>
                                <td>Projeto</td>
                                <th colspan="2"> Operações </th>
                        </tr>
                        <c:choose>
                                <c:when test="${fn:length(todasSprints) eq 0}">
                                        <tr><td colspan="7">Nenhuma sprint adicionada.</td></tr>
                                </c:when>
                                <c:otherwise>
                                        <c:forEach items="${todasSprints}" var="spt">
                                                <tr>
                                                        <td><fmt:formatDate value="${spt.dtInicioSprint.time}" pattern="dd/MM/yyyy"/></td>
                                                        <td><fmt:formatDate value="${spt.dtFimSprint.time}" pattern="dd/MM/yyyy"/></td>
                                                        <td>${spt.productBacklog}</td>
                                                        <td>${spt.estadoSprint}</td>
                                                        <td>${spt.projeto.nomeProjeto}</td>
                                                        <td>
                                                                <a id="rem" href="removeSprint?idSprint=${spt.idSprint}"> <img src="resources/remove.png"> </a>
                                                        </td>
                                                        <td>
                                                                <a id="alt" href="mostraSprint?idSprint=${spt.idSprint}"> <img src="resources/edit.png"> </a>
                                                        </td>
                                                </tr>
                                        </c:forEach>
                                </c:otherwise>
                        </c:choose>
                </table>
        </div>
        <%@include file="partials/rodape.jsp" %>