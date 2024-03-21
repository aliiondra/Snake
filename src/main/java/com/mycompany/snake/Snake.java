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
 *
 * @author alu11563090
 */
public class Snake {

    private List<Node> nodes;
    private Direction direction;
    private int nodesToGrow;

    public Snake() {
        nodes = new ArrayList<Node>();
        nodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2));
        nodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 1));
        nodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 2));
        nodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 3));
        direction = Direction.RIGHT;
        nodesToGrow = 0;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void paint(Graphics g, int squareWidht, int squareHeight) {
        boolean firstNode = true;
        Color color;
        for (Node node : nodes) {
            if (firstNode) {
                color = Color.red;
                firstNode = false;
            } else {
                color = Color.yellow;
            }
            Util.drawSquare(g, node.getRow(), node.getCol(), color, squareWidht, squareHeight);
        }
    }

    public Node getHeadNode() {
        return nodes.get(0);
    }

    public Node getTailNode() {
        return nodes.get(nodes.size() - 1);
    }

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
        if (canMove(newNode)) {
            nodes.add(0, newNode);
            if (nodesToGrow == 0) {
                nodes.remove(getTailNode());
            } else {
                nodesToGrow--;
            }
        }
    }

    public boolean canMove(Node node) {
        return !(node.getRow() < 0 || node.getRow() >= Board.NUM_ROWS
                || node.getCol() < 0 || node.getCol() >= Board.NUM_COLS);
    }
    
    /*public boolean checkSnakeCollision(Node node) {
        for (Node n : nodes) {
            if (n.getRow() == node.getRow() && n.getCol() == node.getCol()) {
                return true;
            }
        }
        return false;
    }*/

    public boolean checkCollision(Food food) {
        Node head = nodes.get(0);
        return head.getRow() == food.getRow() && head.getCol() == food.getCol();
    }

    public void eatFood(Food food) {
        if (checkCollision(food)) {
            nodesToGrow = 1;
        }
    }
    
    public void eatSpecialFood(Food food) {
        if (checkCollision(food)) {
            nodesToGrow = 3;
        }
    }
}
