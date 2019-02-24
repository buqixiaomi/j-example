package cn.buqixiaomi.demo.jdk8.socket.socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket 服务端
 */
public class SocketServer {

    public static void main(String[] args) throws Exception{
        //创建 serverSocket
        ServerSocket server = new ServerSocket(10000);
        final Socket socket = server.accept();
        //接收客户端消息
        new Thread(new SocketSendThread(socket)).start();
        //接收消息
        new Thread(new SocketReceiveThread(socket)).start();
    }

}
