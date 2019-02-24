package cn.buqixiaomi.demo.jdk8.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 * 使用 jvisualvm.exe  抽样内存，64位JVM8字节
 * @author lishengkai
 * @date 2018-09-12 15:54
 */
public class EmptyDemo {
    public static void main(String[] args) throws InterruptedException {
        List<EmptyDemo> list = new ArrayList<>();
        for (int i =0;i<100;i++){
            list.add(new EmptyDemo());
        }
        Thread.sleep(10000000);
    }
}
