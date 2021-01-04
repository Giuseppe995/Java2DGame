package game.Others;
import game.Levels.Level3;
import game.Levels.Level2;
import game.Levels.Level1;
import game.Characters.Rat;
import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
 * It creates the world with the bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;
    
    /** Game music. */
    private Music music;
    
    private int level;
    
    private Controller controller;
    
    /** Initialise a new Game. */
    public Game() {
       
        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);
        
        // make a view
        view = new MyView(world, world.getPlayer(), 1200, 700); 
        
        // set the music and in a continous playing
        music = new Music(world);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        JFrame frame = new JFrame("Multi-level game");
        
        Container buttons = new ControlPanel(this);
        frame.add(buttons, BorderLayout.NORTH);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        view.setBackground(world.getBackgroundImage());
        // start!
        world.start();
    }
    
    /** The player in the current level. */
    public Rat getPlayer() {
        return world.getPlayer();
    }
    
    /** JPanel buttons' function method*/
    public void pause(){
        world.stop();
    }
    public void resume(){
        world.start();
    }
    public void restart(){
        
    }
    
    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        if (level == 3) {
            System.exit(0);
        } else if (level == 1) {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        } else if (level == 2){
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }
        view.setBackground(world.getBackgroundImage());
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
