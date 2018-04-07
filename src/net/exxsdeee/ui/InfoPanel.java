package net.exxsdeee.ui;

import net.exxsdeee.Reference;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasperdejke on 2017-09-01.
 */


public class InfoPanel extends JPanel {

    Font textFont = new Font("Comic Sans MS", Font.PLAIN, 24);

    JLabel score;
    public InfoPanel(){
        this.setVisible(true);
        //Initialize and add score
        score = new JLabel("Score: 0");
        score.setFont(textFont);
        score.setVisible(true);
        this.add(score);
    }

    public void updateScore(int newScore){
        try {
            if (GameFrame.gamePanel.oh.getInfoScreen()) {
                score.setText("<html>Final Score: " + newScore + "<br>Space to retry</html>");
                return;
            }
        }
        catch (NullPointerException e){
            
        }
        score.setText("Score: "+ newScore);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(200, 200, 200));
        g.fillRect(0,0,getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Reference.GAME_WIDTH, 100);
    }


}
