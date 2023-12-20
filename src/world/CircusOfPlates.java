/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


import javax.print.attribute.standard.Media;

import object.*;

/**
 *
 * @author amrkh
 */
public class CircusOfPlates implements World {
    private static int MAX_TIME = 60 * 1000;
	private long startTime = System.currentTimeMillis();
    private int score = 0;
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
        createObjects();
    }

    public void createObjects()
    {
        for (int i = 0; i < 10; i++) {
            moving.add(factory.createGameObject("plates"));
        }

        for (int i = 0; i < strategy.getBombNumber(); i++) {
            moving.add(factory.createGameObject("bombs"));
        }
        control.add(factory.createGameObject("character"));

        for (int i =0; i < 6; i++)
            constant.add(factory.createGameObject("heart"));
    }

    private boolean intersect(GameObject o1, GameObject o2) {
        if (o2 instanceof Plates && o1 instanceof CharacterObject) {
            if (((o1.getY() - (o2.getHeight() * num_Intersection_LeftHand) == o2.getY() + o2.getHeight()) &&
                    (((o2.getX() + o2.getWidth()) >= o1.getX() && o2.getX() <= (o1.getX() + o2.getWidth())))
            return (((o1.getY() - (o2.getHeight() * strategy.getLeftNum()) == o2.getY() + o2.getHeight()) &&
                    (((o2.getX() + o2.getWidth()) >= o1.getX() && o2.getX() <= (o1.getX() + 27)))
                    ||
                    ((o1.getY() - (o2.getHeight() * num_Intersection_RightHand) == o2.getY() + o2.getHeight()) &&
                            ((o2.getX() + o2.getWidth()) >= (o1.getX() + o1.getWidth() - o2.getWidth())
                                    && o2.getX() <= (o1.getX() + o1.getWidth()))))) {

                if (((o2.getX() + o2.getWidth()) >= o1.getX() && o2.getX() <= (o1.getX() + o2.getWidth()))) {
                    // left hand
                    moving.add(factory.createGameObject("plates"));
                    num_Intersection_LeftHand++;
                    o2.setX(o1.getX());
                    ((Plates) o2).setHand(Hand.Left);
                    if (!lefStack.isEmpty()) {
                        if (lefStack.size() == 1) {
                            if (((Plates) o2).getColor().equals(lefStack.peek().getColor())) {
                                lefStack.push(((Plates) o2));
                            } else {
                                lefStack.pop();
                                lefStack.push(((Plates) o2));
                            }
                        } else if (lefStack.size() == 2) {
                            if (((Plates) o2).getColor().equals(lefStack.peek().getColor())) {
                                startTime += 10000;
                                score += 5;
                                stackFlag = true;
                                o2.setY(-10);
                                num_Intersection_LeftHand = num_Intersection_LeftHand - 3;

                                while (!lefStack.isEmpty()) {
                                    Plates p = lefStack.pop();

                                    control.remove(p);

                                    // make new plates instead

                                    p.setMovingBehaviour(new ObjectBeforeIntersection()); // moves vertically

                                }

                            } else {
                                while (!lefStack.isEmpty()) {
                                    lefStack.pop();

                                }
                                lefStack.push(((Plates) o2));
                            }
                        }
                    } else {
                        lefStack.push(((Plates) o2));

                    }

                } else {
                    moving.add(factory.createGameObject("plates"));
                    num_Intersection_RightHand++;
                    o2.setX(o1.getX() + o1.getWidth() - o2.getWidth());
                    ((Plates) o2).setHand(Hand.Right);
                    if (!righStack.isEmpty()) {
                        if (righStack.size() == 1) {
                            if (((Plates) o2).getColor().equals(righStack.peek().getColor())) {
                                righStack.push(((Plates) o2));
                            } else {
                                righStack.pop();
                                righStack.push(((Plates) o2));
                            }
                        } else if (righStack.size() == 2) {
                            if (((Plates) o2).getColor().equals(righStack.peek().getColor())) {
                                startTime += 10000;
                                score += 5;
                                stackFlag = true;
                                o2.setY(-10);
                                num_Intersection_RightHand = num_Intersection_RightHand - 3;

                                while (!righStack.isEmpty()) {
                                    Plates p = righStack.pop();

                                    control.remove(p);
                                    p.setMovingBehaviour(new ObjectBeforeIntersection()); // moves vertically

                                }

                            } else {
                                while (!righStack.isEmpty()) {
                                    righStack.pop();
                                }
                                righStack.push(((Plates) o2));

                            }
                        }
                    } else {
                        righStack.push(((Plates) o2));

                    }

                }

                return true;

            } else {
                return false;
            }

        } else {
            // bomb
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
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME;
        ImageObject beli = (ImageObject) control.get(0);
        iterator = new GameObjectIterator(moving);
        while (iterator.hasNext()) {
            GameObject o = iterator.next();
            o.setY(o.getY() + 1);
            if (intersect(beli, o)) {
                // control.add(o);
                // moving.remove(o);
                if (o instanceof Plates && stackFlag == false) {

                    control.add(o);
                    moving.remove(o);
                    ((Plates) o).setMovingBehaviour(new ObjectAfterIntersection());// so it doesnt move vertically

                } else {
                    stackFlag = false;

                }
            }

            if (o.getY() == getHeight()) {
                // reuse the plate in another position
                o.setY(-1 * (int) (Math.random() * getHeight()));
                o.setX((int) (Math.random() * getWidth()));
            }
        }

        return true;
    }

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
