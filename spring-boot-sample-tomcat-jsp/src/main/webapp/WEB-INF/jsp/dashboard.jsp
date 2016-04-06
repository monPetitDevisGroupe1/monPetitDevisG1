<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<div style = "float: right;">
    <a href="/profil">Gestion du profil</a> | <a href="/logout">D&eacute;connexion</a>
</div>
<h1>Mon petit devis</h1>
<h2>Dashboard</h2>

<c:if test="${not empty nom}">
    <h3>Dernier devis : </h3>
    Nom : ${nom} <br />
    Type : ${type_devis} <br />
    Etape : ${etape}
    <c:if test="${etape > 0}">
        <h5>Etape 1</h5>
        Marque : ${marque} <br />
        Modele : ${modele} <br />
        Carburant : ${carburant} <br />
        Chevaux Fiscaux : ${chevaux_fisc} <br />
    </c:if>
    <c:if test="${etape > 1}">
        <h5>Etape 2</h5>
        Date du permis : ${date_permis} <br />
        Nombre d'accidents : ${nbr_accident} <br />
        Bonus / Malus : ${bonus_malus} % <br />
    </c:if>
    <c:if test="${etape > 2}">
        <h5>Etape 3</h5>
        Voiture dans un garage : ${dors_garage} <br />
        Adresse du garage : ${adresse_garage} <br />
        Conducteur principal : ${conducteur_principal} <br />
        Conducteur secondaire : ${conducteur_secondaire} <br />
    </c:if>

    <c:if test="${etape > 3}">
        <h5>Etape 4</h5>
        Prix : ${prix} <br />
        Formule : ${formule} <br />
    </c:if>
</c:if>
</body>
</html>
