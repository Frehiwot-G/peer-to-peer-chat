// Define the Chat interface (RMI interface)
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat extends Remote {
    void sendMessage(String message, String sender) throws RemoteException;
//    void registerClient(Chat client) throws RemoteException;
    void registerClient(ChatClientInterface client) throws RemoteException;

}