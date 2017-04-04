<%@include file="partials/cabecalho.jsp" %>
<body>
        <h2 id="titulo" > Nova Pessoa </h2>
	<form action="adicionaPessoa" method="post">
                <input type="hidden" name="idPessoa" value="${pessoa.idPessoa}"/>
            <section id="add">
            <div id="faixa"></div>
		Nome:<br/>
		<input type="text" name="nomePessoa" size="55px" value="${pessoa.nomePessoa}"><br/>
		
                E-mail:<br/>
		<input type="text" name="emailPessoa" size="55px" value="${pessoa.emailPessoa}"><br/>
		<br>
            </section>
            <section id="lista">   
            <div id="faixa"></div>
                Telefone:<br/>
		<input type="text" name="telefonePessoa" size="51px" value="${pessoa.telefonePessoa}"><br/>

                Qualificacao:<br/>
		<input type="text" name="qualificacaoPessoa" size="51px" value="${pessoa.qualificacaoPessoa}"><br/>
                <br/><br/>
		
                <input id="addpes" type="submit" value="Adicionar">
            </section>
	</form>
</body>
<%@include file="partials/rodape.jsp" %>