package cn.buqixiaomi.demo.jdk8.basic;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-08-29 18:05
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println(finallyReturnTest());
    }

    private static int finallyReturnTest() {
        int r = 5;
        try {
            int s =  1/0;
        } catch (Exception e) {
            e.printStackTrace();
            r= 6;
        } finally {
            r=7;
        }
        return r;
    }
}
