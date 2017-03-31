<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GScrum</title>
</head>
<body>
<h2 id="titulo" > Nova Tarefa </h2>
	<form action="adicionaTarefa" method="post">
		Descricao: <br />
		<textarea name="descricao" rows="5" cols="140"></textarea><br />

		<!-- <input type="checkbox" name="finaliza" value="finalizado" disabled> Finalizado <br/> -->
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>