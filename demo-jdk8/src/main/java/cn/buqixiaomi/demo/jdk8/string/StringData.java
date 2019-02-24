package cn.buqixiaomi.demo.jdk8.string;

import java.lang.reflect.Field;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-09-12 11:50
 */
public class StringData {

    /**
     * static final 才会入常量池
     */
    public static final int i1 = 20;
    public static int i2 = 66;
    public static final int i3 = 3;

    public static void main(String[] args) throws InterruptedException {

        // init 过程
        String s1 = "a";
        String s2 = new String("a");
        String s0 = new String("b");
        System.out.println(s1 == s2);

        // + 号是否会入常量池,常量池会出现"cd" 吗
        String s3 = "c" + "d";

        // new + 呢
        String s4 = new String("e") + new String("f");

        //new  = + 呢
        String s5 = new String("g") + "h";

        // 常量池存储的是引用还是值,反射
        try {
            String s6 = "i";
            String s7 = new String("i");
            Field valueField = String.class.getDeclaredField("value");
            valueField.setAccessible(true);
            char[] valueChar = (char[]) valueField.get(s6);
            valueChar[0]='j';
            System.out.println(s6);
            System.out.println(s7);

            //如果地是引用，则引用的是数组址呢，还是String对象地址呢
            System.out.println(s6.hashCode());
            Field valueFieldHash = String.class.getDeclaredField("hash");
            valueFieldHash.setAccessible(true);
            valueFieldHash.set(s6,999);
            System.out.println(s6.hashCode());
            System.out.println(s7.hashCode());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //常量池存储在内存结构的哪个区域,jvisualvm，jconsole
        //100M
        byte[] bytes = new byte[1024*1024*100];
        String s8 = new String(bytes);
//                s8.intern();

        Thread.sleep(10000000);

        //常量池除了储存字符串字面量之外，还存储什么
        int i4 = i2 +i1;
        System.out.println(i4);
        int i5 = i2 + i3;
        System.out.println(i5);
    }
}
