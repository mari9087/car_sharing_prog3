<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Car Sharing - Home</title>
  <meta charset="UTF-8">
  <script>
    function validateForm() {
      var username = document.getElementById("username").value;
      var password = document.getElementById("password").value;
      if (username === "" || password === "") {
        alert("Username e password sono obbligatori.");
        return false;
      }
      return true;
    }
  </script>
</head>
<body>
<h1>Car Sharing - Home</h1>

<%-- Form di login
 <form action="login" method="post" onsubmit="return validateForm()">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br><br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>
  <input type="submit" value="Accedi">
</form>


<%-- Visualizza contenuto diverso in base al ruolo dell'utente

   String ruolo = (String) session.getAttribute("ruolo");
  if (ruolo != null) {

    if (ruolo.equals("amministratore")) {--%>


<h2>Pannello di controllo amministratore</h2>
<ul>
  <li><a href="aggiungiVeicolo.jsp">Aggiungi veicolo</a></li>
  <li><a href="modificaVeicolo.jsp">Modifica veicolo</a></li>
  <li><a href="ridistribuisciVeicoli.jsp">Ridistribuisci veicoli</a></li>
  <li><a href="lateUsers.jsp">Utenti in ritardo</a></li>
  <li><a href="listaPrenotazioni.jsp">Elenco prenotazioni</a></li>
  <li><a href="listaVeicoli.jsp">Elenco veicoli</a></li>
  <li><a href="listaUtenti.jsp">Elenco utenti</a></li>
  <li><a href = "listaParcheggi.jsp"> Elenco Parcheggi</a></li>
  <li><a href = "aggiungiParcheggio.jsp">Aggiungi Parcheggio</a></li>
</ul>

} else if (ruolo.equals("utente")) {

<h2>Pannello di controllo utente</h2>
<ul>
  <li><a href="aggiungiPrenotazione.jsp">Prenota un veicolo</a></li>

  <li><a href="modificaUtente.jsp">Modifica profilo</a></li>
</ul>

  if (!"true".equals(session.getAttribute("registrato"))) {

<p>Non hai ancora effettuato la registrazione! <a href="register.jsp">Registrati ora</a></p>
      }
    }
  }

</body>
</html>
