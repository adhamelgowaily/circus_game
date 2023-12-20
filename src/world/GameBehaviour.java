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
    private Stack<Plates> lefStack = new Stack<Plates>();
    private Stack<Plates> righStack = new Stack<Plates>();
    private boolean stackFlag;
    private int score;
    private int lives = 5;

    private int leftNum;
    private int rightNum;

    public void plateIntersection(GameObject o1, GameObject o2, List<GameObject> control)
    {
        if (((o2.getX() + o2.getWidth()) >= o1.getX() && o2.getX() <= (o1.getX() + 27))) //left
        {
            leftNum++;
            o2.setX(o1.getX() - 10);
            if (!lefStack.isEmpty())
            {
                if (lefStack.size() == 1)
                {
                    if (((Plates) o2).getColor().equals(lefStack.peek().getColor()))
                    {
                        lefStack.push(((Plates) o2));
                    } else
                    {
                        lefStack.pop();
                        lefStack.push(((Plates) o2));
                    }
                }
                    else if (lefStack.size() == 2)
                {
                    if (((Plates) o2).getColor().equals(lefStack.peek().getColor()))  //3 plates same color
                    {
                        stackFlag = true;
                        o2.setY(-10);
                        leftNum = leftNum - 3;
                        while (!lefStack.isEmpty())
                        {
                            Plates p = lefStack.pop();
                            control.remove(p);
                        }
                    }
                    else {
                        while (!lefStack.isEmpty()) {
                            lefStack.pop();
                        }
                        lefStack.push(((Plates) o2));
                    }
                }
            }
            else //stack is empty
            {
                lefStack.push((Plates) o2);
            }
        }
        else //right
        {
            rightNum++;
            o2.setX(o1.getX() + o1.getWidth() - 37);
            if (!righStack.isEmpty())
            {
                if (righStack.size() == 1)
                {
                    if (((Plates) o2).getColor().equals(righStack.peek().getColor()))
                    {
                        righStack.push(((Plates) o2));
                    } else
                    {
                        righStack.pop();
                        righStack.push(((Plates) o2));
                    }
                }
                else if (righStack.size() == 2)
                {
                    if (((Plates) o2).getColor().equals(righStack.peek().getColor()))  //3 plates same color
                    {
                        stackFlag = true;
                        o2.setY(-10);
                        rightNum = rightNum - 3;
                        while (!righStack.isEmpty())
                        {
                            Plates p = righStack.pop();
                            control.remove(p);
                        }
                    }
                    else
                    {
                        while (!righStack.isEmpty()) {
                            righStack.pop();
                        }
                        righStack.push(((Plates) o2));
                    }
                }
            }
            else //stack is empty
            {
                righStack.push((Plates) o2);
            }
        }
    }
    
    public abstract void bombIntersection(GameObject bomb,List<GameObject> constant);

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
}
