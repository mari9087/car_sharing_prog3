<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista Utenti</title>
    <link rel="stylesheet" href="css/style.css"> <!-- Assicurati di includere il tuo CSS qui -->
</head>
<body>
<h1>Lista Utenti</h1>
<table>
    <thead>
    <tr>
        <th>Tessera</th>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Email</th>
        <th>Data Scadenza</th>
        <th>Quota Annuale</th>
        <th>Azioni</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="utente" items="${clienti}">
        <tr>
            <td>${utente.tessera}</td>
            <td>${utente.nome}</td>
            <td>${utente.cognome}</td>
            <td>${utente.email}</td>
            <td>${utente.dataScadenza}</td>
            <td>${utente.quotaAnnuale}</td>
            <td>
                <a href="modificaUtente?tessera=${utente.tessera}">Modifica</a> |
                <form action="rimuoviUtente" method="post">
                    <input type="hidden" name="tessera" value="${utente.tessera}">
                    <button type="submit">Rimuovi</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${not empty errore}">
    <p style="color: red;">${errore}</p>
</c:if>
<c:if test="${not empty message}">
    <p style="color: green;">${message}</p>
</c:if>
</body>
</html>
