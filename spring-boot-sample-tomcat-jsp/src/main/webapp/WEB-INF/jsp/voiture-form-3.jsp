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
<h1>Nom Devis : ${nom_devis}</h1>
<h1> Nom : ${user.nom}</h1>
<h1>Prenom : ${user.prenom}</h1>
    <form:form action="/wizard?_page=4" method="POST" modelAttribute="modelWizard.voitureEtape3">
        <h1>Etape : 3</h1>
        <form:label  path="dorsGarage"> Au garage :</form:label>
        <form:select path="dorsGarage">
            <form:option value="1">Oui</form:option>
            <form:option value="0">Non</form:option>
        </form:select>
        <form:label  path="adresseGarage"> Adresse si garage :</form:label>
        <form:input path="adresseGarage" /> <BR>
        <form:label  path="conducteurPrincipal"> Conducteur principale :</form:label>
        <form:input path="conducteurPrincipal" /> <BR>
        <form:label  path="conducteurSecondaire"> Conducteur econdaire :</form:label>
        <form:input path="conducteurSecondaire" /> <BR>
        <input type="submit" value="Valider et passer a l'etape 4" />
    </form:form>
<a href="/private/dashboard"> Retourner au dashboard en gardant le devis </a><br><br>
<a href="/private/devis.delete"> Annuler et supprimer le devis </a><br><br>
<a href="/wizard?_page=2">Previous</a>
</body>
</html>
