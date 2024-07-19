<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modifica Utente</title>
    <link rel="stylesheet" href="css/style.css"> <!-- Assicurati di includere il tuo CSS qui -->
</head>
<body>
<h1>Modifica Utente</h1>
<form action="modificaUtente" method="post">
    <input type="hidden" name="tessera" value="${utente.tessera}">

    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" value="${utente.nome}" required><br><br>

    <label for="cognome">Cognome:</label>
    <input type="text" id="cognome" name="cognome" value="${utente.cognome}" required><br><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="${utente.email}"><br><br>

    <button type="submit">Salva Modifiche</button>
</form>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
<c:if test="${not empty message}">
    <p style="color: green;">${message}</p>
</c:if>
</body>
</html>
