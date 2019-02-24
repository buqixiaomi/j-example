package cn.buqixiaomi.demo.jdk8.proxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lsk on 2017/9/8.
 */
public class MyInvocatonHander implements InvocationHandler {

    Object proxied;

    private MyInvocatonHander() {
    }

    public MyInvocatonHander(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("request".equals(method.getName())){
            preRequest();
            Object result = method.invoke(proxied,args);
            postRequest();
            return result;
        }else {
            Object result = method.invoke(proxied,args);
            return result;
        }
    }

    private void preRequest(){
        System.out.println("Pre Request.");
    }
    private void postRequest(){
        System.out.println("Post Request");
    }
}
