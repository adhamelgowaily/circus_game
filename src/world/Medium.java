package world;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Medium extends GameBehaviour{

    @Override
    public void bombIntersection(List<GameObject> constant) {
        if (getScore() >= 2)
            setScore(getScore() - 2);
        else {
            setScore(0);
        }
        if (getLives() == 0) {
            //do nothing
        } else {
            constant.remove(getLives() - 1);
            setLives(getLives() - 1);
        }
    }
    
}
