package net.exxsdeee;

import net.exxsdeee.gameobjects.ObjectHandler;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasperdejke on 2017-08-25.
 */

public class GamePanel extends JPanel{

    boolean gameRunning;
    public   ObjectHandler oh;


    public GamePanel(){
        super();

        oh = new ObjectHandler();
        gameRunning = true;

        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        oh.render(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Reference.GAME_WIDTH, Reference.GAME_HEIGHT);
    }


    // VARNING FÖR KAOS (Gameloop)
    public void gameLoop(){

        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000/TARGET_FPS;

        while(gameRunning) {
            long now = System.nanoTime();
            lastLoopTime = now;


            oh.update();

            repaint();


            try { Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);}
            catch(InterruptedException ex) { Thread.currentThread().interrupt();}
        }

    }


}
