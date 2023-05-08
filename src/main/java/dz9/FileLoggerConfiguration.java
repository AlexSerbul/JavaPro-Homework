package dz9;

import java.io.File;
import java.io.IOException;

public class FileLoggerConfiguration {
    private final File file;
    private final LoggingLevel level;
    private final long maxFileSize;
    private final String format;

    public FileLoggerConfiguration(String path, LoggingLevel level, long maxSize, String format) throws IOException {
        this.file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if(!file.exists()){
            file.createNewFile();
        }
        this.level = level;
        this.maxFileSize = maxSize;
        this.format = format;
    }

    public File getFile() {
        return file;
    }
    public LoggingLevel getLevel() {
        return level;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getFormat() {
        return format;
    }
}
