/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package world;

import eg.edu.alexu.csd.oop.game.GameObject;
import object.GameObjectFactory;

import java.util.List;

/**
 *
 * @author amrkh
 */
public class Easy extends GameBehaviour {

    // change speed
    // change number of bombs

    public Easy() {
        setBombNumber(2);
    }

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
