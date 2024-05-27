/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase de utilidad para dibujar un cuadrado en un componente gráfico.
 */
public class Util {
    
    /**
     * Método estático para dibujar un cuadrado en un componente gráfico.
     * @param g Objeto Graphics utilizado para dibujar.
     * @param row Fila en la que se dibuja el cuadrado.
     * @param col Columna en la que se dibuja el cuadrado.
     * @param color Color del cuadrado.
     * @param squareWidth Ancho del cuadrado.
     * @param squareHeight Alto del cuadrado.
     */
    public static void drawSquare(Graphics g, int row, int col, Color color,
                                    int squareWidth, int squareHeight) {
        int x = col * squareWidth;
        int y = row * squareHeight;
        
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth - 2, squareHeight - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight - 1, x, y);
        g.drawLine(x, y, x + squareWidth - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight - 1,
                x + squareWidth - 1, y + squareHeight - 1);
        g.drawLine(x + squareWidth - 1, y + squareHeight - 1,
                x + squareWidth - 1, y + 1);
    }
    
}
