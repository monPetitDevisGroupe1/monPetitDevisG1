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
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>

<html>
<head>
    <title> Devis Voiture</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1> Nom : ${user.nom}</h1>
<h1>Prenom : ${user.prenom}</h1>
    <form:form action="/wizard?_page=3" method="POST" modelAttribute="modelWizard.voitureEtape2">
        <h1> Etape : 2</h1>
        <form:label  path="datePermis"> Date du permis :</form:label>
        <form:input path="datePermis" /> <BR>
        <form:label  path="nbrAccident"> Nombre d’accident :</form:label>
        <form:input path="nbrAccident" /> <BR>
        <form:label  path="bonusMalus"> Bonus malus :</form:label>
        <form:input path="bonusMalus" /> <BR>
    <input type="submit" value="Valider et passer a l'etape 3" />
    </form:form>
    <a href="/wizard?_page2">Precedent</a>
</body>
</html>
