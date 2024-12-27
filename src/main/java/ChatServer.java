//import java.rmi.Naming;
//
//public class ChatServer {
//    public static void main(String[] args) {
//        try {
//            ChatImpl chatServer = new ChatImpl();
//            Naming.rebind("rmi://localhost:5000/chat", chatServer);
//            System.out.println("Chat server is running...");
//        } catch (Exception e) {
//            System.err.println("Server exception: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
import io.github.cdimascio.dotenv.Dotenv;
import java.rmi.Naming;

public class ChatServer {
    public static void main(String[] args) {
        try {
            // Load environment variables
            Dotenv dotenv = Dotenv.load();
            String serverIp = dotenv.get("SERVER_IP");

            ChatImpl chatServer = new ChatImpl();
            Naming.rebind("rmi://" + serverIp + ":5000/chat", chatServer);
            System.out.println("Chat server is running on IP: " + serverIp);
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
