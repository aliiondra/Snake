/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase que representa un alimento especial en el juego de la serpiente.
 * Extiende la clase Food.
 */
public class SpecialFood extends Food {

     /**
     * Constructor de la clase SpecialFood.
     * @param row Fila en la que se encuentra el alimento especial.
     * @param col Columna en la que se encuentra el alimento especial.
     */
    public SpecialFood(int row, int col) {
        super(row, col);
    }
    
    /**
     * Método para dibujar el alimento especial en el tablero.
     * @param g Objeto Graphics utilizado para dibujar.
     * @param squareWidht Ancho del cuadrado del tablero.
     * @param squareHeight Alto del cuadrado del tablero.
     */
    public void paint(Graphics g, int squareWidht, int squareHeight) {
        Color color = Color.RED; // Establece el color del alimento especial como rojo.
        Util.drawSquare(g, getRow(), getCol(), color, squareWidht, squareHeight); // Dibuja el cuadrado del alimento especial en la posición especificada.
    }
    
}
