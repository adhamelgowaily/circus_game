/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;



/**
 *
 * @author amrkh
 */
public abstract class ImageObject implements GameObject{
    
    BufferedImage[] images ;
    private int x;
    private int y;	
    private boolean visible;
        
    public ImageObject(int x, int y, String path)
    {
        
            this.x = x;
            this.y = y;
            this.visible = true;
            images = new BufferedImage[1];
            
            try {
            images[0] = ImageIO.read(new File(path));   
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
     
    
    
    
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return images[0].getWidth();
    }

    @Override
    public int getHeight() {
        return images[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return images;
    }
    
}
