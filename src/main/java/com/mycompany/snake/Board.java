/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author alu11563090
 */
public class Board extends javax.swing.JPanel {

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    snake.setDirection(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    snake.setDirection(Direction.DOWN);
                    break;
                case KeyEvent.VK_RIGHT:
                    snake.setDirection(Direction.RIGHT);
                    break;
                case KeyEvent.VK_LEFT:
                    snake.setDirection(Direction.LEFT);
                    break;
                case KeyEvent.VK_SPACE:
                    pauseGame();
                    break;
            }
            repaint();
        }
    }

    public static final int NUM_ROWS = 30;
    public static final int NUM_COLS = 30;

    private Snake snake;
    private Food food;
    private SpecialFood specialFood;
    private boolean specialFoodVisible;
    private int specialFoodTimeVisible;
    private Timer timer;
    private MyKeyAdapter keyAdapter;
    private ScoreInterface score;
    private GameOverDialog gameOverDialog;
    private JFrame parentFrame;

    /**
     * Creates new form Board
     */
    public Board() {
        snake = new Snake();
        generateRandomFood();
        generateRandomSpecialFood();
        keyAdapter = new MyKeyAdapter();
        setFocusable(true);
        addKeyListener(keyAdapter);
    }

    public int getSquareWidth() {
        return getWidth() / NUM_ROWS;
    }

    public void generateRandomFood() {
        int randomRow, randomCol;
        do {
            randomRow = (int) (Math.random() * NUM_ROWS);
            randomCol = (int) (Math.random() * NUM_COLS);
        } while (snake.collidesWith(randomRow, randomCol) || foodCollidesWithSpecialFood(randomRow, randomCol));

        food = new Food(randomRow, randomCol);
    }

    public void generateRandomSpecialFood() {
        int randomRow, randomCol;
        do {
            randomRow = (int) (Math.random() * NUM_ROWS);
            randomCol = (int) (Math.random() * NUM_COLS);
        } while (snake.collidesWith(randomRow, randomCol) || foodCollidesWithSpecialFood(randomRow, randomCol));

        specialFood = new SpecialFood(randomRow, randomCol);
        specialFoodTimeVisible = 20;
        specialFoodVisible = true;
    }

    private boolean foodCollidesWithSpecialFood(int row, int col) {
        if (specialFoodVisible) {
            return specialFood.getRow() == row && specialFood.getCol() == col;
        }
        return false;
    }

    public int getSquareHeight() {
        return getHeight() / NUM_COLS;
    }

    public void setScore(ScoreInterface scoreInterface) {
        this.score = scoreInterface;
    }

    public void initGame() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(ConfigData.getInstance().getDeltaTime(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tick();
            }
        });
        timer.start();
    }

    public void resetGame() {
        snake = new Snake();
        generateRandomFood();
        generateRandomSpecialFood();
        initGame();
        score.reset();
    }

    public void gameOver() {
        stopGame();
        score.stopTime();
        GameOverDialog gameOverDialog = new GameOverDialog(parentFrame, true);
        gameOverDialog.setVisible(true);
    }

    public void pauseGame() {
        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }

    public void stopGame() {
        timer.stop();
    }

    public void resumeGame() {
        timer.start();
    }

    private void tick() {
        snake.move();
        if (specialFoodVisible) {
            specialFoodTimeVisible--;
            if (specialFoodTimeVisible <= 0) {
                specialFoodVisible = false;
            }
        } else {
            generateRandomSpecialFood();
        }
        if (snake.checkCollision(food)) {
            snake.eatFood(food);
            generateRandomFood();
            score.incrementFoodScore();
        }
        if (snake.checkCollision(specialFood)) {
            snake.eatSpecialFood(specialFood);
            generateRandomSpecialFood();
            score.incrementSpecialFoodScore();
        }
        if (snake.checkSelfCollision() || snake.checkBorderCollision()) {
            gameOver();
        }
        repaint();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.GRAY);
        //g.fillRect(0, 0, getWidth(), getHeight());
        g.drawRect(0, 0, getWidth() / NUM_COLS * NUM_COLS, getHeight() / NUM_ROWS * NUM_ROWS);
        if (snake != null) {
            snake.paint(g, getSquareWidth(), getSquareHeight());
        }
        if (food != null) {
            food.paint(g, getSquareWidth(), getSquareHeight());
        }
        if (specialFood != null || specialFoodVisible) {
            specialFood.paint(g, getSquareWidth(), getSquareHeight());

        }
        Toolkit.getDefaultToolkit().sync();
    }
}
