package org.example.shootgame.entity;

import org.example.shootgame.start.GameConfig;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by white on 17/6/8.
 */
public class Plane extends Item {
    private BufferedImage[] images;
    //当前图片所属下标
    private int index;
    private int doubleFire;
    private int life;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDoubleFire() {
        return doubleFire;
    }

    public void setDoubleFire(int doubleFire) {
        this.doubleFire = doubleFire;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Plane(){
        this.life = 3;
        this.images = new BufferedImage[2];
        try {
            images[0] = ImageIO.read(new File("images/plane01.png"));
            images[1] = ImageIO.read(new File("images/plane02.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.image = this.images[0];
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.x = (GameConfig.WIDTH  - this.width)/2;
        this.y = (GameConfig.HEIGHT - this.height)/2;
    }

    public void changeImage(){
        this.index = (++this.index)%2;
        this.image = this.images[this.index];
    }
    @Override
    public void move(){
    }

    public void moveTo(int x, int y) {
        this.x = x - this.width/2;
        this.y = y - this.height/2;

    }

    @Override
    public boolean outOfBounds() {
        return false;
    }

    public List<Bullet> shoot(){
        ArrayList<Bullet> bullets = new ArrayList<>();
        if(this.doubleFire >= 2){
            bullets.add(new Bullet(this.getX() + this.getWidth()/4, this.getY()));
            bullets.add(new Bullet(this.getX() + (3 * this.getWidth()/4), this.getY()));
            return bullets;
        }else{
            bullets.add(new Bullet(this.getX() + this.getWidth()/2, this.getY()));
            return bullets;
        }
    }
}
