package object;

import eg.edu.alexu.csd.oop.game.GameObject;

public interface GameObjectFactory {
    GameObject createGameObject(String type);
    
}
