package net.exxsdeee;

import net.exxsdeee.gameobjects.ObjectHandler;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasperdejke on 2017-08-25.
 */

public class GamePanel extends JPanel{

    //hur lång tid förra framen tog, i sekunder.
    //TODO: ge objekten tillgång till variabeln deltaTime. kanske som parameter i update? eller statisk men det är fult
    public float deltaTime = 0;

    boolean gameRunning;
    ObjectHandler oh;

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
            deltaTime = (now - lastLoopTime)/1000000000;
            lastLoopTime = now;

            oh.update();
            repaint();

            try { Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);}
            catch(InterruptedException ex) { Thread.currentThread().interrupt();}

        }

    }


}
