<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Profil</title>
</head>
<body>
<form id="form" action="/profil.update" method="POST">
    <table>
        <tr>
            <td>Nom : </td><td><input type="text" name="username" value="${nom}" /></td>
        </tr>
        <tr>
            <td>Pr&eacute;nom : </td><td><input type="text" name="username" value="${prenom}" /></td>
        </tr>
    </table>
    <div class="submit-container">
        <input value="Enregistrer" name="submit" type="submit" class="submit-btn"/>
    </div>
</form>

</body>
</html>
