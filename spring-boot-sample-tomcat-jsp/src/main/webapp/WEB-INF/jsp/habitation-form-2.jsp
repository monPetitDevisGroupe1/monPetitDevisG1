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
    <title> Devis Habitation</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Nom Devis : ${nom_devis}</h1>
<h1> Nom : ${user.nom}</h1>
<h1>Prenom : ${user.prenom}</h1>
    <form:form action="/private/wizard.habitation?_page=3" method="POST" modelAttribute="modelWizard.habitationEtape2">
        <h1> Etape : 2</h1>
        <form:label  path="nbrPiece"> Nombre de pièces :</form:label>
        <form:input path="nbrPiece" /> <BR>
        <form:label  path="etage"> Nombre d’étages :</form:label>
        <form:input path="etage" /> <BR>
        <form:label  path="nbrSalleBain"> Nombre de salles de bains :</form:label>
        <form:input path="nbrSalleBain" /> <BR>
        <form:label  path="garage"> Nombre de garage :</form:label>
        <form:input path="garage" /> <BR>
    <input type="submit" value="Valider et passer a l'etape 3" />
    </form:form>
<a href="/private/dashboard"> Retourner au dashboard en gardant le devis </a><br><br>
<a href="/private/devis.delete"> Annuler et supprimer le devis </a><br><br>
    <a href="/wizard.habitation?_page2">Precedent</a>
</body>
</html>
