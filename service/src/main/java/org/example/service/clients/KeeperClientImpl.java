package org.example.service.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.Client;
import org.example.service.model.*;
import org.example.service.model.enums.Method;

import java.io.IOException;
import java.util.List;

public class KeeperClientImpl extends Client implements org.example.service.clientsInterfaces.KeeperClient {
    private ObjectMapper objectMapper;
    private Payload payload = new Payload();
    private String data;
    private String payloadString;
    public KeeperClientImpl(String host, int port) {
        super(host, port);
    }

    public User register(User user) throws IOException {
        data = objectMapper.writeValueAsString(user);
        payload.setArgument(data);
        payload.setMethod(Method.Register);

        payloadString = objectMapper.writeValueAsString(payload);
        var result = this.sendAndRead(payloadString);
        var user_result = objectMapper.readValue(result, User.class);
        System.out.println("Added: " + result);
        return user_result;
    }

    public User unregister(Integer id) throws IOException {
        data = objectMapper.writeValueAsString(id);
        payload.setArgument(data);
        payload.setMethod(Method.Unregister);

        payloadString = objectMapper.writeValueAsString(payload);
        var result = this.sendAndRead(payloadString);
        var user_result = objectMapper.readValue(result, User.class);
        System.out.println("Delated: " + result);
        return user_result;
    }

    public List<Product> getOffer() throws IOException {
        payload.setMethod(Method.GetOffer);

        payloadString = objectMapper.writeValueAsString(payload);
        var result = this.sendAndRead(payloadString);
        var productTab_result = objectMapper.readValue(result, Product[].class);
        System.out.println("Getting offer");
        return List.of(productTab_result);
    }

    public Order putOrder(Order order) throws IOException {
        data = objectMapper.writeValueAsString(order);
        payload.setArgument(data);
        payload.setMethod(Method.PutOrder);

        payloadString = objectMapper.writeValueAsString(payload);
        var result = this.sendAndRead(payloadString);
        var order_result = objectMapper.readValue(result, Order.class);
        System.out.println("Putting order");
        return order_result;
    }

    public Order getOrder(Order order) throws IOException {
        data = objectMapper.writeValueAsString(order);
        payload.setArgument(data);
        payload.setMethod(Method.GetOrder);

        payloadString = objectMapper.writeValueAsString(payload);
        var result = this.sendAndRead(payloadString);
        var order_result = objectMapper.readValue(result, Order.class);
        System.out.println("Putting order");
        return order_result;
    }

    public User getInfo(int id2) throws IOException {
        data = objectMapper.writeValueAsString(id2);
        payload.setArgument(data);
        payload.setMethod(Method.GetInfo);

        payloadString = objectMapper.writeValueAsString(payload);
        var result = this.sendAndRead(payloadString);
        var user_result = objectMapper.readValue(result, User.class);
        System.out.println("Info about user: " + result);
        return user_result;
    }

    public List<Product> returnOrder(Product[] productTab/*???*/) throws IOException {
        data = objectMapper.writeValueAsString(productTab);
        payload.setArgument(data);
        payload.setMethod(Method.ReturnOrder);

        payloadString = objectMapper.writeValueAsString(payload);
        var result = this.sendAndRead(payloadString);
        var productTab_result = objectMapper.readValue(result, Product[].class);
        System.out.println("Returning order");
        return List.of(productTab_result);
    }
}
