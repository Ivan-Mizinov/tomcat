import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebFilter("/*")
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println(("LoggingFilter initialized"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String uri = req.getRequestURI();
        String remoteAddr = request.getRemoteAddr();
        Date date = new Date();

        System.out.println("----------------------------------------");
        System.out.println("Время запроса: " + date);
        System.out.println("URL: " + uri);
        System.out.println("IP-адрес: " + remoteAddr);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}
