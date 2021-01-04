package game.Others;

import game.Objects.Tree;
import game.Objects.Door;
import game.Objects.Blade;
import game.Objects.Trap;
import game.Collisions.RatSnakeCollision;
import game.Characters.Owl;
import game.Characters.Rat;
import game.Characters.Snake;
import game.Collisions.DoorListener;
import game.Collisions.EnemyTree1Collision;
import city.cs.engine.*;
import game.Collisions.Enemy2Tree1Collision;
import game.Collisions.OwlTrapCollision;
import game.Collisions.RatOwlCollision;
import game.Collisions.SnakeBladeCollision;
import game.Collisions.SnakeOwlCollision;
import java.awt.Image;
import org.jbox2d.common.Vec2;

/**
 * Creates the levels of the game.
 */
public abstract class GameLevel extends World {
    private Rat player;
    private Snake enemy;
    private Owl enemy2;
    private Tree tree1;
    private Trap trap;
    private Blade blade;
    
    //Makes the player in the world
    public Rat getPlayer() {
        return player;
    }
    //Makes the first enemy in the world
    public Snake getEnemy(){
        return enemy;
    }
    //Makes the second enemy in the world
    public Owl getEnemy2(){
        return enemy2;
    }
    //Tree1
    public Tree getTree1(){
        return tree1;
    }
    
    //Trap
    public Trap getTrap(){
        return trap;
    }
    
    //Blade
    public Blade getBlade(){
        return blade;
    }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        player = new Rat(this);
        player.setPosition(startPosition());
        player.addCollisionListener(new RatSnakeCollision(player, enemy));
        enemy = new Snake(this);
        enemy.setPosition(startPosition2());
        enemy.addCollisionListener(new RatSnakeCollision(player, enemy));
        enemy2 = new Owl(this);
        enemy2.setPosition(startPosition3());
        enemy2.addCollisionListener(new RatOwlCollision(player, enemy2));
        tree1 = new Tree(this);
        tree1.setPosition(startTree1Position());
        enemy.addCollisionListener(new EnemyTree1Collision(enemy, tree1));
        tree1 = new Tree(this);
        tree1.setPosition(startTree2Position());
        enemy2.addCollisionListener(new Enemy2Tree1Collision(enemy2, tree1));
        enemy2.addCollisionListener(new SnakeOwlCollision(enemy2, enemy));
        trap = new Trap(this);
        trap.setPosition(trapPosition());
        enemy2.addCollisionListener(new OwlTrapCollision(enemy2, trap));
        blade = new Blade(this);
        blade.setPosition(bladePosition());
        enemy.addCollisionListener(new SnakeBladeCollision(enemy, blade));
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
    }
        
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The initial position of the enemy. */
    public abstract Vec2 startPosition2();
    
    /** The initial position of the enemy2. */
    public abstract Vec2 startPosition3();
    
    /**Positions of the trees. */
    public abstract Vec2 startTree1Position();
    public abstract Vec2 startTree2Position();
    
    /**Positions dynamic Body. */
    public abstract Vec2 trapPosition();
    public abstract Vec2 bladePosition();
    public abstract Vec2 helpMousePosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
    
    public abstract Image getBackgroundImage();
}
