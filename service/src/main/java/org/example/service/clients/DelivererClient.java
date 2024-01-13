package org.example.service.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.Client;
import org.example.service.clientsInterfaces.CustomerClientInterface;
import org.example.service.clientsInterfaces.DelivererClientInstance;
import org.example.service.model.Order;
import org.example.service.model.Payload;
import org.example.service.model.enums.Method;

import java.io.IOException;

public class DelivererClient extends Client implements DelivererClientInstance{
    private static DelivererClientInstance INSTANCE = null;
    private ObjectMapper objectMapper;
    private Payload payload = new Payload();
    private String data;
    private String payloadString;

    public DelivererClient(String host, int port) {
        super(host, port);
    }

    public Order returnOrder(Order order) throws IOException {
        data = objectMapper.writeValueAsString(order);
        payload.setArgument(data);
        payload.setMethod(Method.ReturnOrder);

        payloadString = objectMapper.writeValueAsString(payload);
        var result = this.sendAndRead(payloadString);
        var order_result = objectMapper.readValue(result, Order.class);
        System.out.println("Returning all products order");
        return order_result;
    }

    public static DelivererClientInstance getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = (DelivererClientInstance) new DelivererClient(Client.getHost(), Client.getPort());
        }
        return INSTANCE;
    }
}

