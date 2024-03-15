/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu11563090
 */
public class ConfigData {
    private String playerName;
    private int score;
    private Level level;
    private int deltaTime;
    
    public ConfigData() {
        playerName = "";
        score = 0;
        level = Level.BEGINNER;
        deltaTime = 500;
    }
}
