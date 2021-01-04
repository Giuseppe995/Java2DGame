package game.Collisions;

import game.Characters.Rat;
import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Collision listener that allows the rat to collect things.
 * Everytime the rat collect a cheese, a sound get played.
 */
public class Pickup implements CollisionListener {
    private Rat rat;
    private SoundClip cheeseMusic;
    
    public Pickup(Rat rat) {
        this.rat = rat;
    }

    @Override
    public void collide(CollisionEvent e) {
        
        if (e.getOtherBody() == rat) {
            rat.addOne();
            e.getReportingBody().destroy();
            try {
            cheeseMusic = new SoundClip("data/pickup.wav");
            cheeseMusic.play();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException f) {
            System.out.println(f);
        } 
        }
    }
    
}
