<!DOCTYPE html>
<html>
<head>
    <title>Aggiungi Nuova Auto</title>
</head>
<body>
<h1>Aggiungi Nuova Auto</h1>
<form action="AddCarServlet" method="post">
    <label for="model">Modello:</label>
    <input type="text" id="model" name="model" required><br><br>
    <label for="licensePlate">Targa:</label>
    <input type="text" id="licensePlate" name="licensePlate" required><br><br>
    <label for="parkingLot">Parcheggio:</label>
    <input type="text" id="parkingLot" name="parkingLot" required><br><br>
    <input type="submit" value="Aggiungi">
</form>
</body>
</html>