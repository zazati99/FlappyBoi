package net.exxsdeee.gameobjects;

import net.exxsdeee.Reference;
import net.exxsdeee.ui.GameFrame;
import net.exxsdeee.utils.Vector2;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sebastianjohansson on 2017-08-25.
 */
public class ObjectHandler {

    public enum State{
        ALIVE, FALLING, DEAD
    }

    public State state = State.ALIVE;
    private final String infoScreenText = "Press space to jump!";

    private final Color infoScreenColor = new Color(0.8f, 0.8f, 0.8f);
    private final Vector2 infoScreenSize= new Vector2(350,300);
    ArrayList<GameObject> obstacles = new ArrayList<>();
    Player player;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        GameFrame.infoPanel.updateScore(score);
    }

    int score = 0;

    public ObjectHandler(){
        newGame();
        player.flap();
    }

    // uppdaterar alla objekt
    public void update(){

        if(state == State.ALIVE) {
            player.update();

            //DIE om spelaren lämnar skärmen. Spelaren kan vara upp till 200 pixlar över skärmen utan att DIE.
            if (player.pos.y <= -200 || player.pos.y > Reference.GAME_HEIGHT - player.hitBox.y) {
                death();
                return;
            }

            for (int i = 0; i < obstacles.size(); i++) {
                GameObject temp = obstacles.get(i);

                temp.update();

                if (collisionCheck(player, temp)) {
                    startFall();
                    return;
                }

                if (temp.pos.x <= -250) {  //OBS:  Avståndet mellan de gamla och nya obstaclerna måste vara delbart med obstacles hastighet.

                    if (temp.pos.y <= 0) {
                        generateObstacles(Reference.GAME_WIDTH, this);
                    }
                    obstacles.remove(temp);
                    i--; //Index flyttas bakåt när man tar bort ett objekt.
                }
            }
        }

        else if ( state == State.FALLING){
            player.update();

            if(player.pos.y > Reference.GAME_HEIGHT -player.hitBox.y){

            }
        }
    }

    // målar alla object
    public void render(Graphics g){
        player.render(g);

        for (int i = 0; i < obstacles.size(); i ++) {
            obstacles.get(i).render(g);
        }
        if(state == State.DEAD){
            g.setColor(infoScreenColor);
            g.fillRect((int)((Reference.GAME_WIDTH - infoScreenSize.x) / 2), (int)((Reference.GAME_HEIGHT-infoScreenSize.y )/2), (int)infoScreenSize.x, (int)infoScreenSize.y);
            g.setColor(Color.black);
            g.drawString(infoScreenText, Reference.GAME_HEIGHT/ 2 , Reference.GAME_WIDTH/2-50);
        }
    }

    boolean collisionCheck(GameObject o1, GameObject o2){

        return o1.pos.x < o2.pos.x + o2.hitBox.x &&
                o1.pos.x + o1.hitBox.x > o2.pos.x &&
                o1.pos.y < o2.pos.y + o2.hitBox.y &&
                o1.hitBox.y + o1.pos.y > o2.pos.y;

    }

    void generateObstacles(int x, ObjectHandler oh){
        int yPos = Obstacle.MIN_TOP + (int)(Math.random() * (Reference.GAME_HEIGHT -Obstacle.MIN_BOTTOM-Obstacle.MIN_TOP- Obstacle.HOLE_SIZE + Obstacle.GENPOINT_DISTANCE));
        yPos -= yPos%Obstacle.GENPOINT_DISTANCE;


        obstacles.add(new Obstacle(x,yPos-600, oh)); //600 is hard-coded height of obstacles.
        obstacles.add(new Obstacle(x, yPos + Obstacle.HOLE_SIZE, oh));
    }

    public void newGame(){
        obstacles.clear();
        generateObstacles(600,this);
        generateObstacles(950,this);
        generateObstacles(1300,this);
        player = new Player(100, Reference.GAME_HEIGHT/2, this);
        setScore(0);
    }

    public void startGame(){
        state = State.ALIVE;
    }

    void death(){
        state = State.DEAD;
        player.GRAV_ACC = 0f;
        player.velocity = new Vector2(0,0);
    }

    void startFall(){
        state = State.FALLING;
    }


    public Player getPlayer() {
        return player;
    }

    public State getState() {
        return state;
    }

}
