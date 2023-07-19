import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerMain {

    public static void main(String[] args) {

        List<Client> clientList = new ArrayList<>();
        AtomicInteger client_id = new AtomicInteger(1);

        try (ServerSocket serverSocket = new ServerSocket(8080)){
            while (true) {
                //Creating new client
                Socket socket = serverSocket.accept();
                String name = "client-" + client_id.getAndIncrement();
                LocalDateTime time = LocalDateTime.now();
                Client client = new Client(socket,name,time);
                clientList.add(client);

                //Sending welcome message
                SendToAll("Server: " + name + " joined the chat!",clientList);

                //Creating new Thread for the new client
                ServerClientCommunication scc = new ServerClientCommunication(client,clientList);
                Thread thread = new Thread(scc);
                thread.start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    //Method to send message to all clients
    private static void SendToAll(String message, List<Client> clientList) throws IOException {
        System.out.println(message);
        for(Client c: clientList){
            DataOutputStream sOutputStream = new DataOutputStream(c.getSocket().getOutputStream());
            sOutputStream.writeUTF(message);
            sOutputStream.flush();
        }
    }

    //Reading messages from the client and sending them to all clients
    private static class ServerClientCommunication implements Runnable{
        Client client;
        DataInputStream inputStream;
        DataOutputStream outputStream;
        List<Client> clientList;

        private void EndClientCommunication(){
            try {
                clientList.remove(client);
                SendToAll("Server: " + client.getName() + " left the chat!",clientList);
                client.getSocket().close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public ServerClientCommunication(Client client,List<Client> clientList) throws IOException {
            this.client = client;
            this.inputStream = new DataInputStream(client.getSocket().getInputStream());
            this.outputStream = new DataOutputStream(client.getSocket().getOutputStream());
            this.clientList = clientList;
        }
        @Override
        public void run() {
            try {
                while(!client.getSocket().isClosed()){
                    String clientMessage = inputStream.readUTF();
                    switch (clientMessage){
                        case ("-exit"):
                            EndClientCommunication();
                            break;
                        case("-file"):
                            SendToAll("Server: "+ client.getName() + " sends a file!",clientList);
                            String fileName = inputStream.readUTF();
                            int fileLength = (int) inputStream.readLong();
                            byte[] buffer = new byte[fileLength];
                            inputStream.readFully(buffer,0,fileLength);
                            IOUtils.write(buffer,new FileOutputStream("C:\\Users\\kars\\Desktop\\ServerFiles\\"+fileName));
                            SendToAll("Server: File received",clientList);
                            break;
                        default:
                            clientMessage = client.getName() + ": " + clientMessage;
                            SendToAll(clientMessage,clientList);
                            break;
                    }
                }
            } catch (SocketException e){
                EndClientCommunication();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
