/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.awt.Color;

/**
 *
 * @author amrkh
 */
public class Plates extends ImageObject {
    
    private String color;
    
    public Plates(int x, int y, String path, String color) {
        super(x, y, path);
        this.color = color;
        
    }
    
    public String getColor()
    {
        return this.color;
    }
    
}
