package cn.buqixiaomi.demo.jdk8.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-27 14:31
 */
public class LockTest {

    public synchronized void go(){
        System.out.println("2324234");
    }

    class SubTest extends LockTest{
        @Override
        public synchronized void go(){
            super.go();
        }
    }

    public static void main(String[] args) {
//        Lock lock1 = new ReentrantLock();
//        Lock lock2 = new ReentrantLock();
//        User user1 = new User(lock1,lock2);
//        User user2 = new User(lock2,lock1);
//
//        new Thread(user1).start();
//        new Thread(user2).start();
        LockTest lockTest = new LockTest();
        lockTest.go();
//        synchronized (lockTest){
//            synchronized (lockTest){
//                System.out.println("23424");
//            }
//        }

    }

    static class User implements Runnable{
        private Lock lock1;
        private Lock lock2;

        public User(Lock lock1,Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock1;
        }

        @Override
        public void run() {
            lock1.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock2.lock();
            System.out.println("222");
            lock2.unlock();
            lock1.unlock();
        }
    }
}
