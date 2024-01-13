package org.example.service.clientsInterfaces;

import org.example.service.model.Order;
import org.example.service.model.Product;
import org.example.service.model.User;

import java.io.IOException;
import java.util.List;

public interface KeeperClient {
    User register(User user) throws IOException;
    User unregister(Integer id) throws IOException;
    List<Product> getOffer() throws IOException;
    Order putOrder(Order order) throws IOException;
    Order getOrder(Order order) throws IOException;
    User getInfo(int id2) throws IOException;
    List<Product> returnOrder(Product[] productTab) throws IOException;
}
