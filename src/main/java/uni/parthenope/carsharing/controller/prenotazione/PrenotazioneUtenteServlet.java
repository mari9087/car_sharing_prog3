package uni.parthenope.carsharing.controller.prenotazione;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uni.parthenope.carsharing.model.Prenotazione;
import uni.parthenope.carsharing.model.Utente;
import uni.parthenope.carsharing.repository.PrenotazioneRepository;
import uni.parthenope.carsharing.repository.UtenteRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/prenotazioneUtente")
public class PrenotazioneUtenteServlet extends HttpServlet {
    private final PrenotazioneRepository prenotazioneRepository = new PrenotazioneRepository();
    private final UtenteRepository utenteRepository = new UtenteRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tesseraUtente = req.getParameter("tessera");

        try{
            Utente utente = utenteRepository.getById(tesseraUtente);
            if(utente != null){
            List <Prenotazione> prenotazioni = prenotazioneRepository.getByUtente(utente);
            req.setAttribute("prenotazioni", prenotazioni);
            req.getRequestDispatcher("/listaPrenotazioniUtente.jsp").forward(req, resp);
            }else{
                throw new Exception("Utente non trovato");
            }
        }
        catch(Exception e){
            req.setAttribute("errore", e.getMessage());
            req.getRequestDispatcher("/errore.jsp").forward(req, resp);
        }
    }


}
