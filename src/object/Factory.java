package object;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Random;

public class Factory implements GameObjectFactory {
    private static Factory instance = new Factory();

    //frame height and width
    private static int height;
    private static int width;
    //location for the heart 
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
            //ball colors
            String[] array = {"red", "blue", "green", "yellow","black","purple"};
            String color = array[new Random().nextInt(array.length)];
            //for every colour there is a flat ball and full ball: 1 & 2
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
