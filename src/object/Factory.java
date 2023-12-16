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
public class Factory implements GameObjectFactory{
    
   private int height;
   private int width;
   
   public Factory(int height,int width)
   {
       this.height = height;
       this.width = width;
   }
   
    /**
     *
     * @param type
     * @return
     */
    @Override
    public GameObject createGameObject(String type) 
    {
       int x = (int) (Math.random() * width);
       int y = (int) (Math.random() * (height / 2));
       
       if(type.equals("plates"))
       {
           //return instance of plate class
       }
       else
       {
           //return instance of bombs
           
       }
       
//       int number =  new Random().nextInt(2) + 1;
//       String[] array = {"red","blue","green","orange"};
//       String color = array[new Random().nextInt(array.length)];
//       String path = color + "," + number + ".png";
//       
//            System.out.println(path);
//          return new ImageObject(x, y, path);
    }      
   
}
