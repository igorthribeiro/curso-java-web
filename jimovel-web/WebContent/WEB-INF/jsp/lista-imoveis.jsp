<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<h3><a href="mvc?servico=MostraImovelServico">Cadatrar im&oacute;vel</a></h3>
	<table cellspacing="2" width="70%">
		<thead align="left">
			<tr>
				<th>Proriet&aacute;rio</th>
				<th>Endere&ccedil;o</th>
				<th>Tipo</th>
				<th>Contato</th>
				<th>Valor</th>
				<th>Data inclus&atilde;o</th>
			</tr>
		</thead>
<%-- 	<jsp:useBean id="dao" class="br.com.igordev.dao.ImovelDao" /> --%>
		<c:forEach var="imovel" items="${imoveis}" varStatus="ln">
			<tr bgcolor="#${ln.count % 2 == 0 ? '9c9c9c' : 'ffffff'}">
				<td>${imovel.proprietario}</td>
				<td>${imovel.endereco}</td>
				<td>${imovel.tipo}</td>
				<c:if test="${imovel.contatoEhEmail}">
					<td><a href="mailto:${imovel.contato}">${imovel.contato}</a></td>
				</c:if>
				<c:if test="${not imovel.contatoEhEmail}">
					<td>${imovel.contato}</td>
				</c:if>
				<td><fmt:formatNumber value="${imovel.valor}" type="currency" />
				</td>
				<td><fmt:formatDate value="${imovel.dataInclusao.time}"
						pattern="dd/MM/yyyy - EEE" /></td>
				<td>
					<%-- 				
						<a id="remover" href="mvc?servico=RemoveImovelServico&id=${imovel.id}">Remover</a>
					--%>
					<a class="remover" href="#" id="${imovel.id}">Remover</a>
				</td>
				<td>
					<a href="mvc?servico=MostraImovelServico&id=${imovel.id}">Alterar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp" />
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script>
		$('.remover').click(function() {
			var r = confirm('Deseja realmente excluir esse imóvel?');
			if (r) {
				window.open('mvc?servico=RemoveImovelServico&id=' + $(this).attr('id'), '_self');
			}
		});
	</script>
</body>
</html>