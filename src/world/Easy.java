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
public class Easy extends GameBehaviour{

    //change speed
    //change number of bombs
    @Override
    public void bombIntersection(GameObject bomb, List<GameObject> constant) {
        if (getScore() >= 2)
          setScore(getScore() - 2);
        else {
            setScore(0);
        }
        constant.remove(getLives() - 1);
        setLives(getLives() - 1);
    }
    
}
