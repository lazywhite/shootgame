package org.example.shootgame.entity;

import org.example.shootgame.lib.Image;
import org.example.shootgame.start.GameConfig;

import java.util.Random;

/**
 * Created by white on 17/6/9.
 */
public class Bee extends Item implements Award {
    private int xSpeed = 3;
    private int ySpeed = 3;
    private int awardType;
    private String xdir;

    public Bee(){
        this.image = Image.loadImage("images/bee.png");
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.y = - this.height;
        Random r  = new Random();
        this.x = r.nextInt(GameConfig.WIDTH - this.width);
        this.awardType = this.getType();

        if(this.x < GameConfig.WIDTH/2){
            this.xdir="right";
        }else{
            this.xdir="left";
        }

    }

    @Override
    public void move() {
        if(this.x >= GameConfig.WIDTH - this.width){
            this.xdir = "left";
        }
        if(this.x <= 0){
            this.xdir = "right";
        }
        if(this.xdir == "left"){
            this.x -= this.xSpeed;
        }
        if(this.xdir == "right"){
            this.x += this.xSpeed;
        }
        this.y += this.ySpeed;
    }

    @Override
    public boolean outOfBounds() {
        return this.y > GameConfig.HEIGHT;
    }

    @Override
    public int getType() {
        Random r = new Random();
        this.awardType = r.nextInt(2);
        return this.awardType;
    }
}
