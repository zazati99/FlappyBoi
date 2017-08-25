package net.exxsdeee.utils;

/**
 * Created by sebastianjohansson on 2017-08-25.
 */
public class Vector2 {

    public float x;
    public float y;

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 vec){
        this.x += vec.x;
        this.y += vec.y;
    }

    public void subtract(Vector2 vec){
        this.x -= vec.x;
        this.y -= vec.y;
    }

    public void set(float x, float y){
        this.x = x;
        this.y = y;
    }

}
