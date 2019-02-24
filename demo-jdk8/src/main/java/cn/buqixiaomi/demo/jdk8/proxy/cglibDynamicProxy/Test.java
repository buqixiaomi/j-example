package cn.buqixiaomi.demo.jdk8.proxy.cglibDynamicProxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by lsk on 2017/9/8.
 */
public class Test {
    public static void main(String[] args) {

        CglibProxy cglibProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SubjectImpl.class);
        enhancer.setCallback(cglibProxy);
        Subject subject = (Subject) enhancer.create();
        subject.request();
    }

}
