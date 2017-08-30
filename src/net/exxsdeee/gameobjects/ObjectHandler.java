package net.exxsdeee.gameobjects;

import net.exxsdeee.Reference;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sebastianjohansson on 2017-08-25.
 */
public class ObjectHandler {

    ArrayList<GameObject> obstacles;
    public Player player;


    public ObjectHandler(){

        obstacles = new ArrayList<GameObject>();
        player = new Player(50, 50, this);

        obstacles.add(new Obstacle(300, -300, this));

    }

    // uppdaterar alla objekt
    public void update(){

        player.update();

        for (int i = 0; i < obstacles.size(); i++) {
            GameObject temp = obstacles.get(i);

            temp.update();

            if(temp.pos.x < -temp.hitBox.x&&temp.pos.y < 0){
                obstacles.remove(i);
                generateObstacles(this);
            }

        }

    }

    // målar alla object
    public void render(Graphics g){

        player.render(g);

        for (int i = 0; i < obstacles.size(); i ++) {
            obstacles.get(i).render(g);
        }

    }

    void generateObstacles(ObjectHandler oh){
        int yPos = (int)(Math.random() * Reference.GAME_HEIGHT - Obstacle.HOLE_SIZE);
        System.out.println(yPos);

        yPos -= yPos%Obstacle.GENPOINT_DISTANCE;
        System.out.println(yPos);

        obstacles.add(new Obstacle(Reference.GAME_WIDTH,yPos-600, oh));
        obstacles.add(new Obstacle(Reference.GAME_WIDTH, yPos + Obstacle.HOLE_SIZE, oh));
    }
}
