/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 *
 * @author alu11563090
 */
public class ConfigDialog extends JDialog {

    /*public ConfigDialog(Frame parent, boolean modal) {
        super(parent, modal);
        setLocationRelativeTo(null);
    }*/
    private JTextField playerNameField;
    private JComboBox<String> jComboBox;
    private JButton jButton;

    public ConfigDialog(Frame parent, boolean modal) {
        super(parent, modal);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(300, 150));
        setResizable(false);
        showConfigDialog();
    }

    public void showConfigDialog() {
        playerNameField.setText("Name:");
        add(playerNameField);
        jComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Easy", "Medium", "Hard"}));
        jComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        add(jComboBox);
        jButton.setText("Play!");
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
        add(jButton);
    }

    private void jComboBoxActionPerformed(ActionEvent evt) {
        switch (jComboBox.getSelectedIndex()) {
            case 0:
                ConfigData.getInstance().setDeltaTime(400);
                break;
            case 1:
                ConfigData.getInstance().setDeltaTime(250);
                break;
            case 2:
                ConfigData.getInstance().setDeltaTime(100);
                break;
        }
    }
    
    private void jButtonActionPerformed(ActionEvent evt) {
        setVisible(false);
    }
}
