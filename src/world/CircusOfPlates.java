/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.LinkedList;
import java.util.List;
import object.*;

/**
 *
 * @author amrkh
 */
public class CircusOfPlates implements World {

    private final int width;
    private final int height;
    private GameBehaviour strategy;

    GameObjectFactory factory;
    GameObjectIterator iterator;

    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();

    public CircusOfPlates(int width, int height, GameBehaviour strategy) {
        this.width = width;
        this.height = height;
        this.strategy = strategy;

        factory = new Factory(height, width);
        //create movable (Plates)
        for (int i = 0; i < 10; i++) {
            moving.add(factory.createGameObject("plates"));
        }

        for (int i = 0; i < 1; i++) {
            moving.add(factory.createGameObject("bombs"));
        }

        control.add(factory.createGameObject("character"));

        //create controllable 
    }

    private boolean intersect(GameObject o1, GameObject o2) {
        return //( Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight());
                (o1.getY() == o2.getY() + o2.getHeight()) && ((o2.getX() + o2.getWidth()) > o1.getX() && o2.getX() < (o1.getX() + o1.getWidth()));
        //Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth()) &&
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean refresh() {
        ImageObject beli = (ImageObject) control.get(0);

        iterator = new GameObjectIterator(moving);
        while (iterator.hasNext()) {
            GameObject o = iterator.next();
            o.setY(o.getY() + 1);
            if (intersect(beli, o) ) {
                control.add(o);
                moving.remove(o);
                System.out.println("intersected");
            }

            if (o.getY() == getHeight()) {
                // reuse the alien in another position
                o.setY(-1 * (int) (Math.random() * getHeight()));
                o.setX((int) (Math.random() * getWidth()));
            }

        }

        return true;
    }

    @Override
    public String getStatus() {
        return "Score:";
    }

    @Override
    public int getSpeed() {
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return 20;

    }
}
