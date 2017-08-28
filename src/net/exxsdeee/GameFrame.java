package net.exxsdeee;

import javax.swing.*;

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

        //Starts the gameloop
        gamePanel.gameLoop();
    }
}
