package world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.LinkedList;
import java.util.List;
import object.*;


public class CircusOfPlates implements World {
    
    private static int MAX_TIME = 60 * 1000;//one minute
    private long startTime;
    private int score = 0;
    private final int width;
    private final int height;
    //difficulty
    private GameBehaviour strategy;

    GameObjectFactory factory;
    GameObjectIterator iterator;

    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();

    public CircusOfPlates(int width, int height, GameBehaviour strategy) {
        startTime = System.currentTimeMillis();
        this.width = width;
        this.height = height;
        this.strategy = strategy;
        factory = Factory.getInstance(height, width);
        createObjects();
    }

    public void createObjects() {
        for (int i = 0; i < strategy.getPlatesNumber(); i++) {
            moving.add(factory.createGameObject("plates"));
        }
        for (int i = 0; i < strategy.getBombNumber(); i++) {
            moving.add(factory.createGameObject("bombs"));
        }
        control.add(factory.createGameObject("character"));

        for (int i = 0; i < 6; i++)
            constant.add(factory.createGameObject("heart"));
    }

    private boolean intersect(GameObject o1, GameObject o2) {
        if (o2 instanceof Plates && o1 instanceof CharacterObject) {
            return (((o1.getY() - strategy.getHeightOfStack(strategy.getLeftStack()) == o2.getY() + o2.getHeight()) &&
                    (((o2.getX() + o2.getWidth()) >= o1.getX() && o2.getX() <= (o1.getX() + o2.getWidth())))//left hand
                    ||
                    ((o1.getY() - (strategy.getHeightOfStack(strategy.getRighStack())) == o2.getY() + o2.getHeight()) &&
                            ((o2.getX() + o2.getWidth()) >= (o1.getX() + o1.getWidth() - o2.getWidth()) && o2.getX() <= (o1.getX() + o1.getWidth())))));//right hand
        } else // bomb
        {
            return (o1.getY() == o2.getY() + o2.getHeight())
                    && ((o2.getX() + o2.getWidth()) > o1.getX() && o2.getX() < (o1.getX() + o1.getWidth()));
        }
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
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME;//checking if more than a minute passed
        iterator = new GameObjectIterator(moving);
        //using iterator to loop over the falling objects
        while (iterator.hasNext()) {
            GameObject o = iterator.next();
            o.setY(o.getY() + 1);//make them fall downwards in frame
            if (intersect(beli, o)) {
                if (o instanceof Plates) {
                    strategy.plateIntersection(beli, o, control);
                    moving.add(factory.createGameObject("plates")); // generate new shape after intersection
                    if (!strategy.isStackFlag()) {
                        //plate landed on hands or stack
                        control.add(o);
                        moving.remove(o);
                        ((Plates) o).setMovingBehaviour(new ObjectAfterIntersection());// so it doesnt move vertically
                    } else 
                    {
                        //three objects of same colour match
                        strategy.setScore(strategy.getScore() + 1);
                        startTime += 10000;
                        strategy.setStackFlag(false);
                    }
                } else {
                    //bomb object
                    moving.remove(o);
                    strategy.bombIntersection(constant);
                    moving.add(factory.createGameObject("bombs"));
                }

            }
            if (o.getY() == getHeight()) {
                // reuse any movable object in another position
                o.setY(-1 * (int) (Math.random() * getHeight()));
                o.setX((int) (Math.random() * getWidth()));
            }
        }
        GameObjectIterator iter = new GameObjectIterator(control);
        boolean topReached = false;
        //looping over the objects in the stack to check if any reached top of frame
        while (iter.hasNext()) {
            if (iter.next().getY() <= 0) {
                topReached = true;
            }
        }
        //game ends in three ways: time ends, lives finish, stack reached top
        return !timeout && !(constant.size() == 0) && !topReached;
    }

    //status bar
    @Override
    public String getStatus() {
        return "Score:" + strategy.getScore() + "      Number of Lives: " + strategy.getLives() + "      Time="
                + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);
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
