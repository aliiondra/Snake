/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

/**
 * Clase que almacena la configuración del juego.
 */
public class ConfigData {
    private static ConfigData configData = new ConfigData();
    private String playerName; 
    private int score;
    private Level level;
    private int deltaTime;
    
    /**
     * Constructor privado de ConfigData. Inicializa los valores predeterminados.
     */
    public ConfigData() {
        playerName = "";
        score = 0;
        level = Level.BEGINNER;
        deltaTime = 400;
    }
    
    // Devuelve la instancia única de ConfigData.
    public static ConfigData getInstance() {
        return configData;
    }

    // Devuelve el nombre del jugador.
    public String getPlayerName() {
        return playerName;
    }

    // Establece el nombre del jugador.
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // Devuelve la puntuación del jugador.
    public int getScore() {
        return score;
    }

    // Establece la puntuación del jugador.
    public void setScore(int score) {
        this.score = score;
    }

    // Devuelve el nivel de dificultad del juego.
    public Level getLevel() {
        return level;
    }

    // Establece el nivel de dificultad del juego.
    public void setLevel(Level level) {
        this.level = level;
    }

    // Devuelve el intervalo de tiempo entre los movimientos de la serpiente.
    public int getDeltaTime() {
        return deltaTime;
    }

    // Establece el intervalo de tiempo entre los movimientos de la serpiente.
    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }
}
