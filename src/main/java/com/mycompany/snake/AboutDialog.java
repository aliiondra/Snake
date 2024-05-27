/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Diálogo de información sobre el proyecto.
 */
public class AboutDialog extends JDialog {

    /**
     * Constructor de la clase AboutDialog.
     * @param parent El marco principal del juego.
     * @param modal  Indica si el diálogo es modal o no.
     */
    public AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal); // Llama al constructor de la superclase con el marco principal y el indicador modal
        initComponents(); // Inicializa los componentes del diálogo
        setLocationRelativeTo(null); // Centra el diálogo en la pantalla
        setTitle("Info"); // Establece el título del diálogo
    }

    /**
     * Inicializa los componentes del diálogo.
     */
    private void initComponents() {
        // Componentes del diálogo
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTextArea jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Cierra el diálogo al hacer clic en la 'X'

        jTextArea1.setEditable(false); // Hace que el área de texto no sea editable
        jTextArea1.setColumns(18); // Establece el número de columnas del área de texto
        jTextArea1.setRows(1); // Establece el número de filas del área de texto
        jTextArea1.setText("Project developed by Alin Ionescu"); // Establece el texto del área de texto
        jScrollPane1.setViewportView(jTextArea1); // Agrega el área de texto a un panel de desplazamiento

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER); // Agrega el panel de desplazamiento al contenido del diálogo

        pack();// Empaqueta los componentes del diálogo
    }
}
