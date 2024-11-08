import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApprovalServlet")
public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String action = request.getParameter("action"); // "Approve" or "Reject"

        String newStatus = action.equals("Approve") ? "Approved" : "Rejected";

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_management", "postgres", "password");
            String sql = "UPDATE requests SET status = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, newStatus);
            stmt.setInt(2, requestId);
            stmt.executeUpdate();
            conn.close();
            response.sendRedirect("pendingRequests.jsp?success=Request " + newStatus.toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("pendingRequests.jsp?error=Operation failed");
        }
    }
}
