<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>GScrum</title>	
</head>
<body>
        <%--<jsp:useBean id="dao" class="br.com.gleice.tarefas.dao.PessoaDao"></jsp:useBean>--%>

	<form action="adicionaMembro" method="post">
		Membro: <br/>
		<input type="text" name="nomeMembro"><br/> 
		Fun��o: <br/>
		<input type="text" name="funcaoMembro"><br> 
		Pessoa: <br/>
		<select name="choice" width="20">
			<c:forEach var="pessoa" items="${dao.lista}">
				<option onClick="">
		    		<c:out value="${pessoa.nomePessoa}"></c:out>
				</option>
		    </c:forEach>
    	</select>
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>