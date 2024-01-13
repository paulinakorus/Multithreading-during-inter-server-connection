package org.example.deliverer;

import javax.swing.*;

public class DelivererGUI extends JFrame{
    private JPanel delivererPanel;
    private JLabel delivererLabel;
    private JTextField hostTextField;
    private JTextField portTextField;
    private JButton registerButton;
    private JButton uregisterButton;
    private JList orderList;
    private JLabel portLabel;
    private JLabel hostLabel;
    private JButton buyAllProductsButton;

    public DelivererGUI() {
        this.setTitle("Keeper");                                     // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(1100, 700);                            // setting size
        this.setVisible(true);                                         // making frame visible
        this.add(delivererPanel);

    }
}
