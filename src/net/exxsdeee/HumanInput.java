package net.exxsdeee;

import net.exxsdeee.ui.GameFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by kasperdejke on 2017-08-28.
 */
public class HumanInput implements KeyListener{

    private boolean keyDownFlag = false;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if((e.getKeyCode() == KeyEvent.VK_SPACE ||e.getKeyCode() == KeyEvent.VK_X )&& !keyDownFlag){
            if(GameFrame.gamePanel.oh.getInfoScreen()){
                GameFrame.gamePanel.oh.startGame();

            }
            GameFrame.gamePanel.oh.getPlayer().flap();
        }

        keyDownFlag = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyDownFlag = false;
    }
}
