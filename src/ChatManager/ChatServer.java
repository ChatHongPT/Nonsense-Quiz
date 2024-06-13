package ChatManager;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Chat server started on port " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Get client name
                out.println("SUBMITNAME");
                name = in.readLine();
                System.out.println(name + " has joined.");

                synchronized (clientHandlers) {
                    clientHandlers.add(this);
                }

                // Broadcast messages from this client
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(name + ": " + message);
                    synchronized (clientHandlers) {
                        for (ClientHandler handler : clientHandlers) {
                            handler.out.println(name + ": " + message);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientHandlers) {
                    clientHandlers.remove(this);
                }
                System.out.println(name + " has left.");
            }
        }
    }
}



