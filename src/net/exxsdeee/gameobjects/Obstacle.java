package net.exxsdeee.gameobjects;

import net.exxsdeee.ui.GameFrame;
import net.exxsdeee.utils.Vector2;

import java.awt.*;

/**
 * Created by sebastianjohansson on 2017-08-28.
 */
public class Obstacle extends GameObject{
    private final Color COL = Color.black;
    public static final int HOLE_SIZE = 200;
    public static final int MIN_BOTTOM = 75 ;//Hur långt hålets kant får vara från botten av skärmen
    public static final int MIN_TOP = 75;//hur långt hålets kant får vara från botten av skärmen
    public static final int GENPOINT_DISTANCE = 25;

    private boolean scored = false;

    public Obstacle(float x, float y, ObjectHandler oh){

        pos = new Vector2(x, y);
        hitBox = new Vector2(75, 600);

    }

    public void update(){

        pos.x -= 3;
        if (GameFrame.gamePanel.oh.getPlayer().pos.x > this.pos.x+25 && !scored){
            if(this.pos.y < 0){
                GameFrame.gamePanel.oh.setScore(GameFrame.gamePanel.oh.getScore()+1);
                scored = true;
            }
        }

    }

    public void render(Graphics g){
        g.setColor(COL);
        g.fillRect((int)pos.x, (int)pos.y, (int)hitBox.x, (int)hitBox.y);
    }

}
