/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa la serpiente en el juego.
 */
public class Snake {

    private List<Node> nodes; // Lista de nodos que forman la serpiente
    private Direction direction; // Dirección actual de la serpiente
    private int nodesToGrow; // Número de nodos que la serpiente debe crecer
    
    /**
     * Constructor de la clase Snake. Inicializa la serpiente con una longitud y dirección predeterminadas.
     */
    public Snake() {
        // Inicializar la serpiente con una longitud predeterminada y en una posición central
        nodes = new ArrayList<Node>();
        nodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2));
        nodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 1));
        nodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 2));
        nodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 3));
        direction = Direction.RIGHT; // Inicialmente la serpiente se mueve hacia la derecha
        nodesToGrow = 0; // No hay crecimiento inicial
    }
    
    // Devuelve la lista de nodos que forman la serpiente.
    public List<Node> getNodes() {
        return nodes;
    }

    // Establece la dirección de la serpiente.
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    // Dibuja la serpiente en el panel de juego.
    public void paint(Graphics g, int squareWidht, int squareHeight) {
        boolean firstNode = true;
        Color color;
        for (Node node : nodes) {
            if (firstNode) {
                color = Color.pink; // El primer nodo es la cabeza, se dibuja de color rosa
                firstNode = false;
            } else {
                color = Color.yellow; // Los nodos restantes se dibujan de color amarillo
            }
            Util.drawSquare(g, node.getRow(), node.getCol(), color, squareWidht, squareHeight);
        }
    }

    // Devuelve el nodo de la cabeza de la serpiente.
    public Node getHeadNode() {
        return nodes.get(0);
    }

    // Devuelve el nodo de la cola de la serpiente.
    public Node getTailNode() {
        return nodes.get(nodes.size() - 1);
    }

    // Mueve la serpiente en la dirección actual.
    public void move() {
        int currentRow = getHeadNode().getRow();
        int currentCol = getHeadNode().getCol();
        switch (direction) {
            case UP:
                currentRow--;
                break;
            case DOWN:
                currentRow++;
                break;
            case LEFT:
                currentCol--;
                break;
            case RIGHT:
                currentCol++;
                break;
        }
        Node newNode = new Node(currentRow, currentCol);
        if (canMove()) {
                nodes.add(0, newNode); // Agrega un nuevo nodo en la dirección de movimiento
            if (nodesToGrow == 0) {
                nodes.remove(getTailNode()); // Si no hay crecimiento, elimina el último nodo (cola)
            } else if (nodesToGrow > 0) {
                nodesToGrow--; // Reduce el número de nodos que deben crecer
            }
        }
    }

    // Verifica si la serpiente puede moverse sin colisionar con los bordes del tablero.
    public boolean canMove() {
        Node node = getHeadNode();
        return !(node.getRow() < 0 || node.getRow() >= Board.NUM_ROWS
                || node.getCol() < 0 || node.getCol() >= Board.NUM_COLS);
    }
    
    // Verifica si la serpiente ha colisionado con los bordes del tablero.
    public boolean checkBorderCollision() {
        Node head = getHeadNode();
        return head.getRow() < 0 || head.getRow() >= Board.NUM_ROWS
                || head.getCol() < 0 || head.getCol() >= Board.NUM_COLS;
    }
    
    // Verifica si la serpiente colisiona con las coordenadas dadas.
    public boolean collidesWith(int row, int col) {
       for (Node node : nodes) {
        if (node.getRow() == row && node.getCol() == col) {
            return true;
        }
    }
    return false;
    }
    
    // Verifica si la serpiente ha colisionado consigo misma.
    public boolean checkSelfCollision() {
        Node head = getHeadNode();
        for (int i = 1; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (head.getRow() == node.getRow() && head.getCol() == node.getCol()) {
                return true;
            }
        }
        return false;
    }

    // Verifica si la serpiente ha colisionado con un nodo específico.
    public boolean checkCollision(Node node) {
        Node head = getHeadNode();
        return head.getRow() == node.getRow() && head.getCol() == node.getCol();
        
    }

    // Hace que la serpiente crezca al comer un alimento normal.
    public void eatFood(Node node) {
        if (checkCollision(node)) {
            nodesToGrow = 1; // La serpiente debe crecer en un nodo
        }
    }
    
    // Hace que la serpiente crezca al comer un alimento especial.
    public void eatSpecialFood(Node node) {
        if (checkCollision(node)) {
            nodesToGrow = 3; // La serpiente debe crecer en tres nodos
        }
    }
}
