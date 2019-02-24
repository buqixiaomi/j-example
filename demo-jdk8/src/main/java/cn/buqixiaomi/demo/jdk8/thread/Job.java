package cn.buqixiaomi.demo.jdk8.thread;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-30 11:16
 */
public class Job implements Runnable{

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue){
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        printQueue.printJob(new Object());
    }
}
