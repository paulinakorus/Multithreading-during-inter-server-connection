package org.example.customer;

import org.example.service.Server;
import org.example.service.model.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerServer extends Server {

    @Override
    protected String execute(Method method, Object object) {
        try{
            Object obj = switch(method){
                case Test -> test((Product) object);
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

    private List<Product> putOrder(Order userProducts){
        List<Product> productList = new ArrayList<>();
        return productList;
    }

    private Receipt returnReceipt(Receipt receipt){
        return receipt;
    }
}
