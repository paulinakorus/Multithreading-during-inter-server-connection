package org.example.keeper.service;

import org.example.service.model.Method;
import org.example.service.model.Product;
import org.example.service.Server;
import org.example.service.model.User;

import java.util.List;


public class KeeperServer extends Server {
    @Override
    protected String execute(Method method, Object object) {
        try{
            Object obj = switch(method){
                case Test -> test((Product) object);
                case Register -> register((User) object);
                default -> throw new RuntimeException("Unexcepted method");
            };
            return objectMapper.writeValueAsString(obj);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    private String test(Product product){
        return product.getName();
    }

    private User register(User user){
        user.setHost("ala");
        return user;
    }

    private User unregister(int id){
        User user = new User();
        return user;
    }

    private void getOffer(int customerID){

    }

    private void putOrder(int customerID, List<Product> productList){

    }

    private void getOrder(int delivererID){

    }

    private void returnOrder(List<Product> productList){

    }

    private void getInfo(int id1, int id2){

    }
}
