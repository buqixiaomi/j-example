package cn.buqixiaomi.demo.jdk8.proxy.staticProxy;

/**
 * Created by lsk on 2017/9/8.
 */
public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("这里是被代理对象的方法");
    }
}
