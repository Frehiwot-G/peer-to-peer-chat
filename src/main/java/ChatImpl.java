// Implement the Chat interface
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatImpl extends UnicastRemoteObject implements Chat {
    final List<Chat> clients;

    protected ChatImpl() throws RemoteException {
        clients = new ArrayList<>();
    }

    @Override
    public synchronized void sendMessage(String message, String sender) throws RemoteException {
        System.out.println(sender + ": " + message);
        for (Chat client : clients) {
            if (!client.equals(this)) {
                client.receiveMessage(message, sender);
            }
        }
    }

    @Override
    public synchronized void registerClient(Chat client) throws RemoteException {
        clients.add(client);
        System.out.println("A new client has joined the chat.");
    }

    public void receiveMessage(String message, String sender) throws RemoteException {
        System.out.println("[" + sender + "]: " + message);
    }
}
