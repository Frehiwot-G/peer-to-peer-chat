// Implement the Chat interface
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatImpl extends UnicastRemoteObject implements Chat {
    private final List<ChatClientInterface> clients = new ArrayList<>(); // Correct type

    public ChatImpl() throws RemoteException {}

    @Override
    public void sendMessage(String message,String sender) throws RemoteException {
        System.out.println("Server received: " + message);
        for (ChatClientInterface client : clients) {
            client.receiveMessage(message); // Broadcast message to all clients
        }
    }

    @Override
    public void registerClient(ChatClientInterface client) throws RemoteException {
        clients.add(client);
        System.out.println("New client registered.");
    }

}
