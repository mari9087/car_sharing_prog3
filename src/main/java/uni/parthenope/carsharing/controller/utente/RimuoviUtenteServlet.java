package uni.parthenope.carsharing.controller.utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uni.parthenope.carsharing.repository.UtenteRepository;

import java.io.IOException;

@WebServlet("/rimuoviUtente")
public class RimuoviUtenteServlet extends HttpServlet {

    private UtenteRepository utenteRepository = new UtenteRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tessera = req.getParameter("tessera");

        try {
            utenteRepository.delete(tessera);
            req.setAttribute("message", "Utente rimosso con successo!");
            req.getRequestDispatcher("/listaUtenti.jsp").forward(req, resp); // Redirect to list page
        } catch (Exception e) {
            req.setAttribute("error", "Errore durante la rimozione dell'utente: " + e.getMessage());
            req.getRequestDispatcher("/errore.jsp").forward(req, resp);
        }
    }
}
