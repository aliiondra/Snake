/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.border.Border;

/**
 * Clase que representa la comida en el juego de la serpiente.
 * Extiende la clase Node para heredar las coordenadas de posición.
 */
public class Food extends Node {

    /**
     * Constructor de la clase Food.
     * @param row Fila donde se ubicará la comida.
     * @param col Columna donde se ubicará la comida.
     */
    public Food(int row, int col) {
        super(row, col); // Llama al constructor de la clase base (Node) con las coordenadas dadas.
    }
    
    /**
     * Método para dibujar la comida en el tablero.
     * @param g Objeto Graphics para dibujar.
     * @param squareWidth Ancho del cuadrado del tablero.
     * @param squareHeight Alto del cuadrado del tablero.
     */
    public void paint(Graphics g, int squareWidht, int squareHeight) {
        Color color = Color.BLUE; // Color de la comida (azul).
        Util.drawSquare(g, getRow(), getCol(), color, squareWidht, squareHeight); // Dibuja un cuadrado en la posición de la comida.
    }
    
    
  
    
    
}
