package org.example.deliverer;

import org.example.service.Server;
import org.example.service.model.enums.Method;
import org.example.service.model.Product;

import java.util.List;

public class DelivererServer extends Server {
    @Override
    protected String execute(Method method, Object obj) {
        return null;
    }

    private List<Product> returnOrder(List<Product> productList){
        return productList;
    }
}
