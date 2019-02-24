package cn.buqixiaomi.demo.jdk8.socket.nioSocket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * nio socket 服务端
 */
public class NioSocketServer {

    private Selector selector;
    private ServerSocketChannel serverChannel;
    private ByteBuffer buff ;
    public NioSocketServer(){
        try {
            selector = Selector.open() ;
            serverChannel = ServerSocketChannel.open() ;
            serverChannel.configureBlocking(false) ;
            serverChannel.socket().bind(new InetSocketAddress(10001));
            serverChannel.register(selector, SelectionKey.OP_ACCEPT) ;
            buff = ByteBuffer.allocate(1024) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openServer() throws IOException{
        while(true){
            System.out.println("正在select等待下一步操作...");
            int keys = selector.select();
            if(keys > 0){
                Iterator<SelectionKey> itKeys = selector.selectedKeys().iterator() ;
                while(itKeys.hasNext()){
                    SelectionKey key = itKeys.next() ;
                    if(key.isAcceptable()){
                        System.out.println("发现有客户端加入，Accept方法激活...");
                        ServerSocketChannel ss = (ServerSocketChannel)key.channel();
                        SocketChannel clientChannel = ss.accept();
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector,SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        System.out.println("接收到来自" + clientChannel.socket().getRemoteSocketAddress() + "的请求");
                        writeMessageToClient(clientChannel , "Hello Welcome!");
                        System.out.println("向客户端" + clientChannel.socket().getRemoteSocketAddress() + "发送信息成功");
                    }
                    if (key.isReadable()){
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        readMessageFromChannel(clientChannel);
                    }
                    if (key.isWritable()){
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        writeMessageToClient(clientChannel,"I am server");
                    }
                    itKeys.remove();
                }

            }

        }

    }
    public void readMessageFromChannel(SocketChannel clientChannel) throws IOException {
        buff.clear() ;
        clientChannel.read(buff) ;
        buff.flip();
        System.out.println("服务端接收数据：" + new String(buff.array() ,
                0 , buff.limit() , "UTF-8"));
    }

    public void writeMessageToClient(SocketChannel clientChannel , String message){
        try {
            buff.clear() ;
            buff.put(message.getBytes("UTF-8"))  ;
            buff.flip() ;
            clientChannel.write(buff) ;
            System.out.println("服务端发送数据："+message);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        NioSocketServer ss = new NioSocketServer() ;
        ss.openServer();
    }

}
