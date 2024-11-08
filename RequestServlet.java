import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int userId = getUserId(username);
        int softwareId = Integer.parseInt(request.getParameter("softwareId"));
        String accessType = request.getParameter("accessType");
        String reason = request.getParameter("reason");

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_management", "postgres", "password");
            String sql = "INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, 'Pending')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setInt(2, softwareId);
            stmt.setString(3, accessType);
            stmt.setString(4, reason);
            stmt.executeUpdate();
            conn.close();
            response.sendRedirect("requestAccess.jsp?success=Request submitted");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("requestAccess.jsp?error=Submission failed");
        }
    }

    private int getUserId(String username) {
        // Mock method for demonstration purposes.
        // Retrieve user ID from the database based on the username.
        // Use a database query to find the correct user ID.
        return 1; // Example user ID, replace with actual lookup code.
    }
}
