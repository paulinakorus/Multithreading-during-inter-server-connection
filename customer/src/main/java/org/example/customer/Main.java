package org.example.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.model.Method;
import org.example.service.model.Payload;
import org.example.service.model.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{

            //SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 2137));

            ObjectMapper objectMapper = new ObjectMapper();
            CustomerClient customerClient = new CustomerClient("localhost", 2137);
            customerClient.connect();
            /*Product product = new Product();
            product.setId(12);
            product.setName("Ja");
            String data = objectMapper.writeValueAsString(product);*/

            User user = new User();
            user.setHost("sth_host");
            user.setId(1);
            user.setPort(2172);
            String data = objectMapper.writeValueAsString(user);
            Payload payload = new Payload();
            payload.setArgument(data);
            payload.setMethod(Method.Register);

            String payloadString = objectMapper.writeValueAsString(payload);
            //ByteBuffer buffer = ByteBuffer.wrap(payloadString.getBytes());
            var result = customerClient.sendAndRead(payloadString);
            var user_result = objectMapper.readValue(result, User.class);
            System.out.println(user_result.getHost());
            System.out.println(result);
            //channel.close();

            Thread thread = new Thread(() -> {
                CustomerServer customerServer = new CustomerServer();
                try {
                    customerServer.start(user.getHost(), user.getPort());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();


        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}