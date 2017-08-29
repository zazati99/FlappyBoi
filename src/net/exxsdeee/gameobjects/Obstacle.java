package net.exxsdeee.gameobjects;

import net.exxsdeee.utils.Vector2;

import java.awt.*;

/**
 * Created by sebastianjohansson on 2017-08-28.
 */
public class Obstacle extends GameObject{
    private final Color COL = Color.black;
    public Obstacle(float x, float y, ObjectHandler oh){

        pos = new Vector2(x, y);
        hitBox = new Vector2(75, 300);

    }

    public void update(){

        pos.x -= 2;

    }

    public void render(Graphics g){
        g.setColor(COL);
        g.fillRect((int)pos.x, (int)pos.y, (int)hitBox.x, (int)hitBox.y);
    }

}
