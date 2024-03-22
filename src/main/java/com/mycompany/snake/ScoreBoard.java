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
public class ScoreBoard extends JPanel implements ScoreInterface{
    
    private JLabel jLabelScore;
    
    public ScoreBoard() {
        jLabelScore = new JLabel();
        jLabelScore.setText("0");
        add(jLabelScore);
    }
    
    public void incrementScore() {
        int currentScore = ConfigData.getInstance().getScore() + 1;
        ConfigData.getInstance().setScore(currentScore);
        updateScoreLabel();
    }
    
    public void reset() {
        ConfigData.getInstance().setScore(0);
        updateScoreLabel();
    }

    private void updateScoreLabel() {
        jLabelScore.setText("" + ConfigData.getInstance().getScore());
    }
}
