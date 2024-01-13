package org.example.deliverer;

public class DeliverApplication {
    public static void main(String[] args){
        try{
            DeliverGUI deliverGUI = new DeliverGUI();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}