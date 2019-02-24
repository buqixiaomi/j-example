package cn.buqixiaomi.demo.jdk8.socket.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketSendThread implements Runnable{

    private Socket socket;

    public SocketSendThread(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String readline = in.readLine();
            while(true){
                out.println(readline);
                readline = in.readLine();
                if(readline.equals("bye"))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
