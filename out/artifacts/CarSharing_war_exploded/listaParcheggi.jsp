<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Parcheggi</title>
</head>
<body>
<h1>Lista Parcheggi</h1>
<c:if test="${not empty parcheggi}">
    <table>
        <tr>
            <th>Nome</th>
            <th>Indirizzo</th>
            <th>Capacità Auto</th>
            <th>Orario Apertura</th>
            <th>Orario Chiusura</th>
            <th>Tariffa Oraria</th>
        </tr>
        <c:forEach var="parcheggio" items="${parcheggi}">
            <tr>
                <td>${parcheggio.nome}</td>
                <td>${parcheggio.indirizzo}</td>
                <td>${parcheggio.capacitaAuto}</td>
                <td>${parcheggio.orarioApertura}</td>
                <td>${parcheggio.orarioChiusura}</td>
                <td>${parcheggio.tariffaOraria}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty parcheggi}">
    <p>Nessun parcheggio trovato.</p>
</c:if>
<c:if test="${not empty errore}">
    <p>${errore}</p>
</c:if>
</body>
</html>
