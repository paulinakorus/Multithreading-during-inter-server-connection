package org.example.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.clients.KeeperClient;
import org.example.service.model.enums.Method;
import org.example.service.model.Payload;
import org.example.service.model.User;

import java.io.IOException;

public class CustomerApplication {
    public static void main(String[] args){
        try{
            CustomerGUI customerGUI = new CustomerGUI();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}