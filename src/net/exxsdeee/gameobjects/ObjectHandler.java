package net.exxsdeee.gameobjects;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sebastianjohansson on 2017-08-25.
 */
public class ObjectHandler {

    ArrayList<GameObject> gameObjects;

    public ObjectHandler(){

        gameObjects = new ArrayList<GameObject>();
        gameObjects.add(new Player(50, 50, this));

    }

    // uppdaterar alla objekt
    public void update(){

        for (int i = 0; i < gameObjects.size(); i ++) {
            gameObjects.get(i).update();
        }

    }

    // målar alla object
    public void render(Graphics g){

        for (int i = 0; i < gameObjects.size(); i ++) {
            gameObjects.get(i).render(g);
        }

    }



}
