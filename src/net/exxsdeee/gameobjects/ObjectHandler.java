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

        generateObstacles(600,this);
        generateObstacles(1100,this);

    }

    // uppdaterar alla objekt
    public void update(){

        player.update();

        for (int i = 0; i < obstacles.size(); i++) {
            GameObject temp = obstacles.get(i);

            temp.update();

            if(temp.pos.x <= -200){

                if(temp.pos.y <= 0){
                    generateObstacles(Reference.GAME_WIDTH, this);
                }
                obstacles.remove(i);
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

    void generateObstacles(int x, ObjectHandler oh){
        int yPos = Obstacle.MIN_TOP + (int)(Math.random() * Reference.GAME_HEIGHT - Obstacle.HOLE_SIZE-Obstacle.MIN_BOTTOM-Obstacle.MIN_TOP);
        yPos -= yPos%Obstacle.GENPOINT_DISTANCE;


        obstacles.add(new Obstacle(x,yPos-600, oh));
        obstacles.add(new Obstacle(x, yPos + Obstacle.HOLE_SIZE, oh));
    }
}
