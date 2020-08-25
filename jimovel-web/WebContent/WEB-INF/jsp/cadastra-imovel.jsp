<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de imóveis</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<h3>Cadastro de imóveis</h3>
	<form action="mvc" method="post">
		<table>
			<tr>
				<td>Propriet&aacute;rio:</td>
				<td><input type="text" name="proprietario" value="${imovel.proprietario}" /></td>
			</tr>
			<tr>
				<td>Endere&ccedil;o:</td>
				<td><input type="text" name="endereco"	value="${imovel.endereco}" /></td>
			</tr>
			<tr>
				<td>Tipo contrato:</td>
				<td><select name="tipo">
						<option value="${imovel.tipo}" selected="selected">${imovel.tipo}</option>
						<c:if test="${imovel.tipo eq 'venda' }">
							<option value="aluguel">aluguel</option>
						</c:if>
						<c:if test="${imovel.tipo eq 'aluguel' }">
							<option value="venda">venda</option>
						</c:if>
						<c:if test="${empty imovel.tipo}">
							<option value="aluguel">aluguel</option>
							<option value="venda">venda</option>
						</c:if>
				</select></td>
			</tr>
			<tr>
				<td>Contato:</td>
				<td><input type="text" name="contato" value="${imovel.contato}" /></td>
			</tr>
			<tr>
				<td>Valor:</td>
				<td><input type="text" name="valor" value="${imovel.valor}" /></td>
			</tr>
			<tr>
				<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
				<fmt:formatDate value="${imovel.dataInclusao.time}"	pattern="dd/MM/yyyy" var="dataFmt" />
				<td>Data Inclus&atilde;o:</td><td><custom:campoData id="dataInclusao" value="${dataFmt}" /></td>
			</tr>
		</table>
		<br />
		<input type="hidden" name="id" value="${imovel.id}" />
		<input type="hidden" name="servico" value="GravaImovelServico" />
		<input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>