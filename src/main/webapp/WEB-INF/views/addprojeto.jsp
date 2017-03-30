<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/adiciona-membro.js"></script>
	<title>Insert title here</title>
	<link type="text/css" rel="stylesheet" href="resources/css/estilos.css">
</head>
<body>

	<%--<jsp:useBean id="dao" class="br.com.gleice.tarefas.dao.TarefaDao"></jsp:useBean>--%>
		<form action="adicionaProject" method="post">
			Nome: <br/>
			<input id="nome-pro" type="text" name="nomeProjeto"> <br>
			Descrição: <br/>
			<textarea id="desc-pro" name="descricaoProjeto" rows="5" cols="100"></textarea><br />
			<a id="addmembro" onClick="addtable()" href="#">Add Membro</a>
			<br/>
			
	    	<table class="entrada">
	    		<tr>
	    			<th>Nome do Projeto</th>
	    			<th>Descrição do Projeto</th>
	    		</tr>
	    	</table>
			
	    	Membro: <br/>
			<select id="membro" name="choice" width="30">
				<c:forEach var="tarefa" items="${dao.lista}">
					<option>
		    			<c:out value="${tarefa.descricao}"></c:out>
					</option>
			    </c:forEach>
	    	</select>
	    	<a onClick="add()" href="#">Help</a>
	    	
	    	<input id="memid" type="text" value="0">
			<input id="memnome" type="text" value="-">
			
			<a onClick="novaTarefa()" href="#">Add to Project</a>
			
			<table class="tarefas">
	    		<tr>
	    			<th>id</th>
	    			<th>Descrição da Tarefa</th>
	    		</tr>
	    	</table>
	    	
	    	<input type="submit" value="Adicionar">
			
		</form>
	
</body>
</html>