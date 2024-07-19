<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Parcheggio</title>
</head>
<body>
<h1>Aggiungi Parcheggio</h1>
<form action="parcheggio" method="post">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required><br>
    <label for="indirizzo">Indirizzo:</label>
    <input type="text" id="indirizzo" name="indirizzo" required><br>
    <label for="capacitaAuto">Capacità Auto:</label>
    <input type="number" id="capacitaAuto" name="capacitaAuto" required><br>
    <label for="orarioApertura">Orario Apertura (es. 2024-07-09T08:00):</label>
    <input type="text" id="orarioApertura" name="orarioApertura" required><br>
    <label for="orarioChiusura">Orario Chiusura (es. 2024-07-09T20:00):</label>
    <input type="text" id="orarioChiusura" name="orarioChiusura" required><br>
    <label for="tariffaOraria">Tariffa Oraria:</label>
    <input type="text" id="tariffaOraria" name="tariffaOraria" required><br>
    <input type="submit" value="Aggiungi Parcheggio">
</form>
</body>
</html>
