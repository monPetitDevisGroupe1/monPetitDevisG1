<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 04/04/2016
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>>

<html>
<head>
    <title> Devis Voiture</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

    <form:form action="/private/dashboard" method="POST" modelAttribute="modelWizard.voitureEtape4">
        <h1> Etape : 4 </h1>
        <form:label  path="prix"> Prix :</form:label>
        <form:input path="prix" /> <BR>
        <form:label  path="formule"> Formule abonnement :</form:label>
        <form:input path="formule" /> <BR>
        <input type="submit" value="Valider et passer a l'etape 4" />
    </form:form>
    <a href="/wizard?_page=3">Previous</a>
</body>
</html>
