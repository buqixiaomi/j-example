package cn.buqixiaomi.demo.jdk8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-08-01 10:41
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i= 1;i<Integer.MAX_VALUE;i++){
            Thread thread = new Thread(new TestTread(i));
            executorService.execute(thread);
        }
    }


    public static class TestTread implements Runnable{

        private Integer number;

        public TestTread(Integer number) {
            this.number = number;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        @Override
        public void run() {
            System.out.println("线程"+number + "开始执行");
            try {
                Thread.sleep(600000);
                System.out.println("线程"+number + "睡了，600s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
