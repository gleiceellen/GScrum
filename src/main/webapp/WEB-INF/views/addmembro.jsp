<%@include file="partials/cabecalho.jsp" %>
<body>
        <%--<jsp:useBean id="dao" class="br.com.gleice.tarefas.dao.PessoaDao"></jsp:useBean>--%>

	<form action="adicionaMembro" method="post">
		Membro: <br/>
		<input type="text" name="nomeMembro"><br/> 
		Funcao: <br/>
		<input type="text" name="funcaoMembro"><br> 
		Pessoa: <br/>
		<select name="choice" width="20">
			<c:forEach var="pessoa" items="${dao.lista}">
				<option onClick="">
		    		<c:out value="${pessoa.nomePessoa}"></c:out>
				</option>
		    </c:forEach>
    	</select>
		<input type="submit" value="Adicionar">
	</form>
</body>
<%@include file="partials/rodape.jsp" %>