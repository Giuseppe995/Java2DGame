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
 * It creates a blade in the game.
 * @author Giuseppe
 */

public class Blade extends DynamicBody {
    private static final Shape shape = new PolygonShape(2.08f,-1.4f, 1.08f,0.15f,
            -2.06f,1.48f, 0.3f,-0.99f, 1.99f,-1.46f);
    
     private static final BodyImage image =
        new BodyImage("data/blade.png", 3);
    
    public Blade (World world) {
        super(world, shape);
        addImage(image);
    }
}
