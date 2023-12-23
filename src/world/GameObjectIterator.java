package world;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Iterator;
import java.util.List;

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
