<%@include file="partials/cabecalho.jsp" %>
<body>
        <script>
                $('body').ready(function() {
                        $("#dtInicioSprint").datepicker({dateFormat: 'dd/mm/yy'});
                        $("#dtFimSprint").datepicker({dateFormat: 'dd/mm/yy'});
                });
        </script>
        
        <h2 id="titulo" > Nova Sprint </h2>
        <form action="adicionaSprint" method="post">
                <input type="hidden" name="idSprint" value="${sprint.idSprint}"/>
                
                Data de Inicio: 
                <input type="text" id="dtInicioSprint" name="dtInicioSprint" maxlength="10" value="<fmt:formatDate value='${sprint.dtInicioSprint.time}' pattern='dd/MM/yyyy'/>"/>

                Data de Fim:
                <input type="text" id="dtFimSprint" name="dtFimSprint" maxlength="10" value="<fmt:formatDate value='${sprint.dtFimSprint.time}' pattern='dd/MM/yyyy'/>"/> 

                Product Backlog:
                <input type="text" name="productBacklog" value="${sprint.productBacklog}"/> 

                Estado Sprint:<br/>
                <input type="radio" name="estadoSprint" value="1" ${sprint.estadoSprint eq '1' ? "checked='checked'" : ''}>Iniciado
                <input type="radio" name="estadoSprint" value="2" ${sprint.estadoSprint eq '2' ? "checked='checked'" : ''}>Executando
                <input type="radio" name="estadoSprint" value="3" ${sprint.estadoSprint eq '3' ? "checked='checked'" : ''}>Finalizado
                <br/>
                
                Projeto:<br/>
                <select id="combo_projetos" name="projeto.idProjeto">
                        <c:forEach var="projeto" items="${projetos}">
                                <option value="${projeto.idProjeto}" ${projeto.idProjeto eq sprint.projeto.idProjeto ? "selected='selected'" : ''}>${projeto.nomeProjeto}</option>
                        </c:forEach>
                </select><br/>
                        
                <input type="submit" value="Adicionar">
        </form>
                
        <%@include file="partials/rodape.jsp" %>
