<%@ page import="uni.parthenope.carsharing.model.Utente" %>
<%@ page import="java.util.List" %>
<%@ page import="uni.parthenope.carsharing.model.Utente" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Admin Home - Car Sharing</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <style>
    body {
      padding-top: 50px;
    }
    .container {
      max-width: 800px;
    }
  </style>
</head>
<body>
<div class="container">
  <h1 class="text-center">Car Sharing Admin Dashboard</h1>

  <div class="card mt-4">
    <div class="card-header">
      <h2>Aggiungi una nuova auto</h2>
    </div>
    <div class="card-body">
      <form action="addCar" method="post">
        <div class="form-group">
          <label for="model">Modello</label>
          <input type="text" class="form-control" id="model" name="model" required>
        </div>
        <div class="form-group">
          <label for="parkingId">ID Parcheggio</label>
          <input type="text" class="form-control" id="parkingId" name="parkingId" required>
        </div>
        <button type="submit" class="btn btn-primary">Aggiungi</button>
      </form>
    </div>
  </div>

  <div class="card mt-4">
    <div class="card-header">
      <h2>Prenota Auto per Utente</h2>
    </div>
    <div class="card-body">
      <form action="bookCar" method="post">
        <div class="form-group">
          <label for="carId">ID Auto</label>
          <input type="text" class="form-control" id="carId" name="carId" required>
        </div>
        <div class="form-group">
          <label for="userId">ID Utente</label>
          <input type="text" class="form-control" id="userId" name="userId" required>
        </div>
        <div class="form-group">
          <label for="startDate">Data Inizio</label>
          <input type="datetime-local" class="form-control" id="startDate" name="startDate" required>
        </div>
        <div class="form-group">
          <label for="endDate">Data Fine</label>
          <input type="datetime-local" class="form-control" id="endDate" name="endDate" required>
        </div>
        <button type="submit" class="btn btn-primary">Prenota</button>
      </form>
    </div>
  </div>

  <div class="card mt-4">
    <div class="card-header">
      <h2>Riconsegna Auto</h2>
    </div>
    <div class="card-body">
      <form action="returnCar" method="post">
        <div class="form-group">
          <label for="bookingId">ID Prenotazione</label>
          <input type="text" class="form-control" id="bookingId" name="bookingId" required>
        </div>
        <button type="submit" class="btn btn-primary">Riconsegna</button>
      </form>
    </div>
  </div>

  <div class="card mt-4">
    <div class="card-header">
      <h2>Utenti in Ritardo</h2>
    </div>
    <div class="card-body">
      <form action="lateUsers" method="get">
        <button type="submit" class="btn btn-danger">Visualizza Utenti in Ritardo</button>
      </form>
      <div id="lateUsersList" class="mt-3">
        <%
          List<Utente> lateUtentes = (List<Utente>) request.getAttribute("lateUsers");
          if (lateUtentes != null && !lateUtentes.isEmpty()) {
        %>
        <ul class="list-group">
          <% for (Utente utente : lateUtentes) { %>
          <li class="list-group-item"><%= utente.getNome() %> (<%= utente.getEmail() %>)</li>
          <% } %>
        </ul>
        <%
        } else {
        %>
        <p>Nessun utente in ritardo</p>
        <%
          }
        %>
      </div>
    </div>
  </div>

</div>
</body>
</html>
