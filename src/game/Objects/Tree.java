/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Objects;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * It creates the trees in the game.
 * @author Giuseppe
 */
public class Tree extends StaticBody {
      private static final Shape shape = new PolygonShape(-0.09f,5.92f, 4.85f,0.26f, 1.6f,-5.44f,
              -1.19f,-5.44f, -4.72f,0.67f, -0.5f,5.95f);
    
     private static final BodyImage image =
        new BodyImage("data/tree.png", 12);
    
    public Tree (World world) {
        super(world, shape);
        addImage(image);}
}
