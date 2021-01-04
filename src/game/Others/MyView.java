package game.Others;

import game.Characters.Rat;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;

/**
 * Extended view of the game.
 * In this case it set the background of the game and list
 * the cheeses collected with a string.
 */
public class MyView extends UserView {
    Rat rat;
    
    
    private Image background;
    
    public MyView(World world, Rat rat, int width, int height) {
        super(world, width, height);
        this.rat = rat;
        this.background = new ImageIcon("data/background.jpg").getImage();
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Cheese collected:" + rat.getCount(), 300, 100);
        if(rat.getCount() == 5){
        g.drawString("Run to the next level!" , 420, 100);
        }
        
    }

    public void setBackground(Image background) {
        this.background = background;
    }


}
