<%@include file="partials/cabecalho.jsp" %>
<body>
	<h3>Alterar Projeto</h3>
    <form action="alteraProjeto" method="post">
    	
    	Nome:<br/>
		<input type="text" name="nomeProjeto" value="${projeto.nomeProjeto}"><br/>
		Descricao:<br/>
			<textarea name="descricaoProjeto"cols="100" rows="5"> 
				${projeto.descricaoProjeto}
			</textarea>
    
        <input type="hidden" name="idProjeto" value="${projeto.idProjeto}"/>
        <input type="submit" value="Alterar"/>
    </form>
</body>
<%@include file="partials/rodape.jsp" %>