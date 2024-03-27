/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alu11563090
 */
public class ScoreBoard extends JPanel implements ScoreInterface {
    
    private JLabel jLabelScore;
    
    public ScoreBoard() {
        jLabelScore = new JLabel();
       
        jLabelScore.setText("Score for " + ConfigData.getInstance().getPlayerName() + ": 0");
        add(jLabelScore);
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
        updateScoreLabel();
    }

    public void updateScoreLabel() {
        jLabelScore.setText("Score for " + ConfigData.getInstance().getPlayerName() + ": " + ConfigData.getInstance().getScore());
    }
}
