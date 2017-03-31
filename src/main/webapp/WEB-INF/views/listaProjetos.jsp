<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GScrum</title>
<link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
</head>
<body>
	<header>
		<h3>Gscrum - Gerenciador de Projetos Scrum</h3>
	</header>
	<div id="container">
		<jsp:include page="addprojeto.jsp" />
		<h2 id="titulo" > Projetos Cadastrados </h2>

		<table>
			<tr>
				<th> Nome </th>
				<th> Descricao </th>
				<th colspan="2"> Operacoes </th>
			</tr>
				<c:forEach var="p" items="${todosProjetos}">
					<tr>
						<td>${p.nomeProjeto}</td>
						<td>${p.descricaoProjeto}</td>
						<td><a id="rem" href="removeProjeto?idProjeto=${p.idProjeto}"><img src="resources/remove.png"></a></td>
						<td><a id="alt" href="mostraProjeto?idProjeto=${p.idProjeto}"><img src="resources/edit.png"></a></td>
					</tr>
				</c:forEach>		
		</table>
	</div>	
</body>
</html>