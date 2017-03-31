<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="recursos/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GScrum</title>
<link type="text/css" rel="stylesheet" href="recursos/estilos.css">
</head>
<body>
	<header>
		<h3>Gscrum - Gerenciador de Projetos Scrum</h3>
	</header>
	
	<div id="container">
			<h3> Alterar tarefa - ${tarefa.idTarefa}</h3>
		<form action="alteraTarefa" method="post">
			<input type="text" name="idTarefa" value="${tarefa.idTarefa}" />
			Descricao: <br/>
			<textarea name="descricao"cols="100" rows="5"> 
				${tarefa.descricao}
			</textarea>
			<br />
			
			Finalizado? <input type="checkbox" name="finalizado"
			value="true" ${tarefa.finalizado? 'checked' : ''} /> <br/>
			
			Data de finalizacao: <br/>
			<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />"/>
			<br/>
			<input type="submit"value="Alterar"/>
		</form>
	</div>
	
</body>
</html>