/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Characters.Owl;
import game.Characters.Snake;
import game.Objects.Tree;

/**
 * Listener for the snake and owl collision. When they touch each other
 * their direction change.
 * @author Giuseppe
 */
public class SnakeOwlCollision implements CollisionListener {
    private Owl owl;
    private Snake snake;
    int velocity = 4;
    
    
    public SnakeOwlCollision(Owl owl, Snake snake) {
        this.owl = owl;
        this.snake = snake;    
    }
    
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof Owl && e.getOtherBody()== snake){
            owl.startWalking(velocity);
            snake.startWalking(-velocity);
            } 
        }
}
