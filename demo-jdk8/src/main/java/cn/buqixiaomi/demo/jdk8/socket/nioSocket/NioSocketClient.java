package cn.buqixiaomi.demo.jdk8.socket.nioSocket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * nio client
 */
public class NioSocketClient {

    private SocketChannel socketChannel ;
    private InetSocketAddress serverAddress;
    private Selector selector  ;
    private ByteBuffer buf = ByteBuffer.allocate(1024) ;

    public NioSocketClient(){
        try {
            serverAddress = new
                    InetSocketAddress(InetAddress.getByName("127.0.0.1"), 10001) ;
            socketChannel = SocketChannel.open(serverAddress) ;
            socketChannel.configureBlocking(false);
            selector = Selector.open() ;
            socketChannel.register(selector,
                    SelectionKey.OP_READ | SelectionKey.OP_WRITE) ;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connectServer() throws IOException{
        while(true){
            int keys = selector.select() ;
            System.out.println("检测到动态...");
            if(keys > 0){
                Iterator<SelectionKey> itKeys =
                        selector.selectedKeys().iterator() ;
                while(itKeys.hasNext()){
                    SelectionKey key = itKeys.next() ;
                    if(key.isReadable()){
                        readMessageFromChannel() ;
                    }
                    if (key.isWritable()){
                        writeMessageToChannel();
                    }
                    itKeys.remove();
                }
            }
        }

    }

    public void readMessageFromChannel() throws IOException {
        buf.clear() ;
        socketChannel.read(buf) ;
        buf.flip();
        System.out.println("服务端返回数据：" + new String(buf.array() ,
                0 , buf.limit() , "UTF-8"));
    }

    public void writeMessageToChannel() throws IOException{
        String msg = "hello i am client";
        buf.clear() ;
        buf.put(msg.getBytes("UTF-8"))  ;
        buf.flip() ;
        socketChannel.write(buf) ;
        System.out.println("客户端发送数据："+msg);
    }

    public static void main(String[] args) throws IOException {

        NioSocketClient client = new NioSocketClient();
        client.connectServer();
    }
}
