package cn.buqixiaomi.demo.jdk8.thread;

import buqixiaomi.learn.java8.base.OuterClass;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-26 15:48
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        int a = 1;
       Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("werwerw");
//                Thread.yield();
//                    Thread.sleep(10000);
                System.out.println("dsfsdfsdfsdf");
            }
        });
        thread.start();
        Thread.yield();

//        Thread.sleep(500);
         System.out.println(thread.getState());
//         thread.interrupt();
//        thread.resume();
        System.out.println("333333333333");
//        thread.notifyAll();
        /*一个正常的线程只能在启动一次*/
    }
}
