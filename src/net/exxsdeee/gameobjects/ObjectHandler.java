package net.exxsdeee.gameobjects;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sebastianjohansson on 2017-08-25.
 */
public class ObjectHandler {

    ArrayList<GameObject> obstacles;
    Player player;

    public ObjectHandler(){

        obstacles = new ArrayList<GameObject>();
        player = new Player(50, 50, this);

        obstacles.add(new Obstacle(300, 50, this));

    }

    // uppdaterar alla objekt
    public void update(){

        for (int i = 0; i < obstacles.size(); i ++) {
            obstacles.get(i).update();

        }

    }

    // målar alla object
    public void render(Graphics g){

        for (int i = 0; i < obstacles.size(); i ++) {
            obstacles.get(i).render(g);
        }

    }



}
