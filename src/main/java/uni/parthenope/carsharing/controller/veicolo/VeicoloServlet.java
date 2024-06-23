package uni.parthenope.carsharing.controller.veicolo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/VeicoloServlet")
public class VeicoloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        String licensePlate = request.getParameter("licensePlate");
        String parkingLot = request.getParameter("parkingLot");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:5432/car_sharing", "postgres", "postgres");
            String query = "INSERT INTO veicoli (marca, modello, anno, targa)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, model);
            pstmt.setString(2, licensePlate);
            pstmt.setString(3, parkingLot);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }
}
