/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author alu11563090
 */
public class SpecialFood extends Food {

    public SpecialFood(int row, int col) {
        super(row, col);
    }
    
    public void paint(Graphics g, int squareWidht, int squareHeight) {
        Color color = Color.RED;
        Util.drawSquare(g, getRow(), getCol(), color, squareWidht, squareHeight);
    }
    
}
