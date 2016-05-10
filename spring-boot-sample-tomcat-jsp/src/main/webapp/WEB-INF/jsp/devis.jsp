<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 06/04/2016
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creation de Devis</title>
</head>
<body>

    <div>
        <h2>Creation d'un devis</h2>
    </div>
        <form action="/private/devis.create" method="GET">
            <h1>Creer un devis</h1>
            <div>
                <div>
                    Nom du devis :
                    <input type="text" name="nom_devis" >
                </div>
                <div>
                    Type du devis :
                    <select name="type_devis">
                        <option value="voiture" selected>Voiture</option>
                        <option value="habitation">Habitation</option>
                    </select>
                </div>
            </div>
            <button type="submit" value="voiture">Nouveau Devis</button>
        </form>

</body>
</html>
