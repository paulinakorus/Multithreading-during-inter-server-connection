package org.example.seller;

import org.example.service.Server;
import org.example.service.model.Method;
import org.example.service.model.Product;

import java.util.List;

public class SellerServer extends Server {
    @Override
    protected String execute(Method method, Object obj) {
        return null;
    }

    private String[] response(String type, String[] data){
        return data;
    }

    private List<Product> acceptOrder(int customerID, List<Product> productList){
        return productList;
    }
}
