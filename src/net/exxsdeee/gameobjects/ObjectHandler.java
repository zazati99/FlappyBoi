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
        player = new Player(100, Reference.GAME_HEIGHT/2, this);

        generateObstacles(600,this);
        generateObstacles(950,this);
        generateObstacles(1300,this);

    }

    // uppdaterar alla objekt
    public void update(){

        player.update();

        //DIE om spelaren lämnar skärmen. Spelaren kan vara upp till 200 pixlar över skärmen utan att DIE.
        if(player.pos.y <= -200 || player.pos.y > Reference.GAME_HEIGHT-player.hitBox.y){
            die();
            return;
        }

        for (int i = 0; i < obstacles.size(); i++) {
            GameObject temp = obstacles.get(i);

            temp.update();

            if (collisionCheck(player, temp)){
                die();
                return;
            }

            if(temp.pos.x <= -250){

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

    boolean collisionCheck(GameObject o1, GameObject o2){

        if (o1.pos.x < o2.pos.x + o2.hitBox.x &&
                o1.pos.x + o1.hitBox.x > o2.pos.x &&
                o1.pos.y < o2.pos.y + o2.hitBox.y &&
                o1.hitBox.y + o1.pos.y > o2.pos.y){

            return true;

        }

        return false;
    }

    void generateObstacles(int x, ObjectHandler oh){
        int yPos = Obstacle.MIN_TOP + (int)(Math.random() * (Reference.GAME_HEIGHT -Obstacle.MIN_BOTTOM-Obstacle.MIN_TOP- Obstacle.HOLE_SIZE + Obstacle.GENPOINT_DISTANCE));
        yPos -= yPos%Obstacle.GENPOINT_DISTANCE;


        obstacles.add(new Obstacle(x,yPos-600, oh)); //600 is hard-coded height of obstacles.
        obstacles.add(new Obstacle(x, yPos + Obstacle.HOLE_SIZE, oh));
    }

    void die(){
        obstacles.clear();
        generateObstacles(600,this);
        generateObstacles(950,this);
        generateObstacles(1300,this);
        player = new Player(100, Reference.GAME_HEIGHT/2, this);
    }
}
