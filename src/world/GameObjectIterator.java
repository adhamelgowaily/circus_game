/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package world;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author amrkh
 */
public class GameObjectIterator implements Iterator<GameObject>{
    private List<GameObject> objects;
    private int index;
    
    public GameObjectIterator(List<GameObject> objects)
    {
        this.objects = objects;
        this.index = 0;
    }


    @Override
    public boolean hasNext() {
        return index < objects.size();
    }

    @Override
    public GameObject next() {
       
            GameObject current = objects.get(index);
            index++;
            return current;
       
    }
    
}
