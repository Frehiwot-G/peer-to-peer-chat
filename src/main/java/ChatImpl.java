// Implement the Chat interface
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatImpl extends UnicastRemoteObject implements Chat {
    private final List<ChatClientInterface> clients = new ArrayList<>(); // Correct type

    public ChatImpl() throws RemoteException {}

//    final List<Chat> clients;
//
//    protected ChatImpl() throws RemoteException {
//        clients = new ArrayList<>();
//    }
    @Override
    public void sendMessage(String message,String sender) throws RemoteException {
        System.out.println("Server received: " + message);
        for (ChatClientInterface client : clients) {
            client.receiveMessage(message); // Broadcast message to all clients
        }
    }

//    @Override
//    public synchronized void sendMessage(String message, String sender) throws RemoteException {
//        System.out.println(sender + ": " + message);
//        for (Chat client : clients) {
//            if (!client.equals(this)) {
//                client.receiveMessage(message, sender);
//            }
//        }
//    }


    @Override
    public void registerClient(ChatClientInterface client) throws RemoteException {
        clients.add(client);
        System.out.println("New client registered.");
    }

//    @Override
//    public synchronized void registerClient(Chat client) throws RemoteException {
//        clients.add(client);
//        System.out.println("A new client has joined the chat.");
//    }

    public void receiveMessage(String message, String sender) throws RemoteException {
        System.out.println("[" + sender + "]: " + message);
    }
}
