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
<h1> Nom : ${user.nom}</h1>
<h1>Prenom : ${user.prenom}</h1>
    <form:form action="/wizard.habitation?_page=2" method="POST" modelAttribute="modelWizard.habitationEtape1">
        <h1>Etape : 1</h1>
        <h1> Nom :</h1>
        <h1>Prenom :</h1>
        <h1>Nom Devis :</h1>
        <br/>
        <form:label  path="typeHabitation">Type d'habitation :</form:label>
        <form:input  path="typeHabitation" />
        <form:label path="surface">Surface :</form:label>
        <form:input  path="surface" />

        <input type="submit">Valider et aller à l'étape suivante</input>
    </form:form>
</body>
</html>
