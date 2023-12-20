/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Random;

/**
 *
 * @author amrkh
 */
public class Factory implements GameObjectFactory {
    private static Factory instance = new Factory();

    private static int height;
    private static int width;
    private static int count;

    private Factory() {
    }

public static Factory getInstance(int height, int width)
{
        instance.height = height;
        instance.width = width;
        count = -35;
        return instance;
}

    /**
     *
     * @param type
     * @return
     */
    @Override
    public GameObject createGameObject(String type) {
        String path;
        int x = (int) (Math.random() * width);
        int y =  -1 * (int) (Math.random() * height);

        if (type.equals("plates")) {
            //return instance of plate class
            //int number = new Random().nextInt(2) + 1;
            String[] array = {"red", "blue", "green", "yellow","black","purple"};
            String color = array[new Random().nextInt(array.length)];
            int num = (new Random().nextInt(2)) + 1;
             path = color +","+ num + ".png";
            return new Plates(x, y, path,color);
           
        } else if (type.equals("bombs")) {
            path = "Bomb" + ".png";
            return new Bomb(x, y, path);
        } 
         else if (type.equals("character"))
        {
            path = "beli" + ".png";
            return new CharacterObject(width / 2, height - 230,path);
        }
         else
        {
            count = count + 35;
            return new ImageObject(0 + count,10,"heart.png");
        }
    }
}
