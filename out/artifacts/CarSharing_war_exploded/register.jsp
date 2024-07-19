<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione al Servizio CarSharing</title>
    <link rel="stylesheet" type="text/css" href="percorso/al/tuo/file/css.css">
</head>
<body>
<h1>Registrazione al Servizio CarSharing</h1>
<div class="form-container">
    <form action="register" method="post">
        <label for="tessera">Tessera:</label>
        <input type="text" id="tessera" name="tessera" required>

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="quotaAnnuale">Quota Annuale:</label>
        <input type="number" id="quotaAnnuale" name="quotaAnnuale" required>

        <button type="submit">Registrati</button>
    </form>

    <%
        String message = (String) request.getAttribute("message");
        String error = (String) request.getAttribute("error");
        if (message != null) {
    %>
    <p style="color: green;"><%= message %></p>
    <%
    } else if (error != null) {
    %>
    <p style="color: red;"><%= error %></p>
    <%
        }
    %>
</div>
</body>
</html>
