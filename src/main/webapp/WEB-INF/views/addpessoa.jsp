<%@include file="partials/cabecalho.jsp" %>
<body>
        <h2 id="titulo" > Nova Pessoa </h2>
	<form action="adicionaPessoa" method="post">
                <input type="hidden" name="idPessoa" value="${pessoa.idPessoa}"/>
                
		Nome:
		<input type="text" name="nomePessoa" size="55px" value="${pessoa.nomePessoa}">
		
                E-mail:
		<input type="text" name="emailPessoa" size="55px" value="${pessoa.emailPessoa}">
		<br>
                
                Telefone:
		<input type="text" name="telefonePessoa" size="51px" value="${pessoa.telefonePessoa}">

                Qualificacao:
		<input type="text" name="qualificacaoPessoa" size="51px" value="${pessoa.qualificacaoPessoa}">
                <br/><br/>
		
                <input type="submit" value="Adicionar">
	</form>
</body>
<%@include file="partials/rodape.jsp" %>