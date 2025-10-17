import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Date;

@WebListener
public class UserActivityListener implements HttpSessionListener, HttpSessionAttributeListener, ServletContextListener {
    private  FileLogger fileLogger;

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        String name = se.getName();
        Object value = se.getValue();
        Date date = new Date();

        if ("username".equals(name)) {
            fileLogger.log("----------------------------------------");
            fileLogger.log("Пользователь вошел в систему: " + date);
            fileLogger.log("Имя пользователя: " + value);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        String name = se.getName();
        Object value = se.getValue();
        Date date = new Date();

        if ("username".equals(name)) {
            fileLogger.log("----------------------------------------");
            fileLogger.log("Пользователь вышел из системы: " + date);
            fileLogger.log("Имя пользователя: " + value);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        Date date = new Date();

        fileLogger.log("----------------------------------------");
        fileLogger.log("Сессия создана: " + date);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Date date = new Date();

        fileLogger.log("----------------------------------------");
        fileLogger.log("Сессия уничтожена: " + date);
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            fileLogger = new FileLogger();
        } catch (Exception e) {
            System.err.println("Ошибка при инициализации fileLogger: " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (fileLogger != null) {
            try {
                fileLogger.close();
            } catch (Exception e) {
                System.err.println("Ошибка при закрытии fileLogger: " + e.getMessage());
            }
        }
    }
}
