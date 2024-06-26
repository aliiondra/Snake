/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Dimension;

/**
 * Clase que representa la ventana principal del juego.
 */
public class Game extends javax.swing.JFrame {

    /**
     * Constructor de la clase Game.
     * Inicializa los componentes de la interfaz gráfica del juego.
     */
    public Game() {
        initComponents(); // Inicializa los componentes de la interfaz gráfica
        // Abre un diálogo de configuración del juego y lo hace visible.
        ConfigDialog configDialog = new ConfigDialog(this, true);
        configDialog.setVisible(true);
        // Actualiza la etiqueta de puntuación en el marcador.
        scoreBoard.updateScoreLabel();
        // Reinicia el marcador.
        scoreBoard.reset();
        // Inicializa el juego en el tablero.
        board.initGame();
        // Configura el marcador en el tablero.
        board.setScore(scoreBoard);
        setPreferredSize(new Dimension(800, 700));
        pack(); // Ajusta automáticamente el tamaño de la ventana.
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        setTitle("Snake Game"); // Establece el título de la ventana.
    }
    
    /**
     * Método para iniciar un nuevo juego.
     * Se ejecuta cuando se selecciona la opción "New Game" del menú.
     */
    public void newGame() {
        ConfigDialog configDialog = new ConfigDialog(this, true);
        board.stopGame();
        scoreBoard.stopTime();
        configDialog.setVisible(true);
        scoreBoard.reset();
        board.resetGame();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scoreBoard = new com.mycompany.snake.ScoreBoard();
        board = new com.mycompany.snake.Board();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemNewGame = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemHowToPlay = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(scoreBoard, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(board, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItemNewGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemNewGame.setText("New Game");
        jMenuItemNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewGameActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemNewGame);
        jMenu1.add(jSeparator1);

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExit);

        jMenuBar.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItemHowToPlay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemHowToPlay.setText("How to play");
        jMenuItemHowToPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHowToPlayActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemHowToPlay);
        jMenu2.add(jSeparator2);

        jMenuItemInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemInfo.setText("About..");
        jMenuItemInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInfoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemInfo);

        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewGameActionPerformed
        newGame(); // Inicia un nuevo juego.
    }//GEN-LAST:event_jMenuItemNewGameActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0); // Cierra la aplicación.
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInfoActionPerformed
        AboutDialog aboutDialog = new AboutDialog(this, true);
        board.stopGame();
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemInfoActionPerformed

    private void jMenuItemHowToPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHowToPlayActionPerformed
        HowToPlayDialog howToPlayDialog = new HowToPlayDialog(this, true);  // Abre un diálogo de información sobre el juego y lo hace visible.
        board.stopGame(); // Detiene el juego en el tablero.
        howToPlayDialog.setVisible(true); // Hace visible el diálogo.
    }//GEN-LAST:event_jMenuItemHowToPlayActionPerformed

    /**
     * Método principal para ejecutar la aplicación.
     * Crea una instancia de la clase Game y la hace visible.
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.snake.Board board;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemHowToPlay;
    private javax.swing.JMenuItem jMenuItemInfo;
    private javax.swing.JMenuItem jMenuItemNewGame;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private com.mycompany.snake.ScoreBoard scoreBoard;
    // End of variables declaration//GEN-END:variables
}
