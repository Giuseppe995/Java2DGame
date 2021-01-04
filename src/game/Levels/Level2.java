package game.Levels;

import city.cs.engine.*;
import game.Objects.Cheese;
import game.Others.Game;
import game.Others.GameLevel;
import game.Collisions.Pickup;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game.
 */
public class Level2 extends GameLevel {

    private static final int NUM_CHEESE = 7;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

       // make the ground and top wall
        Shape groundShape = new BoxShape(30, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -17));
        Shape topShape = new BoxShape(30, 0.5f);
        Body top = new StaticBody(this, topShape);
        top.setPosition(new Vec2(0, 17));
        
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 18, new Vec2(-29.5f, 15.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 18, new Vec2(29.5f, 15.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        
        //platforms
        Shape boxShape = new BoxShape (3, 0.5f);
        Shape boxShape2 = new BoxShape (8, 0.5f);
        
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-18, -1));
        platform1.setFillColor(Color.black);
        
        Body platform2 = new StaticBody(this, boxShape2);
        platform2.setPosition(new Vec2(4, -1));
        platform2.setFillColor(Color.black);
        
        Body platform3 = new StaticBody(this, boxShape2);
        platform3.setPosition(new Vec2(-9, -10));
        platform3.setFillColor(Color.black);
        
        Body platform4 = new StaticBody(this, boxShape2);
        platform4.setPosition(new Vec2(21, 5));
        platform4.setFillColor(Color.black);
        
        Body platform5 = new StaticBody(this, boxShape2);
        platform5.setPosition(new Vec2(-19, 11));
        platform5.setFillColor(Color.black);

        for (int i = 0; i < NUM_CHEESE; i++) {
            Body cheese = new Cheese(this);
            cheese.setPosition(new Vec2(i * 4 - 5, 13));
            cheese.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }
    
    @Override
    public Vec2 startPosition2() {
        return new Vec2(20, -10);
    }
    
    @Override
    public Vec2 startPosition3() {
        return new Vec2(-15, 15);
    }
    
    @Override
    public Vec2 startTree1Position() {
        return new Vec2(-26, -11);
    }
    @Override
    public Vec2 startTree2Position() {
        return new Vec2(26, -11);
    }
    
    @Override
    public Vec2 trapPosition(){
        return new Vec2(10, 11);
    }
    
    @Override
    public Vec2 bladePosition(){
        return new Vec2(-10, 14);
    }
    
      @Override
    public Vec2 helpMousePosition(){
        return new Vec2(-26.5f, -1);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCount() == NUM_CHEESE;
    }

    @Override
    public Image getBackgroundImage() {
        return new ImageIcon("data/background2.png").getImage().getScaledInstance(1200, 700, 0);
    }
}
