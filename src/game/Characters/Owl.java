/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Characters;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 * It creates a new body (The owl) which is the second enemy of the game.
 * @author Giuseppe
 */
public class Owl extends Walker {
    
    private static final Shape shape = new PolygonShape(-0.29f,-2.26f, 3.66f,-0.01f,
            0.13f,2.28f, -3.78f,0.73f, -0.76f,-2.28f);

    private static final BodyImage image =
        new BodyImage("data/owl.png", 5);
    
    public Owl(World world) {
       super(world, shape);
        addImage(image);;
        startWalking(3);
    }
    
}
