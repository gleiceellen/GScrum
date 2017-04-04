<%@include file="partials/cabecalho.jsp" %>
<script type="text/javascript" src="resources/js/app/adiciona-membro.js"></script>
<body>
        <h2 id="titulo" > Novo Projeto </h2>
        <form action="adicionaProjeto" method="post">
        <section id="add">
            <div id="faixa"></div>
            Nome:
                <input id="nome-pro" type="text" name="nomeProjeto"> 
                <br>
                
                Descricao:
                <textarea id="desc-pro" name="descricaoProjeto" rows="5" cols="76"></textarea>
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
                                <%-- Vai ser adicionar pelo Javascript 'adicionarMembroTabela' --%>
                        </tbody>
                </table>
                
                <input type="submit" id="addpro" value="Adicionar">
        </section>
        </form>

</body>
<%@include file="partials/rodape.jsp" %>