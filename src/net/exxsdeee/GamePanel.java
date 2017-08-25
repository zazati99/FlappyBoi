package net.exxsdeee;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasperdejke on 2017-08-25.
 */

public class GamePanel extends JPanel{

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(Reference.GAME_WIDTH, Reference.GAME_HEIGHT);
    }

    public GamePanel(){
        super();


        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //TODO: Let the object handler do his hting and draw the objects
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Reference.GAME_WIDTH, Reference.GAME_HEIGHT);
    }

    //TODO: pick one not both
}
