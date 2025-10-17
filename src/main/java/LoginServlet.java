import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private Map<String, String> users;

    @Override
    public void init() {
        users = new HashMap<>();
        users.put("user1", "123");
        users.put("user2", "1234");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html>");
        response.getWriter().println("<form method=\"post\">");
        response.getWriter().println("Username: <input type=\"text\" name=\"username\"><br>");
        response.getWriter().println("Password: <input type=\"password\" name=\"password\"><br>");
        response.getWriter().println("<input type=\"submit\" value=\"Login\">");
        response.getWriter().println("</form>");
        response.getWriter().println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (users.containsKey(username) && users.get(username).equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);

            Cookie userCookie = new Cookie("username", username);
            response.addCookie(userCookie);

            response.sendRedirect("welcome");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<html><body>Invalid credentials</body></html>");
        }
    }
}
