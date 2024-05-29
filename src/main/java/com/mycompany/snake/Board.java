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
 * Panel que representa el tablero del juego de Snake.
 */
public class Board extends javax.swing.JPanel {
    // Adaptador de teclado personalizado para manejar las teclas del juego
    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            // Manejar las teclas para controlar la serpiente y pausar el juego
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != Direction.DOWN) { // Verificar si la serpiente no se está moviendo hacia abajo
                        snake.setDirection(Direction.UP);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != Direction.UP) { // Verificar si la serpiente no se está moviendo hacia arriba
                        snake.setDirection(Direction.DOWN);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.getDirection() != Direction.LEFT) { // Verificar si la serpiente no se está moviendo hacia la izquierda
                        snake.setDirection(Direction.RIGHT);
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (snake.getDirection() != Direction.RIGHT) { // Verificar si la serpiente no se está moviendo hacia la derecha
                        snake.setDirection(Direction.LEFT);
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    pauseGame();
                    break;
            }
            repaint(); // Volver a dibujar el panel después de cada acción
        }
    }
    
    // Constantes para el tamaño del tablero
    public static final int NUM_ROWS = 30;
    public static final int NUM_COLS = 30;

    // Componentes del juego
    private Snake snake;
    private Food food;
    private SpecialFood specialFood;
    private boolean specialFoodVisible;
    private int specialFoodTimeVisible;
    private Timer timer;
    private MyKeyAdapter keyAdapter;
    private ScoreInterface score;
    private JFrame parentFrame;

    /**
     * Constructor de la clase Board.
     */
    public Board() {
        snake = new Snake();
        generateRandomFood();
        generateRandomSpecialFood();
        keyAdapter = new MyKeyAdapter();
        setFocusable(true);
        addKeyListener(keyAdapter);
    }
    
    // Métodos para obtener el ancho y alto de un cuadrado del tablero
    public int getSquareWidth() {
        return getWidth() / NUM_ROWS;
    }
    
    public int getSquareHeight() {
        return getHeight() / NUM_COLS;
    }

    // Método para generar comida en una posición aleatoria
    public void generateRandomFood() {
        int randomRow, randomCol;
        do {
            randomRow = (int) (Math.random() * NUM_ROWS);
            randomCol = (int) (Math.random() * NUM_COLS);
        } while (snake.collidesWith(randomRow, randomCol) || foodCollidesWithSpecialFood(randomRow, randomCol));

        food = new Food(randomRow, randomCol);
    }

    // Método para generar comida especial en una posición aleatoria
    public void generateRandomSpecialFood() {
        int randomRow, randomCol;
        do {
            randomRow = (int) (Math.random() * NUM_ROWS);
            randomCol = (int) (Math.random() * NUM_COLS);
        } while (snake.collidesWith(randomRow, randomCol) || foodCollidesWithSpecialFood(randomRow, randomCol));

        specialFood = new SpecialFood(randomRow, randomCol);
        specialFoodTimeVisible = 20; // Establecer el tiempo de visibilidad de la comida especial
        specialFoodVisible = true;
    }

    // Método para verificar si la comida normal colisiona con la comida especial
    private boolean foodCollidesWithSpecialFood(int row, int col) {
        if (specialFoodVisible) {
            return specialFood.getRow() == row && specialFood.getCol() == col;
        }
        return false;
    }

    public void setScore(ScoreInterface scoreInterface) {
        this.score = scoreInterface;
    }
    
// Método para inicializar el juego
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

    // Método para reiniciar el juego
    public void resetGame() {
        snake = new Snake();
        generateRandomFood();
        generateRandomSpecialFood();
        initGame();
        score.reset();
        requestFocus();
    }

    // Método para mostrar la pantalla de Game Over
    public void gameOver() {
        stopGame();
        score.stopTime();
        GameOverDialog gameOverDialog = new GameOverDialog(parentFrame, true);
        gameOverDialog.setVisible(true);
        ConfigDialog configDialog = new ConfigDialog(parentFrame, true);
        configDialog.setVisible(true);
        resetGame();
    }

    // Método para pausar el juego
    public void pauseGame() {
        if (timer.isRunning()) {
            timer.stop();
            score.stopTime();
        } else {
            timer.start();
            score.resumeTime();
        }
    }

    // Método para detener el juego
    public void stopGame() {
        timer.stop();
    }

    // Método para reanudar el juego
    public void resumeGame() {
        timer.start();
    }

    // Método que se ejecuta en cada tick del juego
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
        repaint(); // Volver a dibujar el panel después de cada tick
    }

    // Método para dibujar los componentes del juego en el panel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
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
        Toolkit.getDefaultToolkit().sync(); // Sincronizar el dibujo en pantalla
    }
}
