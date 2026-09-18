import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger {

    private static final String FILE = "campus_log.txt";

    public static void log(String message) {
        try (FileWriter writer = new FileWriter(FILE, true)) {
            writer.write(new Date() + " - " + message + "\n");
        } catch (IOException e) {
            System.out.println("Couldn't write to log file.");
        }
    }
}
