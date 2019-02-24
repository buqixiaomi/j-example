package cn.buqixiaomi.demo.jdk8.socket.nioSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * 模拟http 服务器
 */
public class HttpServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(10002));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        while (true){
            if (selector.select(3000) == 0){
                continue;
            }
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                new Thread(new HttpHandle(key)).run();
                keyIterator.remove();
            }
        }
    }

    /**
     * 请求处理器
     */
    private static class HttpHandle implements Runnable{
        private int byteBufferSize = 1024;
        private String localCharset = "UTF-8";
        private SelectionKey key;

        public HttpHandle(SelectionKey key) {
            this.key = key;
        }

        public void handleAccept() throws Exception{
            SocketChannel socketChannel = ((ServerSocketChannel)key.channel()).accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(key.selector(),SelectionKey.OP_READ , ByteBuffer.allocate(byteBufferSize));
        }

        public void handleRead() throws Exception {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
            byteBuffer.clear();
            if (socketChannel.read(byteBuffer) == -1){
                socketChannel.close();
            }else {
                byteBuffer.flip();
                String msg = Charset.forName(localCharset).newDecoder().decode(byteBuffer).toString();
                String[] requestMsg = msg.split("\r\n");
                for (String s : requestMsg){
                    System.out.println(s);
                    if (s.isEmpty()){
                        break;
                    }
                }
                System.out.println("---------------------------------");
                //首行信息
                String[] firstLine = msg.split(" ");
                System.out.println();
                System.out.println("Method: " + firstLine[0]);
                System.out.println("Url: " + firstLine[1]);
                System.out.println("Http Version: " + firstLine[2]);
                System.out.println();

                //返回客户端
                StringBuilder sendString = new StringBuilder();
                sendString.append("HTTP/1/1 200 OK\r\n");//必须
                sendString.append("Content-Type:text/html;charset=" +localCharset + "\r\n");//必须
                sendString.append("\r\n");//必须
                sendString.append("<html><head><title>显示报文</title></head><body>接收到请求报文是：<br/>");
                for (String s : requestMsg){
                    sendString.append(s + "<br/>");
                }
                sendString.append("</body></html>");
                byteBuffer = ByteBuffer.wrap(sendString.toString().getBytes(localCharset));
                socketChannel.write(byteBuffer);
                socketChannel.close();

            }

        }

        @Override
        public void run() {
            try{
                if (key.isAcceptable()){
                    handleAccept();
                }
                if (key.isReadable()){
                    handleRead();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
