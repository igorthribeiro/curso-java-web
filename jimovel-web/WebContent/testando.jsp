<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Primeiro JSP</title>
</head>
<body>
	<%--
   Comentário:
   Esse JSP foi criado durante o curso de JavaWEB.
   IgorDEV: http://igordev.com.br
   --%>
	<%
		String mensagem = "Olá, essa é uma mensagem direto do servidor!";
		out.println(mensagem);
	%>
	<br /><br />
	<%
		out.print("Exibindo a mensagem utilizando o atalho de saída:");
	%>
	<%=mensagem%>
	<%
		System.out.println("** Isso vai sair no console! **");
	%>
</body>
</html>