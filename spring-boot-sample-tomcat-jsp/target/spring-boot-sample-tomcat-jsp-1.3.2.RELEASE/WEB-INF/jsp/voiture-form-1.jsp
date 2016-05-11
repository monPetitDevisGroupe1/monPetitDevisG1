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
    <title> Devis Voiture</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body>
    <form:form action="/private/wizard?_page=2" method="POST" modelAttribute="modelWizard.voitureEtape1">
        <h1>Etape : 1</h1>
        <h1>Nom Devis : ${nom_devis}</h1>
        <h1> Nom : ${user.nom}</h1>
        <h1>Prenom : ${user.prenom}</h1>
        <br/>
        <form:label  path="marque">Marque :</form:label>
        <form:select path="marque">
            <form:option value="Renault">Renault</form:option>
            <form:option value="Fiat">Fiat</form:option>
            <form:option value="Citroen">Citroen</form:option>
            <form:option value="Opel">Opel</form:option>
        </form:select>
        <form:label path="modele">Model :</form:label>
        <form:select path="modele">
            <form:option value="modele1">modele 1</form:option>
            <form:option value="modele2">modele 2</form:option>
            <form:option value="modele3">modele 3</form:option>
            <form:option value="modele4">modele 4</form:option>
        </form:select>
        <form:label path="carburant">Carburant :</form:label>
        <form:select path="carburant">
            <form:option value="gazoil">Gazoil</form:option>
            <form:option value="SP95">SP95</form:option>
            <form:option value="SP98">SP98</form:option>
        </form:select>
        <form:label path="chevauxFisc">Chevaux :</form:label>
        <form:input  path="chevauxFisc" />
        <input type="submit">Valider et aller à l'étape suivante</input>
    </form:form>
    <a href="/private/dashboard"> Retourner au dashboard en gardant le devis </a><br><br>
    <a href="/private/devis.delete"> Annuler et supprimer le devis </a><br><br>
</body>
</html>
