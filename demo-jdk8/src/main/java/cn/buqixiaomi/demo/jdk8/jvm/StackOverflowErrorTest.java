package cn.buqixiaomi.demo.jdk8.jvm;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-17 10:47
 */
public class StackOverflowErrorTest {

    public static void main(String[] args) {
        new StackOverflowErrorTest().test();
    }

    private void test(){
        test();
    }
}
