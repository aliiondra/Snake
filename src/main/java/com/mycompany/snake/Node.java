/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

/**
 * Representa un nodo en el tablero del juego de la serpiente.
 * Cada nodo tiene una fila y una columna que indican su posición en el tablero.
 */
public class Node {
    private int row;
    private int col;

     /**
     * Constructor de la clase Node.
     * @param row La fila del nodo en el tablero.
     * @param col La columna del nodo en el tablero.
     */
    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Obtiene la fila del nodo en el tablero.
    public int getRow() {
        return row;
    }

    //Obtiene la columna del nodo en el tablero.
    public int getCol() {
        return col;
    }
}
