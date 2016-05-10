<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<div style = "float: right;">
    ID_USER : ${sessionScope.id_user}
    <a href="/private/profil">Gestion du profil </a> | <a href="/logout">D&eacute;connexion</a>
</div>
<h1>Mon petit devis</h1>

<h2>
    <a href="/private/devis">Consultations des Devis </a>
</h2>

<form action="<c:url value='/private/devis'/>" method="GET">
    <button type="submit" value="voiture">Nouveau Devis</button>
</form>


<h2>Dashboard</h2>

<c:if test="${not empty nom}">
    <h3>Dernier devis : </h3>
    Nom : ${nom} <br />
    Type : ${type_devis} <br />
    Etape : ${etape}
</c:if>

</body>
</html>
