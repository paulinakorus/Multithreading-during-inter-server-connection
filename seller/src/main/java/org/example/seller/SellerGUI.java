package org.example.seller;

import org.example.service.model.User;
import org.example.service.model.enums.Role;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SellerGUI extends JFrame{
    private String host = "localhost";
    private SellerServer sellerServer = null;

    private JPanel sellerPanel;
    private JLabel sellerLabel;
    private JTextField hostTextField;
    private JTextField portTextField;
    private JButton unregisterButton;
    private JButton registerButton;
    private JLabel hostLabel;
    private JLabel portLabel;

    public SellerGUI(){
        this.setTitle("Keeper");                                     // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(500, 500);                            // setting size
        this.setVisible(true);                                         // making frame visible
        this.add(sellerLabel);

        setUpButtons();
    }

    private void setUpButtons(){
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == registerButton){

                    if(sellerServer == null){
                        User user = new User();
                        user.setRole(Role.Seller);

                        user.setHost(host);
                        hostTextField.setText(host);

                        user.setPort(Integer.valueOf(portTextField.getText()));
                        //get instance

                        Thread thread = new Thread(() -> {
                            sellerServer = new SellerServer();
                            try {
                                sellerServer.start();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                }
            }
        });
    }
}
