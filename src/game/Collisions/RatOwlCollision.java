/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.Characters.Owl;
import game.Characters.Rat;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Listener for the rat and the owl collision. When the rat touches the owl,
 * the rat lose a life. At the end of all the life, the rat get
 * destroyed. Sounds are included for the collision and the dead rat.
 * @author Giuseppe
 */
public class RatOwlCollision implements CollisionListener {
    private Rat rat;
    private Owl owl;
    int velocity = -4;
    private int lifeCount = 3;
    private SoundClip collision1Music;
    private SoundClip fail1Music;
    
    
    public RatOwlCollision(Rat rat, Owl owl) {
        this.rat = rat;
        this.owl = owl;
    }
    
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof Owl && e.getOtherBody()== rat){
            rat.decrementLifeCount();
            owl.startWalking(+velocity);
            try {
                collision1Music = new SoundClip("data/collision.wav");
                collision1Music.play();
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException c) {
                System.out.println(c);
                }
            if(rat.getLifeCount() == 0){
                System.out.println("YOU DIED.");
                rat.destroy();
                owl.stopWalking();
                try {
                fail1Music = new SoundClip("data/fail.wav");
                fail1Music.play();
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException z) {
                System.out.println(z);
                }
            }
        }
    } 
    } 

