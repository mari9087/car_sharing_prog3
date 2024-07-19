package uni.parthenope.carsharing.controller.parcheggio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uni.parthenope.carsharing.model.Parcheggio;
import uni.parthenope.carsharing.repository.ParcheggioRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "ParcheggioServlet", urlPatterns = {"/parcheggio"})
public class ParcheggioServlet extends HttpServlet {

    private final ParcheggioRepository parcheggioRepository = new ParcheggioRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Parcheggio> parcheggi = parcheggioRepository.getAll();
            request.setAttribute("parcheggi", parcheggi);
            request.getRequestDispatcher("/listaParcheggi.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errore", e.getMessage());
            request.getRequestDispatcher("/errore.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Estrazione dei parametri dal modulo e conversione dei dati
            String nome = request.getParameter("nome");
            String indirizzo = request.getParameter("indirizzo");
            int capacitaAuto = Integer.parseInt(request.getParameter("capacitaAuto"));
            LocalDateTime orarioApertura = LocalDateTime.parse(request.getParameter("orarioApertura"), DateTimeFormatter.ISO_DATE_TIME);
            LocalDateTime orarioChiusura = LocalDateTime.parse(request.getParameter("orarioChiusura"), DateTimeFormatter.ISO_DATE_TIME);
            BigDecimal tariffaOraria = new BigDecimal(request.getParameter("tariffaOraria"));

            //debug dei parametri ricevuti
            System.out.println("Nome: " + nome);
            System.out.println("Indirizzo: " + indirizzo);
            System.out.println("Capacità Auto: " + capacitaAuto);
            System.out.println("Orario Apertura: " + orarioApertura);
            System.out.println("Orario Chiusura: " + orarioChiusura);
            System.out.println("Tariffa Oraria: " + tariffaOraria);

            //creazione dell'oggetto Parcheggio e salvataggio
            Parcheggio parcheggio = new Parcheggio();
            parcheggio.setNome(nome);
            parcheggio.setIndirizzo(indirizzo);
            parcheggio.setCapacitaAuto(capacitaAuto);
            parcheggio.setOrarioApertura(orarioApertura);
            parcheggio.setOrarioChiusura(orarioChiusura);
            parcheggio.setTariffaOraria(tariffaOraria);

            parcheggioRepository.save(parcheggio);

            response.sendRedirect("/parcheggio");
        } catch (Exception e) {
            //aggiunta di un messaggio di debug per la gestione degli errori
            e.printStackTrace();
            request.setAttribute("errore", "Errore durante l'aggiunta del parcheggio: " + e.getMessage());
            request.getRequestDispatcher("/errore.jsp").forward(request, response);
        }
    }
}
