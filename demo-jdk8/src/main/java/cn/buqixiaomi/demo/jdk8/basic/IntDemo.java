package cn.buqixiaomi.demo.jdk8.basic;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-08-16 10:29
 */
public class IntDemo {

    public static void main(String[] args) {
//        initIntDemo();
        Integer x = 127;//128
        Integer y = 127;//128
        boolean b = y == x;
        System.out.println(y==x);

    }

    /**
     * 基本类型存储在栈中
     */
    public static void initIntDemo(){

        //在栈中创建了两个对象
        int a1 = 1;
        int a2 = 1;

        //在栈中创建了两个引用，1个对象，存储在栈中，发生了自动装箱
        Integer oa1 = 2;//装箱
        Integer oa2 = 2;//装箱

        //栈中创建了一个3对象，堆中创建了一个Integer对象，一个引用
        int a3 = 3;
        Integer oa3 = new Integer(3);

        //栈中创建了一个255对象，一个引用
        int a4 = 127;
        Integer oa4 = 127;//装箱

        //栈中创建了一个256对象，一个引用，堆中创建了一个256对象
        int a5 = 128;
        Integer oa5 = 128;//超出[-128-127]不能自动装箱

    }
}
