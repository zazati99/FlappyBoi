package net.exxsdeee;

import net.exxsdeee.gameobjects.ObjectHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by kasperdejke on 2017-08-28.
 *
 *
 * Input, human is playing. Mostly for testing.
 */
public class HumanInput implements KeyListener{
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            ObjectHandler.flap();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
