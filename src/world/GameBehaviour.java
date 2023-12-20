/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import object.Factory;
import object.GameObjectFactory;
import object.Plates;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author amrkh
 */
public abstract class GameBehaviour {
    private Stack<Plates> leftStack = new Stack<Plates>();
    private Stack<Plates> righStack = new Stack<Plates>();

    private boolean stackFlag;
    private int score;
    private int lives = 6;
    private int bombNumber;

    private int leftNum;
    private int rightNum;

    public void plateIntersection(GameObject o1, GameObject o2, List<GameObject> control) {
        Plates first, second;
        if (((o2.getX() + o2.getWidth()) >= o1.getX() && o2.getX() <= (o1.getX() + 27))) //left
        {
            leftNum++;
            o2.setX(o1.getX() - 10);
            if (leftStack.isEmpty() || leftStack.size() == 1)
                leftStack.push((Plates) o2);
            else {
                first = leftStack.pop();
                second = leftStack.pop();
                if (((Plates) o2).getColor().equals(first.getColor()) && ((Plates) o2).getColor().equals(second.getColor())) //3 plates same color
                {
                    stackFlag = true;
                    leftNum = leftNum - 3;
                    o2.setY(-10);
                    control.remove(first);
                    control.remove(second);
                } else {
                    leftStack.push(second);
                    leftStack.push(first);
                    leftStack.push((Plates) o2);
                }
            }
        } else //right
        {
            rightNum++;
            o2.setX(o1.getX() + o1.getWidth() - 37);
            if (righStack.isEmpty() || righStack.size() == 1)
                righStack.push((Plates) o2);
            else {
                first = righStack.pop();
                second = righStack.pop();
                if (((Plates) o2).getColor().equals(first.getColor()) && ((Plates) o2).getColor().equals(second.getColor())) //3 plates same color
                {
                    stackFlag = true;
                    rightNum = rightNum - 3;
                    o2.setY(-10);
                    control.remove(first);
                    control.remove(second);
                } else {
                    righStack.push(second);
                    righStack.push(first);
                    righStack.push((Plates) o2);
                }
            }
        }
    }

    public abstract void bombIntersection(List<GameObject> constant);

    public int getLeftNum() {
        return leftNum;
    }

    public int getRightNum() {
        return rightNum;
    }

    public boolean isStackFlag() {
        return stackFlag;
    }

    public void setStackFlag(boolean stackFlag) {
        this.stackFlag = stackFlag;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public void setBombNumber(int bombNumber) {
        this.bombNumber = bombNumber;
    }

    public int getBombNumber() {
        return bombNumber;
    }
}
