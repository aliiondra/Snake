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
    private static ConfigData configData = new ConfigData();
    private String playerName;
    private int score;
    private Level level;
    private int deltaTime;
    
    public ConfigData() {
        playerName = "";
        score = 0;
        level = Level.BEGINNER;
        deltaTime = 300;
    }
    
    public static ConfigData getInstance() {
        return configData;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }
}
