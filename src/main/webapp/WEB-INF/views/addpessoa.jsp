<%@include file="partials/cabecalho.jsp" %>
<body>

<h2 id="titulo" > Nova Pessoa </h2>

	<form action="adicionaPessoa" method="post">
		
		Nome:
		<input type="text" name="nomePessoa" size="55px">
		E-mail:
		<input type="text" name="emailPessoa" size="55px">
		Telefone:
		<input type="text" name="telefonePessoa" size="51px">
		Qualificacao:
		<input type="text" name="qualificacaoPessoa" size="51px"><br/><br/>
		<input type="submit" value="Adicionar">
		
	</form>
</body>
<%@include file="partials/rodape.jsp" %>