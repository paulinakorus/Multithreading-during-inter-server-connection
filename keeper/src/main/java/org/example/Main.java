package org.example.keeper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.keeper.service.KeeperGUI;
import org.example.keeper.service.KeeperServer;
import org.example.service.model.Method;
import org.example.service.model.Payload;
import org.example.service.model.Product;

import javax.swing.plaf.TableHeaderUI;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String[] args){
        try{
            KeeperGUI keeperGUI = new KeeperGUI();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}