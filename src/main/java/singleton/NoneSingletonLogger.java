package singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @create: 2020/3/6
 * @author: altenchen
 */
public class NoneSingletonLogger {

    private FileWriter writer;

    public NoneSingletonLogger() {
        File file = new File("/Users/chenchen/bitnei/log/test.log");
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

