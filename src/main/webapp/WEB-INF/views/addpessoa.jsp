<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GScrum</title>
</head>
<body>

<h2 id="titulo" > Nova Pessoa </h2>

	<form action="adicionaPessoa" method="post">
		
		Nome:
		<input type="text" name="nomePessoa" size="55px">
		E-mail:
		<input type="text" name="emailPessoa" size="55px">
		Telefone:
		<input type="text" name="telefonePessoa" size="51px">
		Qualificacao:
		<input type="text" name="qualificacaoPessoa" size="51px"><br/><br/>
		<input type="submit" value="Adicionar">
		
	</form>
</body>
</html>