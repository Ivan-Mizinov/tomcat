import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        response.setContentType("text/html");
        response.getWriter().println("<html>");
        response.getWriter().println("<h1>User Info</h1>");
        if (username != null) {
            response.getWriter().println("<p>Username: " + username + "</p>");
        } else {
            response.getWriter().println("<p>User was not found</p>");
        }
        response.getWriter().println("</html>");
    }
}
