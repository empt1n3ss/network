import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static final Integer PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("New connection accepted");

        final String name = in.readLine();

        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

        Scanner sc = new Scanner(System.in);
        System.out.print("Write your name: ");
        String userName = sc.nextLine();
        System.out.print("Are you child? (yes/no)");
        String userAge = sc.nextLine();
        if (userAge.equals("yes")) {
            System.out.println("Welcome to the kids area, " + userName + "! Let's play!");
        } else {
            System.out.println("Welcome to the adult zone, " + userName + "! Have a good rest, or a good working day!");
        }
        clientSocket.close();
        serverSocket.close();
    }
}
