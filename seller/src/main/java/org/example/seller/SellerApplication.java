package org.example.seller;

public class SellerApplication {
    public static void main(String[] args){
        try{
            SellerGUI keeperGUI = new SellerGUI();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}