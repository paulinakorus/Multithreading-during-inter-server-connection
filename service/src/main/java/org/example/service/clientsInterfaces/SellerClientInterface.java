package org.example.service.clientsInterfaces;

import org.example.service.model.Order;

import java.io.IOException;

public interface SellerClientInterface {
    Order acceptOrder(Order order) throws IOException;
}
