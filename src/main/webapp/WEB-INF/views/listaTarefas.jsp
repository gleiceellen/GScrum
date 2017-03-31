<%@include file="partials/cabecalho.jsp" %>
<body>
        <script type="text/javascript">
                function finalizaAgora(idTarefa) {
                        $.post("finalizaTarefa", {'idTarefa': idTarefa}, function () {
                                //selecionando o elemento html através da ID e alterando o HTML dele
                                $("#tarefa_" + idTarefa).html("Finalizado");
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


                <br /> <br />
                <table>
                        <tr> 
                                <th>Id</th>
                                <th>Descrição</th>
                                <th>Finalizando?</th>
                                <th>Data de finalização</th>
                                <th colspan="2"> Operações </th>
                        </tr>
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
                                        <td>
                                                <fmt:formatDate value="${tarefa.dataFinalizacao.time}"
                                                                pattern="dd/MM/yyyy"/>
                                        </td>
                                        <td>
                                                <a id="rem" href="removeTarefa?idTarefa=${tarefa.idTarefa}"> <img src="resources/remove.png"> </a>
                                        </td>
                                        <td><a id="alt" href="mostraTarefa?idTarefa=${tarefa.idTarefa}"> <img src="resources/edit.png"> </a>
                                        </td>
                                </tr>
                        </c:forEach>
                </table>

        </div>

</body>
<%@include file="partials/rodape.jsp" %>