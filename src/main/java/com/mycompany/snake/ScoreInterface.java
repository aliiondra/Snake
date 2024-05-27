/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

/**
 * Interfaz que define los métodos necesarios para manejar la puntuación en el juego.
 */
public interface ScoreInterface {
    public void incrementFoodScore();
    public void incrementSpecialFoodScore();
    public void reset();
    public void stopTime();
    public void resumeTime();
}
