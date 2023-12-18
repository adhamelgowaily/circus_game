/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

/**
 *
 * @author amrkh
 */
public class Plates extends ImageObject {
    
    private String color;
    private MovingBehaviour move;

    public Plates(int x, int y, String path, String color) {
        super(x, y, path);
        this.color = color;
        move = new ObjectBeforeIntersection();

    }
    
    public String getColor()
    {
        return this.color;
    }
    
    public void setMovingBehaviour(MovingBehaviour move)
    {
        this.move = move;
    }

    @Override
    public void setY(int y) {

        if( move instanceof ObjectBeforeIntersection)
        {
            super.setY(y);
        }
        else
        {
            //do nothing
        }
    }
}
