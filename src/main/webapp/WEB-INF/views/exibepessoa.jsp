<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
    <h3>Alterar Pessoa</h3>
    <form action="alteraPessoa" method="post">
    	
    	Nome:<br/>
		<input type="text" name="nomePessoa" value="${pessoa.nomePessoa}"><br/>
		E-mail:<br/>
		<input type="text" name="emailPessoa" value="${pessoa.emailPessoa}"><br/>
		Telefone:<br/>
		<input type="text" name="telefonePessoa" value="${pessoa.telefonePessoa}"><br/>
		Qualificação:<br/>
		<input type="text" name="qualificacaoPessoa" value="${pessoa.qualificacaoPessoa}"><br/>
    
        <input type="hidden" name="idPessoa" value="${pessoa.idPessoa}"/>
        <input type="submit" value="Alterar"/>
    </form>
</body>
</html>