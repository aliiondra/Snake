/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase que representa un diálogo de "Cómo jugar" en el juego de la serpiente.
 * Extiende JDialog para crear un diálogo personalizado.
 */
public class HowToPlayDialog extends JDialog {

    /**
     * Constructor de la clase HowToPlayDialog.
     * @param parent El marco principal al que pertenece el diálogo.
     * @param modal Indica si el diálogo es modal o no.
     */
    public HowToPlayDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal); // Llama al constructor de la superclase con el marco principal y el indicador modal.
        initComponents(); // Inicializa los componentes del diálogo.
        setLocationRelativeTo(null); // Centra el diálogo en la pantalla.
        setTitle("How to play"); // Establece el título del diálogo.
    }

    //Método para inicializar los componentes del diálogo.
    private void initComponents() {
        
        // Crear un área de texto con desplazamiento.
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTextArea jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Establecer la operación de cierre predeterminada al cerrar el diálogo.

        // Configurar el área de texto.
        jTextArea1.setEditable(false); // No se puede editar el texto.
        jTextArea1.setColumns(20); // Establece el número de columnas.
        jTextArea1.setRows(5); // Establece el número de filas.
        String howToPlayText = "How to play: \n" // Texto de "Cómo jugar".
                + "Move: Arrow keys \n" // Instrucción para mover.
                + "Pause: Space \n" // Instrucción para pausar.
                + "Quit: Ctrl + Q"; // Instrucción para salir.

        jTextArea1.setText(howToPlayText); // Establece el texto en el área de texto.
        jScrollPane1.setViewportView(jTextArea1); // Asocia el área de texto con desplazamiento al panel de desplazamiento.

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER); // Agrega el panel de desplazamiento al contenido del diálogo.

        pack(); // Ajusta automáticamente el tamaño del diálogo según el contenido.

    }
}
