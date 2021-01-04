/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Objects.Blade;
import game.Characters.Snake;

/**
 * Listener for the snake and the blade. When the blade touches the snake,
 * the snake get destroyed..
 * @author Giuseppe
 */
public class SnakeBladeCollision implements CollisionListener {
    private Snake snake;
    private Blade blade;
    
    
    public SnakeBladeCollision(Snake snake, Blade blade) {
        this.snake = snake;
        this.blade = blade;
    }
    
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof Snake && e.getOtherBody()== blade){
            snake.destroy();
            } 
        }
}
