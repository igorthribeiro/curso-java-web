<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<link type="text/css" href="resources/css/bootstrap.css" rel="stylesheet" />
	<link type="text/css" href="resources/css/bootstrap.min.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<h3 class="text-center">Alterar despesa - ${despesa.id}</h3>
	<form class="container" action="alteraDespesa" method="post">
		<input class="form-control" type="hidden" name="id" value="${despesa.id }" />
		Descri&ccedil;&atilde;o:<br />
		<textarea class="form-control" name="descricao" cols="100" rows="5">${despesa.descricao}</textarea>
		<br /> Pago?
		<input type="checkbox" name="pago" value="true" ${despesa.pago ? 'checked' : ''} />
		<br /> Data de pagamento:<br />
		<input class="form-control" type="text"	name="dataPagamento"
		     value="<fmt:formatDate value="${despesa.dataPagamento.time}" pattern="dd/MM/yyyy" />"/>
		<br />
		<br />
		<input class="btn btn-primary" type="submit" value="Alterar" />
	</form>
</body>
</html>