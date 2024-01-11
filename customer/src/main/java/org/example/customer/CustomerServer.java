package org.example.customer;

import org.example.service.Server;
import org.example.service.model.Method;
import org.example.service.model.Product;
import org.example.service.model.Receipt;
import org.example.service.model.User;

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

    private String[] response(String type, String[] data){
        return data;
    }

    private List<Product> putOrder(int delivererID, List<Product> productList){
        return productList;
    }

    private Receipt returnReceipt(Receipt receipt){
        return receipt;
    }
}
