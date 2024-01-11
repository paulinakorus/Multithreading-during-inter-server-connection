package org.example.deliverer;

import org.example.service.Server;
import org.example.service.model.Method;
import org.example.service.model.Product;

import java.util.List;

public class DelivererServer extends Server {
    @Override
    protected String execute(Method method, Object obj) {
        return null;
    }

    private String[] response(String type, String[] data){
        return data;
    }

    private List<Product> returnOrder(List<Product> productList){
        return productList;
    }
}
