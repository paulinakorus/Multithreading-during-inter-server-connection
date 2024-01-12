package org.example.service.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.Client;
import org.example.service.model.Order;
import org.example.service.model.Payload;
import org.example.service.model.enums.Method;

import java.io.IOException;

public class SellerClient extends Client {
    private ObjectMapper objectMapper;
    private Payload payload = new Payload();
    private String data;
    private String payloadString;
    public SellerClient(String host, int port) {
        super(host, port);
    }

    public Order acceptOrder(Order order) throws IOException {
        data = objectMapper.writeValueAsString(order);
        payload.setArgument(data);
        payload.setMethod(Method.AcceptOrder);

        payloadString = objectMapper.writeValueAsString(payload);
        var result = this.sendAndRead(payloadString);
        var order_result = objectMapper.readValue(result, Order.class);
        System.out.println("Accepting order");
        return order_result;
    }
}
