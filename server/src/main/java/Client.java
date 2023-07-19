import java.net.Socket;
import java.time.LocalDateTime;

public class Client {
    private Socket socket;
    private String name;

    private LocalDateTime connectionTime;

    public Client(Socket socket, String name, LocalDateTime time) {
        this.socket = socket;
        this.name = name;
        this.connectionTime = time;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getConnectionTime() {
        return connectionTime;
    }
}
