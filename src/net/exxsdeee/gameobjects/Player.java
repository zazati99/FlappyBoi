package net.exxsdeee.gameobjects;

import net.exxsdeee.utils.Vector2;

import java.awt.*;

/**
 * Created by sebastianjohansson on 2017-08-25.
 */
public class Player extends GameObject {

    private final float GRAV_ACC = 0.30f;
    private Vector2 velocity = new Vector2(0,0);

    public Player(float x, float y, ObjectHandler oh) {

        hitBox = new Vector2(50, 50);
        pos = new Vector2(x, y);

        this.oh = oh;

    }

    // uppdaterar skit
    public void update(){

        velocity.y += GRAV_ACC;

        //pos.y += velocity.y;
        pos.add(velocity); // ser tuffare ut + att ska endå lägga på x velocity

    }

    // Målar skit
    public void render(Graphics g){
        g.fillRect((int)pos.x, (int)pos.y, (int)hitBox.x, (int)hitBox.y);
    }

    public void flap(){
        velocity.y = -7;
    }

}
