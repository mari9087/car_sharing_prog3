<%@ page import="com.gestionecampi.model.Campo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gestionecampi.repository.CampoRepository" %>
<%@ page import="com.gestionecampi.model.Cliente" %>
<%@ page import="com.gestionecampi.repository.ClienteRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prenota Veicolo</title>
    <link href="style.css" rel="stylesheet">
</head>
<body>
<%
    CampoRepository campoRepository = new CampoRepository();
    List<Campo> campi = campoRepository.getAll();
    String tessera = request.getParameter("tessera");
%>

<div class="form-container">
    <h1>Campi disponibili</h1>
    <form action="/prenotazione" method="POST">
        <ul>
            <%
                for (Campo campo : campi) {
            %>
            <li style="list-style-type: none;">
                <label class="radio-label">
                    <input type="radio" name="campo" value="<%= campo.getNumero() %>" required>
                    <%= campo.getTipoFondo() %>: Campo <%= campo.getNumero() %>
                </label>
            </li>
            <%
                }
            %>
        </ul>
        <input type="hidden" id="tessera" name="tessera" value="<%=tessera%>">
        <br>
        <label for="data">Data</label>
        <input required type="datetime-local" id="data" name="data">
        <br>
        <button type="submit">Prenota</button>
    </form>
</div>

</body>
</html>
