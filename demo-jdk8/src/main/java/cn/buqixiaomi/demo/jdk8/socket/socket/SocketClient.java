package cn.buqixiaomi.demo.jdk8.socket.socket;

import java.net.Socket;

/**
 * socket 客户端
 */
public class SocketClient {

    public static void main(String[] args) throws Exception{
        final Socket socket = new Socket("127.0.0.1", 10000);
        //发送消息
        new Thread(new SocketSendThread(socket)).start();
        //接收消息
        new Thread(new SocketReceiveThread(socket)).start();

    }
}
