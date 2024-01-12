package org.example.seller;

import org.example.service.Server;
import org.example.service.model.Order;
import org.example.service.model.User;
import org.example.service.model.enums.Method;
import org.example.service.model.Product;

import java.util.List;

public class SellerServer extends Server {
    @Override
    protected String execute(Method method, Object object) {
        try{
            Object obj = switch(method){
                case AcceptOrder -> acceptOrder((List<Product>) object);
                default -> throw new RuntimeException("Unexcepted method");
            };
            return objectMapper.writeValueAsString(obj);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    private List<Product> acceptOrder(List<Product> productList){
        return productList;
    }
}
