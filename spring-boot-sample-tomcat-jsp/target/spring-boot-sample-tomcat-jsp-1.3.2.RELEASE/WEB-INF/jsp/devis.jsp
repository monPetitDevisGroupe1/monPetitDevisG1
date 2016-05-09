<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 06/04/2016
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creation de Devis</title>
</head>
<body>

<form action="/devisValidate" methode="POST">

    <div>
        <h2>Listes des devis</h2>
        <p>${sessionScope.id_user}${sessionScope.nom}${sessionScope.prenom}</p>


    </div>


        <form action="<c:url value='/wizard'/>" method="GET">
            <h1>Creer un devis</h1>
            <input type="hidden" name="id_popo" value="<%=request.getParameter("id_devis") %>" >
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

            <button type="submit" value="voiture">Nouveau Devis Voiture</button>
        </form>


</form>

</body>
</html>
