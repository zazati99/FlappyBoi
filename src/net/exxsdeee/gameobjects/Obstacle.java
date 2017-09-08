package net.exxsdeee.gameobjects;

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

    public Obstacle(float x, float y, ObjectHandler oh){

        pos = new Vector2(x, y);
        hitBox = new Vector2(75, 600);

    }

    public void update(){

        pos.x -= 3;

    }

    public void render(Graphics g){
        g.setColor(COL);
        g.fillRect((int)pos.x, (int)pos.y, (int)hitBox.x, (int)hitBox.y);
    }

}
