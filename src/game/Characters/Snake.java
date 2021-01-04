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
 * It creates a new body (The rat) which is the first enemy of the game.
 * @author Giuseppe
 */
public class Snake extends Walker {
    
    /*This class creates new features for another game character called Snake with YellowBird example's help. 
    The polygon shape points have been made with the use of the polygon editor.
    The image has been downloaded from Google.com (with a transparent background).*/
    
    
    private static final Shape shape = new PolygonShape(0.0f,-2.47f, 1.33f,-1.46f,
            1.15f,1.2f, 0.24f,2.49f, -0.67f,2.48f, -1.37f,0.99f, -1.29f,-1.79f, -0.6f,-2.47f);

    private static final BodyImage image =
        new BodyImage("data/snake.png", 5);
    
    public Snake(World world) {
        super(world, shape);
        addImage(image);;
        startWalking(-5);
    }
}