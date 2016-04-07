<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/user/save" method="post" modelAttribute="user">
        <form:label path="nom">Nom</form:label>
        <form:input path="nom" />
        <input type="submit" value="Go!" />
    </form:form>
</body>
</html>
