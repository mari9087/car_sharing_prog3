package uni.parthenope.carsharing.controller.utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uni.parthenope.carsharing.model.Utente;
import uni.parthenope.carsharing.repository.UtenteRepository;

import java.io.IOException;

@WebServlet("/modificaUtente")
public class ModificaUtenteServlet extends HttpServlet {

    private UtenteRepository utenteRepository = new UtenteRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tessera = req.getParameter("tessera");

        try {
            Utente utente = utenteRepository.getById(tessera);
            req.setAttribute("utente", utente);
            req.getRequestDispatcher("/modificaUtente.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", "Errore nel recupero dell'utente: " + e.getMessage());
            req.getRequestDispatcher("/errore.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tessera = req.getParameter("tessera");
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String email = req.getParameter("email");

        Utente utente = new Utente();
        utente.setTessera(tessera);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setEmail(email);

        try {
            utenteRepository.update(utente);
            req.setAttribute("message", "Utente modificato con successo!");
            req.getRequestDispatcher("/modificaUtente.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", "Errore durante la modifica dell'utente: " + e.getMessage());
            req.getRequestDispatcher("/modificaUtente.jsp").forward(req, resp);
        }
    }
}
