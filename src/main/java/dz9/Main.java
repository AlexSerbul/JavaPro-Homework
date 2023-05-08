package dz9;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

//        LoggingLevel level = LoggingLevel.INFO;
//        String path = "./Logs/log";
//        long size = 500;
//        String format = "[TIME] | [LEVEL] | Повідомлення: [MESSAGE]";

        try {

//            FileLoggerConfiguration configuration = new FileLoggerConfiguration(path, level,size,format);

            File file = new File("Config");
            FileLoggerConfiguration configuration = new FileLoggerConfigurationLoader().load(file);
            FileLogger fileLogger = new FileLogger(configuration);

            for(int i=0;i<100;i++){
                fileLogger.info("тест "+i);
            }

        }catch (IOException e){
            System.err.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
