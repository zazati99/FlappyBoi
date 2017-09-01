package net.exxsdeee;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasperdejke on 2017-08-25.
 */


public class GameFrame extends JFrame {

    public static GamePanel gamePanel;

    public GameFrame(){
        super(Reference.APPLICATION_NAME);
        //setSize(Reference.GAME_WIDTH, Reference.GAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        //Initialize and add the game panel to the frame
        gamePanel = new GamePanel();
        this.add(gamePanel);
        this.addKeyListener(new HumanInput());

        //Gives the frame the correct size
        pack();

        //Center the frame on the display
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        //Starts the gameloop
        gamePanel.gameLoop();
    }
}
