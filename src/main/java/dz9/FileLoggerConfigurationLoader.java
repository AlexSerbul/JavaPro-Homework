package dz9;

import java.io.*;

public class FileLoggerConfigurationLoader {

    public FileLoggerConfiguration load(File file) throws IOException {

        if(file == null){
            throw new IllegalArgumentException("No file was given!");
        }

        String path = "./Logs/log";
        LoggingLevel level = LoggingLevel.INFO;
        long maxSize = 10000;
        String format = "[TIME] | [LEVEL] | Повідомлення: [MESSAGE]\n";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){

            String line;

            while ((line = reader.readLine()) != null){
                String[] lines = line.split(":");

                String value = lines[1].trim();

                switch (lines[0]) {
                    case "PATH" -> path = value;
                    case "LEVEL" -> level = LoggingLevel.valueOf(value);
                    case "MAX_SIZE" -> maxSize = Long.parseLong(value);
                    case "FORMAT" -> format = value;
                }

                if(file == null || level == null || format == null) {
                    throw new  IllegalArgumentException("Invalid configuration file loaded!");
                }
            }
        }

        return new FileLoggerConfiguration(path,level,maxSize,format);
    }
}
