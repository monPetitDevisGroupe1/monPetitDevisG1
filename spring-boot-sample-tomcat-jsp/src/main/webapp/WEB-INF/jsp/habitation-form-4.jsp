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
    <form:form action="/wizard.habitation?_finish" method="POST" modelAttribute="modelWizard.habitationEtape4">
        <h1> Etape : 4 </h1>
        <form:select path="formule">
            <form:option value="Abonnement1">Abonnement a 30 euros</form:option>
            <form:option value="Abonnement2">Abonnement a 50 euros</form:option>
        </form:select>
        <form:label  path="prix"> Prix :</form:label>
        <form:input path="prix" /> <BR>
        <input type="submit" value="Valider le devis" />
    </form:form>
<a href="/private/dashboard"> Retourner au dashboard en gardant le devis </a><br><br>
<a href="/private/devis.delete"> Annuler et supprimer le devis </a><br><br>
    <a href="/wizard.habitation?_page=3">Precedent</a>
</body>
</html>
