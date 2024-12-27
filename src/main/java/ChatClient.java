//// Client class to connect to the RMI server
//import java.rmi.Naming;
//import java.util.Scanner;
//import io.github.cdimascio.dotenv.Dotenv;
//public class ChatClient {
//    public static void main(String[] args) {
//        try {
//            Chat chatServer = (Chat) Naming.lookup("rmi://localhost:5000/chat");
//
//            Chat client = new ChatImpl();
//            chatServer.registerClient(client);
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Welcome to the chat. Type your messages below:");
//
//            while (true) {
//                String message = scanner.nextLine();
//                chatServer.sendMessage(message, "Client");
//            }
//        } catch (Exception e) {
//            System.err.println("Client exception: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
import io.github.cdimascio.dotenv.Dotenv;
import java.rmi.Naming;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            // Load environment variables
            Dotenv dotenv = Dotenv.load();
            String serverIp = dotenv.get("SERVER_IP");

            Chat chatServer = (Chat) Naming.lookup("rmi://" + serverIp + ":5000/chat");

            Chat client = new ChatImpl();
            chatServer.registerClient(client);

            System.out.println("Connected to chat server at IP: " + serverIp);
            System.out.println("Welcome to the chat. Type your messages below:");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                chatServer.sendMessage(message, "Client");
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
