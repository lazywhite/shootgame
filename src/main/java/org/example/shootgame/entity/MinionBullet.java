package org.example.shootgame.entity;

import org.example.shootgame.start.GameConfig;
import org.example.shootgame.lib.Image;


/**
 * Created by white on 17/6/9.
 */
public class MinionBullet extends Item {
    private int speed = 2;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public MinionBullet(int x, int y){
        this.x = x;
        this.y = y;
        this.image = Image.loadImage("images/bullet.png");
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }
    @Override
    public void move() {
        this.y += this.speed;
    }

    @Override
    public boolean outOfBounds() {
        return this.y > GameConfig.HEIGHT;
    }
}
