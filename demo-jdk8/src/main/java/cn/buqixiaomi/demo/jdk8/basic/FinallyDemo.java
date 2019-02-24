package cn.buqixiaomi.demo.jdk8.basic;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-09-05 17:44
 */
public class FinallyDemo {

    public static void main(String[] args) {
        /**
         * 输出：
         * exec test
         * exc finally
         * test
         * 执行顺序，try ->return 逻辑(将返回值存储在临时区域中) ->finaly ->return
         * 如果finally 中包含return语句，则会覆盖临时区域中的返回值
         */
        System.out.println(finnalReturn());
    }

    private static String finnalReturn() {

        String s;
        try {
            s = test();
            return s;
        } finally {
            s = "finnal";
            System.out.println("exc finally");
//            return "finally";
        }
    }

    private static String test() {
        System.out.println("exec test");
        return "test";
    }
}
