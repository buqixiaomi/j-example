package cn.buqixiaomi.demo.jdk8.socket.nioSocket;

import java.io.BufferedReader;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * selector 处理器
 */
public class SelectorHandler {
    private  int bufferSiz = 1024;
    private String charset = "UTF-8";

    public SelectorHandler() {
    }

    public SelectorHandler(int bufferSiz) {
        this(bufferSiz,null);
    }

    public SelectorHandler(String charset) {
        this(-1,charset);
    }

    public SelectorHandler(int bufferSiz, String charset) {
        if (bufferSiz >0){
            this.bufferSiz = bufferSiz;
        }
        if (charset != null){
            this.charset = charset;
        }
    }

    public void handleAccept(SelectionKey key) throws Exception{
        SocketChannel socketChannel = ((ServerSocketChannel)key.channel()).accept();
        System.out.println("客户端连接");
        socketChannel.configureBlocking(false);
        SelectionKey selectionKey = socketChannel.register(key.selector(),SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        selectionKey.attach(ByteBuffer.allocate(bufferSiz));
    }

    public void handleRead(SelectionKey key) throws Exception{
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer in = (ByteBuffer) key.attachment();
        if (socketChannel.read(in) > 0){
            String receivedString = Charset.forName(charset).newDecoder().decode((ByteBuffer) in.flip()).toString();
            System.out.println("新消息："+receivedString);
        }
    }

    public void handleWrite(SelectionKey key,ByteBuffer byteBuffer) throws Exception{
        SocketChannel socketChannel = (SocketChannel) key.channel();
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        byteBuffer.compact();
    }


}
