/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Objects;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;

/**
 *
 * @author Giuseppe
 */

public class Cheese extends DynamicBody {
    private static final Shape shape = new PolygonShape(0.627f,-0.605f, 0.632f,0.061f,
            0.235f,0.56f, -0.648f,0.32f, -0.635f,-0.376f, 0.616f,-0.621f);
    
     private static final BodyImage image =
        new BodyImage("data/cheese.png", 2);
    
    public Cheese (World world) {
        super(world, shape);
        addImage(image);
    }
}
