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
 * It creates a body in the game which is the principal character, the rat.
 * @author Giuseppe
 */
public class Rat extends Walker {

    private static final Shape shape = new PolygonShape(
            1.68f,-2.38f, 1.73f,0.65f, 0.65f,2.49f, -1.21f,1.76f, -1.71f,1.0f, -1.73f,-2.39f, 1.63f,-2.39f);

    private static final BodyImage image =
        new BodyImage("data/rat.png", 5);

    private int count;
    private int lifeCount;

    public Rat(World world) {
        super(world, shape);
        addImage(image);
        count = 0;
        lifeCount = 3;
    }

    public int getCount() {
        return count;
    }

    public void addOne() {
        count++;
    }
    
    public int getLifeCount() {
        return lifeCount;
    }
    
    public void decrementLifeCount() {
        lifeCount--;
        System.out.println("Oh no! You have " + lifeCount + " life bars left!");
    }
}
