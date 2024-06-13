package MainManager;

import java.io.*;
import javax.sound.sampled.*;

public class BGMManager implements Runnable {

    private String musicPath = "music/manishe.wav";
    private Clip clip;

    public BGMManager(String musicPath) {
        this.musicPath = musicPath;
    }

    public void run() {
        try {
            clip = AudioSystem.getClip();
            File audioFile = new File(musicPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip.open(audioStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        clip.loop(Clip.LOOP_CONTINUOUSLY);//loop infinite
        clip.start();

        while (clip.isActive()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
