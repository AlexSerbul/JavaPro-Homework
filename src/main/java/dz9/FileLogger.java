package dz9;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private final FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }
    public void info(String msg) throws IOException, InterruptedException {
        if(configuration.getLevel()==LoggingLevel.INFO || configuration.getLevel()==LoggingLevel.DEBUG){
            log(msg);
        }else {
            System.err.println("Ваш рівень доступу недостатній!");
        }
    }
    public void debug(String msg) throws IOException, InterruptedException {
        if(configuration.getLevel()==LoggingLevel.DEBUG){
            log(msg);
        }else {
            System.err.println("Ваш рівень доступу недостатній!");
        }
    }
    private String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    private void log(String msg) throws IOException, InterruptedException {
        String messageWithFormat = configuration.getFormat();
        messageWithFormat = messageWithFormat.replace("[TIME]",getTime());
        messageWithFormat = messageWithFormat.replace("[LEVEL]",configuration.getLevel().name());
        messageWithFormat = messageWithFormat.replace("[MESSAGE]",msg);
        messageWithFormat = messageWithFormat + "\n";

        if(configuration.getFile().length() >= configuration.getMaxFileSize()){

            configuration.getFile().renameTo(new File(configuration.getFile().getPath() + getTime()));
            Thread.sleep(1000);
            //Я встретился с проблемой, того что при слишком быстром выполнении кода, имя файла (завязаное на времени)
            //не мянялось, из за чего программа продолжала писать в тот же файл.
            //Так что я решил что бы избежать этого, при создании нового файла просто ждать по 1 секунде, что бы название изменилось.


//            throw new FileMaxSizeReachedException("Максимальний розмір файлу перевищено! Буде створено новий файл");
        }

        OutputStream os = new FileOutputStream(configuration.getFile(),true);
        try {
            os.write(messageWithFormat.getBytes());
        }catch (IOException e){
            throw e;
        }finally {
            os.close();
        }
    }
}
