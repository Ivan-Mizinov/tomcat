import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    private FileLogger fileLogger;

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println(("LoggingFilter initialized"));
        try {
            fileLogger = new FileLogger();
        } catch (Exception e) {
            System.err.println("Ошибка при инициализации FileLogger: " + e.getMessage());
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String uri = req.getRequestURI();
        String remoteAddr = request.getRemoteAddr();
        Date date = new Date();

        fileLogger.log("----------------------------------------");
        fileLogger.log("Время запроса: " + date);
        fileLogger.log("URL: " + uri);
        fileLogger.log("IP-адрес: " + remoteAddr);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
        fileLogger.close();
    }
}
