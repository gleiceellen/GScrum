<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
</head>
<body>
	<header>
		<h3>Gscrum - Gerenciador de Projetos Scrum</h3>
	</header>
	<div id="container">
		<jsp:include page="addpessoa.jsp" />
		<h2 id="titulo" > Pessoas Cadastradas </h2>

		<table>
			<tr>
				<th> Nome </th>
				<th> Email </th>
				<th> Telefone </th>
				<th> Qualificacao </th>
				<th colspan="2"> Operações </th>
			</tr>
				<c:forEach var="p" items="${todasPessoas}">
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
</html>