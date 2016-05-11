<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 04/04/2016
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title> Devis Habitation</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body>
<h1>Nom Devis : ${nom_devis}</h1>
<h1> Nom : ${user.nom}</h1>
<h1>Prenom : ${user.prenom}</h1>
    <form:form action="/wizard.habitation?_page=2" method="POST" modelAttribute="modelWizard.habitationEtape1">
        <h1>Etape : 1</h1>
        <br/>
        <form:label  path="typeHabitation">Type d'habitation :</form:label>
        <form:select path="typeHabitation">
            <form:option value="T1">T1</form:option>
            <form:option value="T2">T2</form:option>
            <form:option value="T3">T3</form:option>
            <form:option value="T4">T4</form:option>
            <form:option value="T5">T5</form:option>
        </form:select>
        <form:label path="surface">Surface :</form:label>
        <form:input  path="surface" />

        <input type="submit">Valider et aller à l'étape suivante</input>
        <a href="/wizard?_page=3">Precedent</a><br><br>
    </form:form>
<a href="/private/dashboard"> Retourner au dashboard en gardant le devis </a><br><br>
<a href="/private/devis.delete"> Annuler et supprimer le devis </a>
</body>
</html>
