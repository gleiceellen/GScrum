<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@taglib tagdir="/WEB-INF/tags" prefix="gleice" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Adiciona Sprint</title>
	<link rel="stylesheet" href="/recursos/css/estilos.css">
	<link type="text/css" href="css/custom-theme/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.20.custom.min.js"></script>
</head>
<body>
	<script type="text/javascript">
			
			function addTarefaNoSprint(idTarefa){
				
			}
			
	</script>
	<jsp:useBean id="dao" class="br.com.gleice.tarefas.dao.TarefaDao"></jsp:useBean>
	<jsp:useBean id="cont" class="br.com.gleice.tarefas.controller.TarefaController"></jsp:useBean>
	<jsp:useBean id="daos" class="br.com.gleice.tarefas.dao.ProjetoDao"></jsp:useBean>
	<form action="adicionaSprint" method="post">
		
		Data de Início:<br/>
		<input type="text" id="datepicker" name="dtInicioSprint" 
				value="<fmt:formatDate value="${sprint.dtInicioSprint.time}" pattern="dd/MM/yyyy"/>"/>
		<br/>
		
		Data de Fim:<br/>
		<input type="text" id="datepicker" name="dtFimSprint" 
				value="<fmt:formatDate value="${sprint.dtFimSprint.time}" pattern="dd/MM/yyyy"/>"/>
		<br/>
		
		Product Backlog:<br/>
		<input type="text" name="pbacklog"><br/>
		Estado Sprint:<br/>
		<select name="estadoSprint">
			<option value="criado">Iniciado</option>
			<option value="executando">Executando</option>
			<option value="finalizado">Finalizado</option>
		</select>
		<input type="submit" value="Adicionar">
		<br/><br/>
		Tarefas:
		<a href="verTarefasDisponiveis">Ver Tarefas Disponíveis!</a>
		<select name="choice" width="20">
				<c:forEach var="pro" items="${daos.lista}">
					<option onClick="">
		    			<c:out value="${pro.nomeProjeto}"></c:out>
					</option>
			    </c:forEach>
	    	</select>
	</form>
</body>
</html>