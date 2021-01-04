/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Characters.Owl;
import game.Objects.Trap;

/**
 * Listener for the collision between the trap and the owl.
 * When the trap touches the owl this one get destroyed.
 * @author Giuseppe
 */
public class OwlTrapCollision implements CollisionListener {
    private Owl owl;
    private Trap trap;
    
    
    public OwlTrapCollision(Owl owl, Trap trap) {
        this.owl = owl;
        this.trap = trap;
    }
    
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof Owl && e.getOtherBody()== trap){
            owl.destroy();
            } 
        }
}
