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
    <title> Devis Habitation</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Nom Devis : ${nom_devis}</h1>
<h1> Nom : ${user.nom}</h1>
<h1>Prenom : ${user.prenom}</h1>
    <form:form action="/wizard.habitation?_page=4" method="POST" modelAttribute="modelWizard.habitationEtape3">
        <h1>Etape : 3</h1>
        <form:label  path="surfaceTerrain"> Surface de terrain :</form:label>
        <form:input path="surfaceTerrain" /> <BR>
        <form:label  path="surfaceTerrasse"> Surface de terasse :</form:label>
        <form:input path="surfaceTerrasse" /> <BR>
        <form:label  path="typeChauffage"> N° du type de chauffage :</form:label>
        <form:select path="typeChauffage">
            <form:option value="1">Chaudiere</form:option>
            <form:option value="2">Fuel</form:option>
            <form:option value="3">Electrique</form:option>
        </form:select>
        <input type="submit" value="Valider et passer a l'etape" />
    </form:form>
<a href="/private/dashboard"> Retourner au dashboard en gardant le devis </a><br><br>
<a href="/private/devis.delete"> Annuler et supprimer le devis </a><br><br>
    <a href="/wizard.habitation?_page=2">Precedent</a>
</body>
</html>
