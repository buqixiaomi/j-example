package cn.buqixiaomi.demo.jdk8.proxy.jdkDynamicProxy;

/**
 * Created by lsk on 2017/9/8.
 */
public class SubjectImpl implements Subject {
    @Override
    public void request() {
        System.out.println("这是被代理对象方法");
    }
}
