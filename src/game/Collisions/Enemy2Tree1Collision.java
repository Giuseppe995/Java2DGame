/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Characters.Owl;
import game.Objects.Tree;

/**
 * Listener for the owl and the tree collision. When the owl touches the tree
 * it changes his walking direction.
 * @author Giuseppe
 */
public class Enemy2Tree1Collision implements CollisionListener {
    private Owl owl;
    private Tree tree1;
    int velocity = 4;
    
    
    public Enemy2Tree1Collision(Owl owl, Tree tree1) {
        this.owl = owl;
        this.tree1 = tree1;
    }
    
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof Owl && e.getOtherBody()== tree1){
            owl.startWalking(-velocity);
            } 
        }
}
