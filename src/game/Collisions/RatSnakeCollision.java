/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.Characters.Rat;
import game.Characters.Snake;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Listener for the rat and the owl. When the rat touches the snake,
 * the rat lose a life. At the end of all the life, the rat get
 * destroyed. Sounds are included for the collision and the dead rat.
 * @author Giuseppe
 */
public class RatSnakeCollision implements CollisionListener {
    private Rat rat;
    private Snake snake;
    int velocity = -4;
    private int lifeCount = 3;
    private SoundClip collisionMusic;
    private SoundClip failMusic;
    
    
    public RatSnakeCollision(Rat rat, Snake snake) {
        this.rat = rat;
        this.snake = snake;
    }
    
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof Snake && e.getOtherBody()== rat){
            rat.decrementLifeCount();
            snake.startWalking(velocity);
            try {
                collisionMusic = new SoundClip("data/collision.wav");
                collisionMusic.play();
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException c) {
                System.out.println(c);
                }
            if(rat.getLifeCount() == 0){
                System.out.println("YOU DIED.");
                rat.destroy();
                snake.stopWalking();
                try {
                failMusic = new SoundClip("data/fail.wav");
                failMusic.play();
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException z) {
                System.out.println(z);
                }
            }
        }
    } 
}
