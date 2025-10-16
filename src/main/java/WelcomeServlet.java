import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Cookie[] cookies = request.getCookies();
        String usernameFromCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    usernameFromCookie = cookie.getValue();
                    break;
                }
            }
        }

        response.getWriter().println("<html>");
        response.getWriter().println("<h1>Welcome!</h1>");
        if (usernameFromCookie != null) {
            response.getWriter().println("<p>Welcome back, " + usernameFromCookie + "!</p>");
        }
        response.getWriter().println("<a href=\"userinfo\">View User Info</a>");
        response.getWriter().println("</html>");
    }
}
