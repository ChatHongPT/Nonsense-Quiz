package Socket;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private ServerSocket serverSocket;
    private List<ClientHandler> clients;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clients = new ArrayList<>();
            System.out.println("서버가 시작되었습니다. 포트: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("새로운 클라이언트 연결: " + socket);
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                clientHandler.start();
                broadcastMessage("PLAYER:" + getPlayerList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public String getPlayerList() {
        StringBuilder sb = new StringBuilder();
        for (ClientHandler client : clients) {
            sb.append(client.getNickname()).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader input;
        private PrintWriter output;
        private String nickname;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = input.readLine()) != null) {
                    if (message.startsWith("JOIN:")) {
                        nickname = message.substring(5);
                        broadcastMessage("PLAYER:" + getPlayerList());
                    } else if (message.equals("START")) {
                        broadcastMessage("START");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clients.remove(this);
                broadcastMessage("PLAYER:" + getPlayerList());
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void sendMessage(String message) {
            output.println(message);
        }

        public String getNickname() {
            return nickname;
        }
    }

    public static void main(String[] args) {
        Server server = new Server(8888);
        server.start();
    }
}