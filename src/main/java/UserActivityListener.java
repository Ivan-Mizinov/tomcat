import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Date;

@WebListener
public class UserActivityListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        String name = se.getName();
        Object value = se.getValue();
        Date date = new Date();

        if ("username".equals(name)) {
            System.out.println("----------------------------------------");
            System.out.println("Пользователь вошел в систему: " + date);
            System.out.println("Имя пользователя: " + value);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        String name = se.getName();
        Object value = se.getValue();
        Date date = new Date();

        if ("username".equals(name)) {
            System.out.println("----------------------------------------");
            System.out.println("Пользователь вышел из системы: " + date);
            System.out.println("Имя пользователя: " + value);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        Date date = new Date();

        System.out.println("----------------------------------------");
        System.out.println("Сессия создана: " + date);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Date date = new Date();

        System.out.println("----------------------------------------");
        System.out.println("Сессия уничтожена: " + date);
    }
}
