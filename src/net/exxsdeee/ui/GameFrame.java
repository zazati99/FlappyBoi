package net.exxsdeee.ui;

import net.exxsdeee.HumanInput;
import net.exxsdeee.Reference;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasperdejke on 2017-08-25.
 */


public class GameFrame extends JFrame {

    public static GamePanel gamePanel;
    public static InfoPanel infoPanel;

    public GameFrame(){
        super(Reference.APPLICATION_NAME);
        //setSize(Reference.GAME_WIDTH, Reference.GAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        getContentPane().setLayout(new BorderLayout());


        //Initialize and add the InfoPanel to the frame
        infoPanel = new InfoPanel();
        this.add(infoPanel, BorderLayout.SOUTH);

        //Initialize and add the game panel to the frame
        gamePanel = new GamePanel();
        this.add(gamePanel, BorderLayout.NORTH);
        this.addKeyListener(new HumanInput());




        //Gives the frame the correct size
        //TODO: Fix this packkkk thing it takes several seconds wtf?
        pack();

        //Center the frame on the display
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);

        //Starts the gameloop
        gamePanel.gameLoop();
    }
}
