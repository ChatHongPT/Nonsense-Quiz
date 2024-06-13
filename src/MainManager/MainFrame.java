package MainManager;

import GameWindow.GAME;
import GameWindow.GameRun;
import GameWindow.GameThread;
import GameWindow.TimerThread;
import ScoreManager.ScoreBoardManager;
import Socket.Client;
import GameSettingManager.GameSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MainFrame extends JFrame{
    JButton startButton;
    JButton scoreBoardButton;
    JButton exitButton;
    JButton OptionButton;
    JButton MultiButton;
    JLabel TextLabel;
    ImageIcon gifIcon;
    ImageIcon resizedIcon;
    JLabel gifLabel;
    JLayeredPane layeredPane;

    private Client client;
    private JLabel playerLabel;
    private JFrame waitingRoomFrame;

    public MainFrame(Client client) {
        super("그림 퀴즈");

        this.client = client;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);

        SetImage();
        SetTitle();

        layeredPane.add(TextLabel, BorderLayout.CENTER);
        layeredPane.add(gifLabel, JLayeredPane.DEFAULT_LAYER);

        BGMManager BGM = new BGMManager("music/sqidgameBGM.wav");
        Thread BGMThread = new Thread(BGM);
        BGMThread.start();

        addScoreButton();
        addOptionButton();
        addExitButton();
        addMultiButton();

        add(layeredPane);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void SetImage()
    {
        gifIcon = new ImageIcon("home.jpg");
        Image image = gifIcon.getImage();
        Image resizedImage = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedImage);
        gifLabel = new JLabel(resizedIcon);
        gifLabel.setBounds(-10,-25,600,400);
    }

    public void SetTitle()
    {
        TextLabel = new JLabel("");
        Font font = new Font("Arial", Font.BOLD, 36);
        TextLabel.setFont(font);
        TextLabel.setBounds(215,-25,200,200);
    }

    public void addScoreButton()
    {
        scoreBoardButton = new JButton("Score");
        scoreBoardButton.setBounds(200, 160, 200, 30);
        scoreBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //순위표 함수
                ScoreBoardManager bd = new ScoreBoardManager();
            }
        });
        layeredPane.add(scoreBoardButton, JLayeredPane.PALETTE_LAYER);
    }

    public void addOptionButton()
    {
        OptionButton = new JButton("Option");
        OptionButton.setBounds(200, 210, 200, 30);
        OptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameSettings GameSetting = new GameSettings();
            }
        });
        layeredPane.add(OptionButton, JLayeredPane.PALETTE_LAYER);
    }

    public void addExitButton()
    {
        exitButton = new JButton("Exit");
        exitButton.setBounds(200, 260, 200, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        layeredPane.add(exitButton, JLayeredPane.PALETTE_LAYER);
    }

    public void addMultiButton() {

    MultiButton = new JButton("멀티");
    MultiButton.setBounds(200, 325, 200, 30);

    MultiButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 닉네임 입력 다이얼로그 표시
            String nickname = JOptionPane.showInputDialog(null, "닉네임을 입력하세요:", "닉네임", JOptionPane.PLAIN_MESSAGE);
            if (nickname == null || nickname.trim().isEmpty()) {
                return;
            }

            // 멀티플레이어 대기방 프레임 생성
            JFrame waitingRoomFrame = new JFrame("멀티플레이어 대기방");
            waitingRoomFrame.setSize(400, 300);
            waitingRoomFrame.setLocationRelativeTo(null);
            waitingRoomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            waitingRoomFrame.setLayout(new BorderLayout());

            // 현재 접속자 표시
            JLabel playerLabel = new JLabel("현재 접속자: ");
            playerLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
            playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            waitingRoomFrame.add(playerLabel, BorderLayout.NORTH);

            // 게임 시작 버튼
            JButton startButton = new JButton("게임 시작");
            startButton.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 게임 시작 메시지 전송
                    client.sendMessage("START");
                }
            });
            waitingRoomFrame.add(startButton, BorderLayout.SOUTH);

            // 클라이언트 생성 및 서버 연결
            client.sendMessage("JOIN:" + nickname);

            // 서버로부터 메시지 수신을 위한 스레드 생성
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String message = client.receiveMessage();
                        if (message == null) {
                            break;
                        }
                        if (message.startsWith("PLAYER:")) {
                            // 현재 접속자 정보 업데이트
                            String[] players = message.substring(7).split(",");
                            StringBuilder sb = new StringBuilder("현재 접속자: ");
                            for (String player : players) {
                                sb.append(player).append(" ");
                            }
                            playerLabel.setText(sb.toString());
                        } else if (message.equals("START")) {
                            // 게임 시작 메시지 받으면 대기방 프레임 닫기
                            waitingRoomFrame.dispose();
                            // 게임 시작
                            TimerThread TT = new TimerThread();
                            GameRun GR = new GameRun(client);
                            GameThread GT = new GameThread();
                            GT.setGR(GR);
                            TT.setGameThread(GT);
                            TT.start();
                            break;
                        }
                    }
                }
            }).start();

            waitingRoomFrame.setVisible(true);
        }
    });
    layeredPane.add(MultiButton, JLayeredPane.PALETTE_LAYER);
}
    public void processMessage(String message) {
    if (message.startsWith("PLAYER:")) {
        // 현재 접속자 정보 업데이트
        String[] players = message.substring(7).split(",");
        StringBuilder sb = new StringBuilder("현재 접속자: ");
        for (String player : players) {
            sb.append(player).append(" ");
        }
        playerLabel.setText(sb.toString());
    } else if (message.equals("START")) {
        // 게임 시작 메시지 받으면 대기방 프레임 닫기
        waitingRoomFrame.dispose();
        
        // 게임 시작을 위한 새로운 스레드 생성
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 게임 시작
                TimerThread TT = new TimerThread();
                GameRun GR = new GameRun(client);
                GameThread GT = new GameThread();
                GT.setGR(GR);
                TT.setGameThread(GT);
                TT.start();
            }
        }).start();
    } 
}   
    public static void main(String args[]) {
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
