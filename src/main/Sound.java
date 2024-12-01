package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] soundURL = new URL[10];

    public Sound(){
        soundURL[0] = getClass().getResource("/sound/BlueBoyAdventure.wav");
        soundURL[1] = getClass().getResource("/sound/coin.wav");
        soundURL[2] = getClass().getResource("/sound/locked.wav");
        soundURL[3] = getClass().getResource("/sound/fanfare.wav");
        soundURL[4] = getClass().getResource("/sound/unlock.wav");
        soundURL[5] = getClass().getResource("/sound/despacito.wav");
        soundURL[6] = getClass().getResource("/sound/levelup.wav");
    }

    //set the sound
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){

        }
    }
    //play setted sound
    public void play(){
        clip.start();
    }
    //loop playing sound
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    //stop looping/playing sound
    public void stop(){
        clip.stop();
    }
}
