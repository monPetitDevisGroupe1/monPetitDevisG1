<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<html>
<head>
    <title>Profil</title>
</head>
<body>
<form id="form" action="<c:url value='/private/profil.update'/>" method="GET">
    <table>
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

</body>
</html>
