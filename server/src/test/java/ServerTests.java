import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServerTests {
    static Thread serverThread;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    @BeforeAll
    public static void startingServer() throws IOException {
        ServerMain serverMain = new ServerMain();
        serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String[] args = {"tests"};
                serverMain.main(args);
            }
        });
        serverThread.start();

        socket = new Socket("localhost",8080);

        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
    }
    @Test
    @Order(1)
    public void clientConnectionTest() throws IOException {
        assertEquals("Server: client-1 joined the chat!",inputStream.readUTF());
    }

    @Test
    @Order(2)
    public void sendingMessageTest() throws IOException {
        outputStream.writeUTF("Hello world!");
        assertEquals("client-1: Hello world!",inputStream.readUTF());
    }
    @Test
    @Order(3)
    public void sendingFileTest() throws IOException {
        String message = "-file C:\\Users\\kars\\Desktop\\image.jpg";
        File file = new File(message.replace("-file","").trim());

        byte[] buffer = new byte[(int) file.length()];

        IOUtils.readFully(new FileInputStream(file),buffer);

        outputStream.writeUTF("-file");

        outputStream.writeUTF(file.getName());
        outputStream.writeLong(file.length());
        outputStream.write(buffer);

        assertEquals("Server: client-1 sends a file!",inputStream.readUTF());
        assertEquals("Server: File received",inputStream.readUTF());
    }

    @Test
    @Order(4)
    public void exitTest() throws IOException {
        outputStream.writeUTF("-exit");
        String result = "";
        try {
            inputStream.readUTF();
        }catch (EOFException e) {
            result = "You left the chat!";
        }
        assertEquals("You left the chat!",result);
    }
}
