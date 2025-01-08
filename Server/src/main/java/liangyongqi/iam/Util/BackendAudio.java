package liangyongqi.iam.Util;

import org.springframework.util.ResourceUtils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.InputStream;

public class BackendAudio {
    /**
     * 播放音频文件
     *
     * @param filePath 音频文件路径
     */
    public static void playSound(String filePath) {
        try {
            // 使用 ResourceUtils 获取音频文件
            File file = ResourceUtils.getFile("classpath:" + filePath);
            InputStream audioStream = file.toURI().toURL().openStream();

            // 获取音频输入流并打开音频设备
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioStream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // 播放音频
            clip.start();

            // 等待播放结束
            while (!clip.isRunning()) {
                Thread.sleep(10);
            }

            // 等待音频播放完毕
            while (clip.isRunning()) {
                Thread.sleep(100);
            }

            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("播放音频文件时出错：" + e.getMessage());
        }
    }


    public static void ErrorAlert() {
        playSound("audio/alert.wav");
    }
}
