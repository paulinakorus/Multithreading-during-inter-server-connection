package org.example.keeper.service;

import org.example.service.model.Method;
import org.example.service.model.Product;
import org.example.service.Server;
import org.example.service.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class KeeperServer extends Server {
    private List<User> userList;
    private List<Product> productList;

    public KeeperServer(){
        userList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    @Override
    protected String execute(Method method, Object object) {
        try{
            Object obj = switch(method){
                case Test -> test((Product) object);
                case Register -> register((User) object);
                case Unregister -> unregister((Integer) object);
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
        userList.add(user);
        System.out.println("Registering user with id: " + user.getId());

        return user;
    }

    private User unregister(Integer id){
        for (User user : userList) {
            if (user.getId().equals(id)) {
                userList.remove(user);
                System.out.println("Unregistering user with id: " + id);
                return user;
            }
        }
        System.out.println("Unregistering faild. User with id: " + id + " does not exist");
        return null;
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
