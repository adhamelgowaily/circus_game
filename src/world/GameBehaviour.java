package world;

import eg.edu.alexu.csd.oop.game.GameObject;
import object.Hand;
import object.Plates;

import java.util.List;
import java.util.Stack;

public abstract class GameBehaviour {
    private Stack<Plates> leftStack = new Stack<Plates>();
    private Stack<Plates> righStack = new Stack<Plates>();

    private boolean stackFlag;
    private int score;
    private int lives = 6;
    private int bombNumber;
    private int platesNumber;
    private int leftNum;
    private int rightNum;

    public void plateIntersection(GameObject o1, GameObject o2, List<GameObject> control) {
        Plates first, second;
        if (((o2.getX() + o2.getWidth()) >= o1.getX() && o2.getX() <= (o1.getX() + o2.getWidth()))) //left
        {
            leftNum++;
            o2.setX(o1.getX());
            ((Plates) o2).setHand(Hand.Left);
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
            o2.setX(o1.getX() + o1.getWidth() - o2.getWidth());
            ((Plates) o2).setHand(Hand.Right);
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

    public int getHeightOfStack(Stack<Plates> s1)
    {
        Stack<Plates> s2 = new Stack<>();
        int length = 0;
        while(!s1.empty())
        {
            length += s1.peek().getHeight();
            s2.push(s1.pop());
        }
        while(!s2.empty())
        {
            s1.push(s2.pop());
        }
        return length;
    }

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

    public int getPlatesNumber() {
        return this.platesNumber;
    }

    public void setPlatesNumber(int platesNumber) {
        this.platesNumber = platesNumber;
    }

    public Stack<Plates> getLeftStack() {
        return this.leftStack;
    }

    public Stack<Plates> getRighStack() {
        return this.righStack;
    }
}
