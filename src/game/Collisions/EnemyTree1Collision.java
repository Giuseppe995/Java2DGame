/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Characters.Snake;
import game.Objects.Tree;

/**
 * Listener for the tree and the snake collision. When the snake touches the tree
 * it changes his walking direction.
 * @author Giuseppe
 */
public class EnemyTree1Collision implements CollisionListener {
    private Snake snake;
    private Tree tree1;
    int velocity = -4;
    
    
    public EnemyTree1Collision(Snake snake, Tree tree1) {
        this.snake = snake;
        this.tree1 = tree1;
    }
    
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof Snake && e.getOtherBody()== tree1){
            snake.startWalking(-velocity);
            } 
        }
}
