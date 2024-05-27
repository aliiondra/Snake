/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Representa el panel de puntuación en el juego de la serpiente.
 * Muestra la puntuación actual del jugador y el tiempo transcurrido.
 * Implementa la interfaz ScoreInterface.
 */
public class ScoreBoard extends JPanel implements ScoreInterface {

    private JLabel jLabelScore; // Etiqueta para mostrar la puntuación.
    private JLabel jLabelTimer; // Etiqueta para mostrar el tiempo transcurrido.
    private int seconds; // Tiempo transcurrido en segundos.
    private Timer timer; // Temporizador para actualizar el tiempo automáticamente.

    /**
     * Constructor de la clase ScoreBoard.
     * Inicializa los componentes del panel de puntuación y comienza el temporizador.
     */
    public ScoreBoard() {
        // Configuración de la etiqueta de puntuación
        jLabelScore = new JLabel();
        jLabelScore.setText("Score for " + ConfigData.getInstance().getPlayerName() + ": 0");
        add(jLabelScore);

        // Configuración de la etiqueta de tiempo
        jLabelTimer = new JLabel();
        jLabelTimer.setText("Time: 0 seconds");
        add(jLabelTimer);
       
        // Inicialización del contador de segundos
        seconds = 0;
        
        // Configuración del temporizador para actualizar el tiempo
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                updateTimerLabel();
            }
        });
        timer.start(); // Iniciar el temporizador
    }

    // Incrementa la puntuación del jugador cuando come un alimento normal.
    public void incrementFoodScore() {
        int currentScore = ConfigData.getInstance().getScore() + 10;
        ConfigData.getInstance().setScore(currentScore);
        updateScoreLabel();
    }

    // Incrementa la puntuación del jugador cuando come un alimento especial
    public void incrementSpecialFoodScore() {
        int currentScore = ConfigData.getInstance().getScore() + 30;
        ConfigData.getInstance().setScore(currentScore);
        updateScoreLabel();
    }

    // Reinicia la puntuación y el tiempo transcurrido.
    public void reset() {
        ConfigData.getInstance().setScore(0);
        seconds = 1;
        updateScoreLabel();
        updateTimerLabel();
        timer.restart();
    }

    // Actualiza la etiqueta de puntuación con la puntuación actual del jugador.
    public void updateScoreLabel() {
        jLabelScore.setText("Score for " + ConfigData.getInstance().getPlayerName() + ": " + ConfigData.getInstance().getScore());
    }

    // Actualiza la etiqueta de tiempo con el tiempo transcurrido.
    public void updateTimerLabel() {
        jLabelTimer.setText("Time: " + seconds + " seconds");
    }

    // Detiene el temporizador.
    public void stopTime() {
        timer.stop();
    }
    
    // Reanuda el temporizador.
    public void resumeTime() {
        timer.start();
    }
}