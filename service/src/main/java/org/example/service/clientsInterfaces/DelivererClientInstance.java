package org.example.service.clientsInterfaces;

import org.example.service.model.Order;

import java.io.IOException;

public interface DelivererClientInstance {

    public Order returnOrder(Order order) throws IOException;
}
