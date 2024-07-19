package uni.parthenope.carsharing.controller.registrazione;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if(userExists(username)){
            req.setAttribute("error", "Username già esistente");
            req.getRequestDispatcher("register.jsp").forward(req, resp);

        }
        // Crea un nuovo utente

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing", "root", "password")) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO utenti (username, password, email) VALUES (?, ?, ?)");
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            req.setAttribute("errore", "Errore durante la registrazione");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        // Registra l'utente e reindirizza alla pagina di login
        req.getSession().setAttribute("registrato", "true");
        resp.sendRedirect("login.jsp");
    }

    private boolean userExists(String username) {
        // Verifica se l'utente esiste già nel database
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:5432/car_sharing", "postgres", "postgres")) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utenti WHERE username = ?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            return result.next();
        } catch (SQLException e) {

            return false;

        }

    }
}
