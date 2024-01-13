package org.example.deliverer;

import javax.swing.*;

public class DeliverGUI extends JFrame{
    private JPanel delivererPanel;
    private JLabel delivererLabel;
    private JTextField hostTextField;
    private JTextField portTextField;
    private JButton registerButton;
    private JButton uregisterButton;
    private JList orderList;
    private JButton buyAllProductsButton;
    private JLabel portLabel;
    private JLabel hostLabel;

    public DeliverGUI() {
        this.setTitle("Keeper");                                     // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(1100, 700);                            // setting size
        this.setVisible(true);                                         // making frame visible
        this.add(delivererPanel);

    }
}
