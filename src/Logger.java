import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class Logger {
    private static Logger log;
    private final String pathLog = "log.txt";

    public Logger() throws IOException {
        new FileWriter(pathLog, false);
    }

    public static synchronized Logger getLogger() throws IOException {
        if (log == null)
            log = new Logger();
        return log;
    }

    public void log(String str) throws IOException {
        Date date = new Date();
        Files.writeString(Paths.get(pathLog), date + " " + str + "\n", StandardOpenOption.APPEND);
    }
}