package Socket;

import java.io.*;
import java.net.*;
import MainManager.MainFrame;

public class Client {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public Client(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("서버에 연결되었습니다: " + socket);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        output.println(message);
    }

    public String receiveMessage() {
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 8888);

        // MainFrame 객체 생성
        MainFrame mainFrame = new MainFrame(client);
        mainFrame.setVisible(true);

        // 메시지 수신을 위한 스레드 생성
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String message = client.receiveMessage();
                    if (message == null) {
                        break;
                    }
                    // 받은 메시지 처리
                    mainFrame.processMessage(message);
                }
            }
        }).start();
    }
}