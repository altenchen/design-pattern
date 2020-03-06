package singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @create: 2020/3/6
 * @author: altenchen
 */
public class Logger {

    private FileWriter writer;

    private static final Logger instance = new Logger();

    private Logger() {
        File file = new File("/Users/chenchen/bitnei/log/test.log");
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
