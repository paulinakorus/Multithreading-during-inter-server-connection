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
            KeeperClient keeperClient = new KeeperClient("localhost", 2137);
            /*Product product = new Product();
            product.setId(12);
            product.setName("Ja");
            String data = objectMapper.writeValueAsString(product);*/

            User user = new User();
            user.setHost("sth_host");
            user.setId(1);
            user.setPort(2172);

            Payload payload = new Payload();
            payload.setArgument(null);
            payload.setMethod(Method.GetOffer);
            String payloadString3 = objectMapper.writeValueAsString(payload);
            var result = keeperClient.sendAndRead(payloadString3);
            System.out.println(result);

            /*var payloadString2 = objectMapper.writeValueAsString(payload2);
            var result2 = customerClient.sendAndRead(payloadString2);
            var user_result2 = objectMapper.readValue(result, User.class);
            System.out.println(result2);*/

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