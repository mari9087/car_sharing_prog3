package uni.parthenope.carsharing.controller.prenotazione;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uni.parthenope.carsharing.model.Prenotazione;
import uni.parthenope.carsharing.model.Utente;
import uni.parthenope.carsharing.model.Veicolo;
import uni.parthenope.carsharing.repository.PrenotazioneRepository;
import uni.parthenope.carsharing.repository.UtenteRepository;
import uni.parthenope.carsharing.repository.VeicoloRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/prenotazione")
public class PrenotazioneServlet extends HttpServlet {

    private final PrenotazioneRepository prenotazioneRepository = new PrenotazioneRepository();
    private final UtenteRepository utenteRepository = new UtenteRepository();
    private final VeicoloRepository veicoloRepository = new VeicoloRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Prenotazione> prenotazioni = prenotazioneRepository.getAll();
            request.setAttribute("prenotazioni", prenotazioni);
            request.getRequestDispatcher("/prenotazioni.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errore", e.getMessage());
            request.getRequestDispatcher("/errore.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tesseraUtente = request.getParameter("tesseraUtente");
        String targaVeicolo = request.getParameter("targaVeicolo");
        LocalDateTime dataPrenotazione = LocalDateTime.now(); // Data e ora attuali

        try {
            Utente utente = utenteRepository.getById(tesseraUtente);
            Veicolo veicolo = veicoloRepository.getByTarga(targaVeicolo);

            if (utente == null || veicolo == null) {
                throw new Exception("Utente o veicolo non trovato.");
            }

            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setUtente(utente);
            prenotazione.setVeicolo(veicolo);
            prenotazione.setData(dataPrenotazione);

            prenotazioneRepository.save(prenotazione);

            response.sendRedirect("/prenotazione");
        } catch (Exception e) {
            request.setAttribute("errore", "Errore durante la prenotazione: " + e.getMessage());
            request.getRequestDispatcher("/errore.jsp").forward(request, response);
        }
    }
}
