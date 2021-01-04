/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Others;

import city.cs.engine.SoundClip;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * It set the background music of the game.
 * @author Giuseppe
 */
public class Music {
    
    /** Game music */
    private SoundClip gameMusic;
    
    public Music(World wold){
    // set the music and in a continous playing
        try {
            gameMusic = new SoundClip("data/music.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        } 
    }
}
