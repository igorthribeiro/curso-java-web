<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" href="resources/css/bootstrap.css" rel="stylesheet" />
	<link type="text/css" href="resources/css/bootstrap.min.css" rel="stylesheet" />
	<title>Insert title here</title>
</head>
<body>
	<h2>Página inicial da Lista de Despesas</h2>
	<p>Bem vindo, ${usuarioLogado.login}</p>
	<a href="listaDespesas">Clique aqui</a> para acessar a lista de despesas
	<br />
	<br />
	<a href="logout" class="badge badge-secondary" style="width: 10em; margin-left: 10px;">Sair do sistema</a>
</body>
</html>