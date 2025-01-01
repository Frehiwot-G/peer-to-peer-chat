import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatClientImpl extends UnicastRemoteObject implements ChatClientInterface {
    public ChatClientImpl() throws RemoteException {}

    @Override
    public void receiveMessage(String message) throws RemoteException {
        System.out.println("New message: " + message);
    }
}
