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
 *
 * @author alu11563090
 */
public class ScoreBoard extends JPanel implements ScoreInterface {

    private JLabel jLabelScore;
    private JLabel jLabelTimer;
    private int seconds;
    private Timer timer;

    public ScoreBoard() {
        jLabelScore = new JLabel();
        jLabelScore.setText("Score for " + ConfigData.getInstance().getPlayerName() + ": 0");
        add(jLabelScore);

        jLabelTimer = new JLabel();
        jLabelTimer.setText("Time: 0 seconds");
        add(jLabelTimer);

        seconds = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                updateTimerLabel();
            }
        });
        timer.start();
    }

    public void incrementFoodScore() {
        int currentScore = ConfigData.getInstance().getScore() + 10;
        ConfigData.getInstance().setScore(currentScore);
        updateScoreLabel();
    }

    public void incrementSpecialFoodScore() {
        int currentScore = ConfigData.getInstance().getScore() + 30;
        ConfigData.getInstance().setScore(currentScore);
        updateScoreLabel();
    }

    public void reset() {
        ConfigData.getInstance().setScore(0);
        seconds = 1;
        updateScoreLabel();
        updateTimerLabel();
        timer.restart();
    }

    public void updateScoreLabel() {
        jLabelScore.setText("Score for " + ConfigData.getInstance().getPlayerName() + ": " + ConfigData.getInstance().getScore());
    }

    public void updateTimerLabel() {
        jLabelTimer.setText("Time: " + seconds + " seconds");
    }

    public void stopTime() {
        timer.stop();
    }
}
