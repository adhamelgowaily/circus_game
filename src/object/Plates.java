/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import object.Hand;

/**
 *
 * @author amrkh
 */
public class Plates extends ImageObject {

    private String color;
    private MovingBehaviour move;
    private Hand hand = null;

    public Plates(int x, int y, String path, String color) {
        super(x, y, path);
        this.color = color;
        move = new ObjectBeforeIntersection();

    }

    public String getColor() {
        return this.color;
    }

    public void setMovingBehaviour(MovingBehaviour move) {
        this.move = move;
    }

    public void setHand(Hand h) {
        this.hand = h;
    }

    @Override
    public void setY(int y) {

        if (move instanceof ObjectBeforeIntersection) {
            super.setY(y);
        } else {
            // do nothing
        }
    }

    @Override
    public void setX(int x) {
        if (hand == Hand.Right) {
            if (x <= 191 - getWidth()) {
                //do nothing
            } else {
                super.setX(x);
            }
        } else if (hand == Hand.Left) {
            if (x >= 900 - 191) {
                //do nothing
            } else {
                super.setX(x);
            }
        } else {
            super.setX(x);
        }
    }
}
