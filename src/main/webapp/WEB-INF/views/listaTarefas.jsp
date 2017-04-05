<%@include file="partials/cabecalho.jsp" %>
<body>
        <script type="text/javascript">
                function finalizaAgora(idTarefa) {
                        $.post("finalizaTarefa", {'idTarefa': idTarefa}, function (dataFinalizada) {
                                //selecionando o elemento html atrav�s da ID e alterando o HTML dele
                                $("#tarefa_" + idTarefa).html("Finalizado");
                                $("#tarefa_data_" + idTarefa).html(dataFinalizada);
                        });
                }
        </script>

        <header>
                <h3>Gscrum - Gerenciador de Projetos Scrum</h3>
        </header>
        <jsp:include page="partials/menu.jsp" />

        <div id="container">
                <jsp:include page="addtarefa.jsp" />
                <h2 id="titulo" > Tarefas Cadastradas </h2>
                <table>
                        <tr> 
                                <th>Id</th>
                                <th>Descri��o</th>
                                <th>Finalizando?</th>
                                <th>Data de finaliza��o</th>
                                <th>Pessoa Respons�vel</th>
                                <th>Sprint</th>
                                <th colspan="2"> Opera��es </th>
                        </tr>
                        <c:choose>
                                <c:when test="${fn:length(todasTarefas) eq 0}">
                                        <tr><td colspan="8">Nenhuma tarefa adicionada.</td></tr>
                                </c:when>
                                <c:otherwise>
                                        <c:forEach items="${todasTarefas}" var="tarefa">
                                                <tr>
                                                        <td>${tarefa.idTarefa}</td>
                                                        <td>${tarefa.descricao}</td>
                                                        <c:if test="${tarefa.finalizado eq false}">
                                                                <td id="tarefa_${tarefa.idTarefa}">
                                                                        <a id="fina" href="#" onClick="finalizaAgora(${tarefa.idTarefa})">
                                                                                Finaliza Agora!
                                                                        </a>
                                                                </c:if>
                                                                <c:if test="${tarefa.finalizado eq true}">
                                                                <td>Finalizado</td>
                                                        </c:if>
                                                        <td id="tarefa_data_${tarefa.idTarefa}">
                                                                <fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
                                                        </td>
                                                        <td>${tarefa.pessoa.nomePessoa}</td>
                                                        <td>${tarefa.sprint.productBacklog}</td>
                                                        <td>
                                                                <a id="rem" href="removeTarefa?idTarefa=${tarefa.idTarefa}"> <img src="resources/remove.png"> </a>
                                                        </td>
                                                        <td>
                                                                <a id="alt" href="mostraTarefa?idTarefa=${tarefa.idTarefa}"> <img src="resources/edit.png"> </a>
                                                        </td>
                                                </tr>
                                        </c:forEach>
                                </c:otherwise>
                        </c:choose>
                </table>

        </div>

</body>
<%@include file="partials/rodape.jsp" %>