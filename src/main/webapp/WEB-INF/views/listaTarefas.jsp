<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GScrum</title>
<link type="text/css" rel="stylesheet" href="resources/css/estilos.css">
</head>
<body>
	<script type="text/javascript">
		
		function finalizaAgora(idTarefa){
			$.post("finalizaTarefa", {'idTarefa':idTarefa}, function(){
				//selecionando o elemento html através da ID e alterando o HTML dele
				$("#tarefa_"+idTarefa).html("Finalizado");
			});
		}
	</script>
	
	<header>
		<h3>Gscrum - Gerenciador de Projetos Scrum</h3>
	</header>
	
	
	<div id="container">
	<jsp:include page="addtarefa.jsp" />
	<h2 id="titulo" > Tarefas Cadastradas </h2>

	
		<br /> <br />
		<table>
			<tr> 
				<th>Id</th>
				<th>Descrição</th>
				<th>Finalizando?</th>
				<th>Data de finalização</th>
				<th colspan="2"> Operações </th>
			</tr>
			<c:forEach items="${todasTarefas}" var="tarefa">
				<tr>
					<td>${tarefa.idTarefa}</td>
					<td>${tarefa.descricao}</td>
					<c:if test="${tarefa.finalizado eq false}">
						<td id="tarefa_${tarefa.idTarefa}">
						<a id="fina" href="#" onClick="finalizaAgora(${tarefa.idTarefa})">
							Finaliza Agora!
						</a>
					</c:if>
					<c:if test="${tarefa.finalizado eq true}">
						<td>Finalizado</td>
					</c:if>
					<td>
						<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<a id="rem" href="removeTarefa?idTarefa=${tarefa.idTarefa}"> <img src="resources/remove.png"> </a>
					</td>
					<td><a id="alt" href="mostraTarefa?idTarefa=${tarefa.idTarefa}"> <img src="resources/edit.png"> </a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	
	</body>
</html>