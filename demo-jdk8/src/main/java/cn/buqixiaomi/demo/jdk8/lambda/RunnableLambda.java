package cn.buqixiaomi.demo.jdk8.lambda;

/**
 * 线程lambda 写法
 */
public class RunnableLambda {

    public static void main(String[] args) {
        System.out.println("主线程");
        new Thread(() ->{
            System.out.println("新线程");
        }).start();
    }
}
