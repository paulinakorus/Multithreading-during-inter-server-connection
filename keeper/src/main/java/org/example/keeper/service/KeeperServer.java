package org.example.keeper.service;

import org.example.service.model.*;
import org.example.service.Server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class KeeperServer extends Server {
    private List<User> wholeUserList;
    private List<Product> wholeProductList;

    public KeeperServer(){
        wholeProductList = new ArrayList<>();
        wholeUserList = new ArrayList<>();
    }

    @Override
    protected String execute(Method method, Object object) {
        try{
            Object obj = switch(method){
                case Test -> test((Product) object);
                case Register -> register((User) object);
                case Unregister -> unregister((Integer) object);
                case ReturnOrder -> returnOrder((List<Product>) object);
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
        wholeUserList.add(user);
        System.out.println("Registering user with id: " + user.getId());
        System.out.println("Numbers of users: " + wholeUserList.size());

        return user;
    }

    private User unregister(Integer id){
        for (User user : wholeUserList) {
            if (user.getId().equals(id)) {
                User userToView = user;
                wholeUserList.remove(user);
                System.out.println("Unregistering user with id: " + id);
                System.out.println("Numbers of users: " + wholeUserList.size());
                return userToView;
            }
        }
        System.out.println("Unregistering faild. User with id: " + id + " does not exist");
        return null;
    }

    private List<Product> getOffer(int customerID){
        var offerList = wholeProductList.stream()
                .filter(product -> (product.getProductStatus() == ProductStatus.Available))
                .toList();
        return offerList;
        // giving to this customer
    }

    private void putOrder(UserProducts userProducts){
        for (Product product : userProducts.getProductList()) {
            product.setProductStatus(ProductStatus.Ordered);
        }
        // getting from this customer
    }

    private void getOrder(int delivererID){

    }

    private List<Product> returnOrder(List<Product> productList){
        List<Integer> returnedID = productList.stream()
                .filter(product -> product.getProductStatus() == ProductStatus.Returned)
                .map(Product::getId)
                .toList();
        for (Product product : wholeProductList) {
            for (Integer id : returnedID) {
                if(product.getId().equals(id))
                    product.setProductStatus(ProductStatus.Available);
            }
        }
        return wholeProductList;
    }

    private User getInfo(int id1, int id2){
        User userID2;
        for (User user : wholeUserList) {
            if(user.getId().equals(id2)){
                userID2 = user;
                return userID2;
            }
        }
        System.out.println("User with id: " + id2 + " do not exist");
        return null;
    }
}
