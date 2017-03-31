<%@include file="partials/cabecalho.jsp" %>
<body>
    <h3>Alterar Pessoa</h3>
    <form action="alteraPessoa" method="post">
    	
    	Nome:<br/>
		<input type="text" name="nomePessoa" value="${pessoa.nomePessoa}"><br/>
		E-mail:<br/>
		<input type="text" name="emailPessoa" value="${pessoa.emailPessoa}"><br/>
		Telefone:<br/>
		<input type="text" name="telefonePessoa" value="${pessoa.telefonePessoa}"><br/>
		Qualificação:<br/>
		<input type="text" name="qualificacaoPessoa" value="${pessoa.qualificacaoPessoa}"><br/>
    
        <input type="hidden" name="idPessoa" value="${pessoa.idPessoa}"/>
        <input type="submit" value="Alterar"/>
    </form>
</body>
<%@include file="partials/rodape.jsp" %>