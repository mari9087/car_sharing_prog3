package uni.parthenope.carsharing.controller.veicolo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uni.parthenope.carsharing.repository.VeicoloRepository;

import java.io.IOException;

@WebServlet("/RimuoviVeicoloServlet")
public class RimuoviVeicoloServlet extends HttpServlet {
    private VeicoloRepository veicoloRepository;

    public RimuoviVeicoloServlet() {
        this.veicoloRepository = new VeicoloRepository();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String targa = request.getParameter("targa");

        try {
            veicoloRepository.deleteByTarga(targa);
        } catch (Exception e) {
            e.printStackTrace();
            // Gestione dell'errore (puoi personalizzare il messaggio di errore e la pagina di destinazione)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Errore nella rimozione del veicolo");
            return;
        }

        // Reindirizzamento dopo la rimozione del veicolo
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
