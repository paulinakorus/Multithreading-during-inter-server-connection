package org.example.keeper.service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class KeeperGUI extends JFrame{
    private JButton button1;
    private JPanel panel1;

    public KeeperGUI(){
        this.setTitle("Keeper");                                     // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(800, 700);                            // setting size
        this.setVisible(true);                                         // making frame visible
        this.add(panel1);

        setUpButtons();
    }

    private void setUpButtons(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == button1){
                    Thread thread = new Thread(() -> {
                        KeeperServer keeperServer = new KeeperServer();
                        try {
                            keeperServer.start();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    thread.start();
                }
            }
        });
    }
}
