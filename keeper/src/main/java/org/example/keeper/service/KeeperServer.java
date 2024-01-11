package org.example.keeper.service;

import org.example.service.model.*;
import org.example.service.Server;
import org.example.service.model.enums.Method;
import org.example.service.model.enums.ProductStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;


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
                case GetOffer -> getOffer();
                case PutOrder -> putOrder((Order) object);
                case ReturnOrder -> returnOrder((Product[]) object);
                case GetInfo -> getInfo((Integer) object);
                //case getOrder(); -> getOrder();

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

    private List<Product> getOffer(){
        var offerList = wholeProductList.stream()
                .filter(product -> (product.getProductStatus() == ProductStatus.Available))
                .toList();
        return offerList;
    }

    private List<Product> putOrder(Order order){
        List<Integer> puttedID = order.getProductList().stream()
                .filter(product -> product.getProductStatus() == ProductStatus.Ordered)
                .map(Product::getId)
                .toList();
        for (Product product : wholeProductList) {
            for (Integer id : puttedID) {
                if(product.getId().equals(id))
                    product.setProductStatus(ProductStatus.Ordered);
            }
        }
        return wholeProductList;       //?
    }

    private void getOrder(){

    }

    private List<Product> returnOrder(Product[] productTab){
        List<Integer> returnedID = Arrays.stream(productTab)
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

    private User getInfo(int id2){
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
