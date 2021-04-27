package org.example.shootgame.lib;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Image {
    public static BufferedImage loadImage(String path){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(path);
        BufferedImage bi = null;
        try{
            bi  = ImageIO.read(is);
        }catch(IOException e){
            e.printStackTrace();
        }
        return bi;
    }
}
