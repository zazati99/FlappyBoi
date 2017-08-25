package net.exxsdeee.gameobjects;

import net.exxsdeee.utils.Vector2;

import java.awt.*;

/**
 * Created by sebastianjohansson on 2017-08-25.
 */
public class Player extends GameObject {

    public Player(float x, float y, ObjectHandler oh) {

        hitBox = new Vector2(50, 50);
        pos = new Vector2(x, y);

        this.oh = oh;

    }

    // uppdaterar skit
    public void update(){
        pos.x += 1;
    }

    // Målar skit
    public void render(Graphics g){
        g.drawRect((int)pos.x, (int)pos.y, (int)hitBox.x, (int)hitBox.y);
    }

}
