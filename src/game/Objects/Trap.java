/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Objects;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;
import java.awt.Color;

/**
 * It creates a trap in the game.
 * @author Giuseppe
 */

public class Trap extends DynamicBody {
    private static final Shape shape = new PolygonShape(1.45f,-0.36f, 0.97f,0.53f, -1.04f,0.58f,
            -1.45f,-0.09f, -0.15f,-0.7f, 1.43f,-0.39f);
    
     private static final BodyImage image =
        new BodyImage("data/trap.png", 3);
    
    public Trap (World world) {
        super(world, shape);
        addImage(image);
    }
}
