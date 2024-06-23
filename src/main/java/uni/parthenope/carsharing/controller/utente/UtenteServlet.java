package uni.parthenope.carsharing.controller.utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uni.parthenope.carsharing.model.Utente;
import uni.parthenope.carsharing.repository.UtenteRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/cliente")
public class UtenteServlet extends HttpServlet {
    private UtenteRepository clienteRepository;

    @Override
    public void init() throws ServletException {
        clienteRepository = new UtenteRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Utente> clienti = clienteRepository.getAll();
            request.setAttribute("clienti", clienti);
            request.getRequestDispatcher("listaClienti.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errore", e.getMessage());
            request.getRequestDispatcher("errore.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tessera = request.getParameter("tessera");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");

        Utente cliente = new Utente();
        cliente.setTessera(tessera);
        cliente.setNome(nome);
        cliente.setCognome(cognome);

        try {
            clienteRepository.save(cliente);

            response.sendRedirect("/cliente");
        } catch (Exception e) {
            request.setAttribute("errore", e.getMessage());
            request.getRequestDispatcher("errore.jsp").forward(request, response);
        }
    }
}
