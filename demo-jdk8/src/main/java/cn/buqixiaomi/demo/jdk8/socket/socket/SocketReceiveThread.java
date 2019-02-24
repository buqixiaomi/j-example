package cn.buqixiaomi.demo.jdk8.socket.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketReceiveThread implements Runnable{

    private Socket socket;

    public SocketReceiveThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                System.out.println("新消息 : " + reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
