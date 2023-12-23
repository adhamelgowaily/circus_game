package world;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;

public class Easy extends GameBehaviour {

    public Easy() {
        setBombNumber(2);
        setPlatesNumber(10);
    }

    @Override
    public void bombIntersection(List<GameObject> constant) {
        if (getScore() >= 1)
            setScore(getScore() - 1);
        else {
            setScore(0);
        }
        if (getLives() == 0) {
            // do nothing
        } else {
            constant.remove(getLives() - 1);
            setLives(getLives() - 1);
        }
    }

}
