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
public class Hard extends GameBehaviour{


    public Hard ()
    {
        setBombNumber(100);
    }

    @Override
    public void bombIntersection(List<GameObject> constant)
    {
        if (getScore() >= 4)
            setScore(getScore() - 4);
        else {
            setScore(0);
        }
        constant.remove(getLives() - 1);
        constant.remove(getLives() - 2);
        setLives(getLives() - 2);
    }
}
