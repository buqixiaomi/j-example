package cn.buqixiaomi.demo.jdk8.proxy.jdkDynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by lsk on 2017/9/8.
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        MyInvocatonHander myInvocatonHander = new MyInvocatonHander(subject);
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),myInvocatonHander);
        subjectProxy.request();
    }

}
