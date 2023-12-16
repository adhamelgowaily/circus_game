/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package object;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author amrkh
 */
public interface GameObjectFactory {
    GameObject createGameObject(String type);
    
}
