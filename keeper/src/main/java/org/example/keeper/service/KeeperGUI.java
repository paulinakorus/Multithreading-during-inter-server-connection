package org.example.keeper.service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class KeeperGUI extends JFrame{
    private JButton startButton;
    private JPanel keeperPanel;
    private JLabel keeperLabel;
    private JLabel serverStartedLabel;
    private KeeperServer keeperServer = null;

    public KeeperGUI(){
        this.setTitle("Keeper");                                     // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(500, 500);                            // setting size
        this.setVisible(true);                                         // making frame visible
        this.add(keeperPanel);

        setUpButtons();
    }

    private void setUpButtons(){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == startButton){
                    if(keeperServer == null){
                        Thread thread = new Thread(() -> {
                            keeperServer = new KeeperServer();
                            try {
                                keeperServer.start();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        serverStartedLabel.setText("Server is started");
                        thread.start();
                    }
                }
            }
        });
    }
}
