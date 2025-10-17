import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger {
    private PrintWriter writer;

    public FileLogger() {
        try {
            writer = new PrintWriter(new FileWriter("logs.log", true));
        } catch (IOException e) {
            System.err.println("Ошибка при создании лог-файла: " + e.getMessage());
        }
    }

    public void log(String message) {
        if (writer == null) {
            System.err.println("Writer не инициализирован! Невозможно записать лог.");
            return;
        }
        try {
            writer.println(message);
            writer.flush();
        } catch (Exception e) {
            System.err.println("Ошибка при попытке записать лог: " + e.getMessage());
        }
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
