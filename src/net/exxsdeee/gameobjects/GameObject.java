package net.exxsdeee.gameobjects;

import net.exxsdeee.utils.Vector2;

import java.awt.*;

/**
 * Created by sebastianjohansson on 2017-08-25.
 */
public abstract class GameObject {

    public Vector2 pos;
    public Vector2 hitBox;

    ObjectHandler oh;

    public void update(){

    }

    public void render(Graphics g){

    }

}
