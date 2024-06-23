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

@WebServlet("/lateUsers")
public class LateUsersServlet extends HttpServlet {
    private UtenteRepository userRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        userRepository = new UtenteRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Utente> lateUsers = userRepository.findLateUsers();
        request.setAttribute("lateUsers", lateUsers);
        request.getRequestDispatcher("/lateUsers.jsp").forward(request, response);
    }
}
