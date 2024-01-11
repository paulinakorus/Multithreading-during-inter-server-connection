package org.example.service.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.Client;
import org.example.service.model.Payload;

public class DelivererClient extends Client {
    private ObjectMapper objectMapper;
    private Payload payload = new Payload();
    private String data;
    private String payloadString;

    public DelivererClient(String host, int port) {
        super(host, port);
    }


}

