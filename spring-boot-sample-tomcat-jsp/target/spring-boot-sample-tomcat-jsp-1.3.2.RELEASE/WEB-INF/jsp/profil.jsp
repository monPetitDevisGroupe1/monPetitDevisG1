<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Profil</title>
</head>
<body>
<div style = "float: left;">
    <form id="form" action="<c:url value='/private/profil.update'/>" method="GET">
        <table>
            <tr>
                <td>Identifiant : </td><td><input type="text" name="username" value="${username}" /></td>
            </tr>
            <tr>
                <td>Mot de passe : </td><td><input type="password" name="password" value="" /></td>
            </tr>
            <tr>
                <td>Nom : </td><td><input type="text" name="nom" value="${nom}" /></td>
            </tr>
            <tr>
                <td>Pr&eacute;nom : </td><td><input type="text" name="prenom" value="${prenom}" /></td>
            </tr>
            <tr><td>Date du permis : </td><td><input type="date" name="datepermis" value="${date_permis}" /> </td></tr>
        </table>
        <button type="submit" class="button button-block"/>C'est parti !</button>   <a href = "<c:url value='/private/dashboard'/>">Annuler</a>
    </form>
</div>
<div style = "float: left; margin-left: 50px;">
    <table>
        <tr>
            <td>Nombre devis en cours : </td>
            <td>${nbDevisEnCours}</td>
        </tr>
        <tr>
            <td>Nombre devis finis : </td>
            <td>${nbDevisFinis}</td>
        </tr>
        <tr>
            <td>Nombre devis total : </td>
            <td>${nbDevis}</td>
        </tr>

    </table>
</div>
</body>
</html>
