<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<link type="text/css" href="resources/css/bootstrap.css" rel="stylesheet" />
	<link type="text/css" href="resources/css/bootstrap.min.css" rel="stylesheet" />
	<title>Insert title here</title>
</head>
<body>
	<h3 class="text-center">Adiciona despesas</h3>
    <p class="text-center"><form:errors path="despesa.descricao" cssStyle="color:red"/></p>
	<form class="container" action="adicionaDespesa" method="post">
		Descrição: <br />
		<textarea class="form-control" rows="5" cols="100" name="descricao"></textarea><br /><br />
		<input class="btn btn-primary" type="submit" value="Adicionar" />
	</form>
</body>
</html>