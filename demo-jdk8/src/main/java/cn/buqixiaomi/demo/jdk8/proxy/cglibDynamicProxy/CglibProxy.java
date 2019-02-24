package cn.buqixiaomi.demo.jdk8.proxy.cglibDynamicProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lsk on 2017/9/8.
 */
public class CglibProxy implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("request".equals(method.getName())){
            preRequest();
            Object result = methodProxy.invokeSuper(o,args);
            postRequest();
            return result;
        }else {
            Object result = methodProxy.invokeSuper(o,args);
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
