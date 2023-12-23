package world;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;

public class Hard extends GameBehaviour {

    public Hard() {
        setBombNumber(6);
        setPlatesNumber(30);

    }

    @Override
    public void bombIntersection(List<GameObject> constant) {
        if (getScore() >= 3)
            setScore(getScore() - 3);
        else {
            setScore(0);
        }
        if (getLives() > 0) {
            constant.remove(getLives());
            constant.remove(getLives() - 1);
            setLives(getLives() - 2);
        }
    }
}
