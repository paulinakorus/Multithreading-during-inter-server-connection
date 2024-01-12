package org.example.customer;

import javax.swing.*;

public class CustomerGUI extends JFrame {
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

    public CustomerGUI() {
        this.setTitle("Keeper");                                     // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(1100, 700);                            // setting size
        this.setVisible(true);                                         // making frame visible
        this.add(customerPanel);

    }
}
