package net.exxsdeee.gameobjects;

import java.util.ArrayList;

/**
 * Created by sebastianjohansson on 2017-08-25.
 */
public class ObjectHandler {

    ArrayList<GameObject> gameObjects;

    public ObjectHandler(){

        gameObjects = new ArrayList<GameObject>();

    }

    // uppdaterar alla objekt
    public void update(){

        for (int i = 0; i < gameObjects.size(); i ++) {
            gameObjects.get(i).update();
        }

    }

    // målar alla object
    public void draw(){

        for (int i = 0; i < gameObjects.size(); i ++) {
            gameObjects.get(i).render();
        }

    }

}
