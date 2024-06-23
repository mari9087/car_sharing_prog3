package uni.parthenope.carsharing.controller.utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uni.parthenope.carsharing.model.Utente;
import uni.parthenope.carsharing.repository.UtenteRepository;

import java.io.IOException;

@WebServlet("/register")
public class IscrizioneServlet extends HttpServlet {

    private UtenteRepository utenteRepository = new UtenteRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tessera = req.getParameter("tessera");
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String email = req.getParameter("email");
        double quotaAnnuale = Double.parseDouble(req.getParameter("quotaAnnuale"));

        Utente utente = new Utente();
        utente.setTessera(tessera);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setEmail(email);
        utente.setQuotaAnnuale(quotaAnnuale);

        try {
            utenteRepository.save(utente);
            req.setAttribute("message", "Registrazione avvenuta con successo!");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", "Registrazione fallita: " + e.getMessage());
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
