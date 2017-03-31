<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GScrum</title>
</head>
<body>
	<h3>Alterar Projeto</h3>
    <form action="alteraProjeto" method="post">
    	
    	Nome:<br/>
		<input type="text" name="nomeProjeto" value="${projeto.nomeProjeto}"><br/>
		Descricao:<br/>
			<textarea name="descricaoProjeto"cols="100" rows="5"> 
				${projeto.descricaoProjeto}
			</textarea>
    
        <input type="hidden" name="idProjeto" value="${projeto.idProjeto}"/>
        <input type="submit" value="Alterar"/>
    </form>
</body>
</html>