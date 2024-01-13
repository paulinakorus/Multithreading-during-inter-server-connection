package org.example.customer;

import org.example.service.clients.KeeperClientImpl;
import org.example.service.clientsInterfaces.KeeperClient;
import org.example.service.model.User;
import org.example.service.model.enums.Role;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CustomerGUI extends JFrame {
    private String host = "localhost";
    private CustomerServer customerServer = null;
    private KeeperClient keeperClient = new KeeperClientImpl(host, 2137);
    private User user;

    private JPanel customerPanel;
    private JTabbedPane tabbedPane1;
    private JPanel productsPanel;
    private JPanel ordersPanel;
    private JTextField hostTextField;
    private JTextField portTextField;
    private JButton registerButton;
    private JButton unregisterButton;
    private JList productsList;
    private JButton orderButton;
    private JList ordersList;
    private JList orderProductsList;
    private JButton returnButton;
    private JButton payButton;
    private JLabel hostLabel;
    private JLabel portLabel;
    private JLabel customerLabel;

    public CustomerGUI() {
        this.setTitle("Customer");                                     // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(1100, 700);                            // setting size
        this.setVisible(true);                                         // making frame visible
        this.add(customerPanel);

        hostTextField.setText(host);
        setUpButtons();
    }

    private void setUpButtons(){
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == registerButton){
                    if(customerServer == null){
                        user = new User();
                        user.setRole(Role.Customer);
                        user.setHost(host);
                        user.setPort(Integer.valueOf(portTextField.getText()));

                        try {
                            keeperClient.register(user);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        Thread thread = new Thread(() -> {
                            customerServer = new CustomerServer();
                            try {
                                customerServer.start(user.getHost(), user.getPort());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        thread.start();
                    }
                }
            }
        });

        unregisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == unregisterButton){
                    try {
                        if(user != null)
                            keeperClient.unregister(user.getId());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
}
