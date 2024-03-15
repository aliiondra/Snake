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
        direction = Direction.DOWN;
        nodesToGrow = 0;
    }

    public List<Node> getNodes() {
        return nodes;
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

}
