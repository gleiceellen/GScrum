<%@include file="partials/cabecalho.jsp" %>
<body>
	<header>
		<h3>Gscrum - Gerenciador de Projetos Scrum</h3>
	</header>
        <jsp:include page="partials/menu.jsp" />
	<div id="container">
		<jsp:include page="addpessoa.jsp" />
		<h2 id="titulo" > Pessoas Cadastradas </h2>

		<table>
			<tr>
				<th> Nome </th>
				<th> Email </th>
				<th> Telefone </th>
				<th> Qualificacao </th>
				<th colspan="2"> Operacoes </th>
			</tr>
				<c:forEach var="p" items="${todosPessoas}">
					<tr>
						<td>${p.nomePessoa}</td>
						<td>${p.emailPessoa}</td>
						<td>${p.telefonePessoa}</td>
						<td>${p.qualificacaoPessoa}</td>
						<td><a id="rem" href="removePessoa?idPessoa=${p.idPessoa}"><img src="resources/remove.png"></a></td>
						<td><a id="alt" href="mostraPessoa?idPessoa=${p.idPessoa}"><img src="resources/edit.png"></a></td>
					</tr>
				</c:forEach>		
		</table>
	</div>	
</body>
<%@include file="partials/rodape.jsp" %>