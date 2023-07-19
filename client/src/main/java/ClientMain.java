import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost",8080)){
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            //Thread to read from the server
            Thread thread_read = new Thread(new ReadFromServer(inputStream));
            thread_read.start();

            //Writing to the server
            while (true){
                String message = scanner.nextLine();

                if(message.equals("-exit")){
                    outputStream.writeUTF(message);
                    outputStream.flush();
                    break;
                }

                //-file C:\Users\kars\Desktop\image.jpg
                if(message.startsWith("-file")){
                    File file = new File(message.replace("-file","").trim());

                    byte[] buffer = new byte[(int) file.length()];

                    IOUtils.readFully(new FileInputStream(file),buffer);

                    outputStream.writeUTF("-file");

                    outputStream.writeUTF(file.getName());
                    outputStream.writeLong(file.length());
                    outputStream.write(buffer);

                    outputStream.flush();
                    continue;
                }

                outputStream.writeUTF(message);
                outputStream.flush();
            }

        }catch (SocketException e){
            System.err.println("Server closed!");
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    private void HandleMessages(String message){

    }

    private static class ReadFromServer implements Runnable{
        DataInputStream inputStream;
        public ReadFromServer(DataInputStream inputStream){
            this.inputStream = inputStream;
        }
        @Override
        public void run() {
            try {
                while (true){
                    String serverResponse = inputStream.readUTF();
                    System.out.println(serverResponse);
                }
            }catch (SocketException e){
                System.out.println("You left the chat!");
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
