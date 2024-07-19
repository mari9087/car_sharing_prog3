<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prenotazioni Utente</title>
</head>
<body>
<h1>Prenotazioni</h1>
<c:if test="${not empty prenotazioni}">
    <table>
        <tr>
            <th>Veicolo</th>
            <th>Data</th>
            <th>Azione</th>
        </tr>
        <c:forEach var="prenotazione" items="${prenotazioni}">
            <tr>
                <td>${prenotazione.veicolo.targa}</td>
                <td>${prenotazione.data}</td>
                <td>
                    <form method="post" action="prenotazioneUtente">
                        <input type="hidden" name="prenotazioneId" value="${prenotazione.id}">
                        <input type="hidden" name="tesseraUtente" value="${prenotazione.utente.tessera}">
                        <input type="submit" value="Cancella">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty prenotazioni}">
    <p>Nessuna prenotazione trovata.</p>
</c:if>
<c:if test="${not empty errore}">
    <p>${errore}</p>
</c:if>
</body>
</html>
