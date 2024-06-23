<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Utenti in Ritardo</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>Utenti in Ritardo</h1>
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Data Prenotazione</th>
            <th>Data Scadenza</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${lateUsers}">
            <tr>
                <td>${utente.id}</td>
                <td>${utente.nome}</td>
                <td>${utente.email}</td>
                <td>${utente.dataPrenotazione}</td>
                <td>${utente.dataScadenza}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
