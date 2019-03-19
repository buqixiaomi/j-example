package cn.buqixiaomi.demo.design.flyweight;

/**
 * @author : shengkai.li
 * @create :  2019-03-19  10:35
 * @description : 客户端类
 */
public class FlyweightMain {

    public static void main(String[] args) {
        AbstractColor color1 = ColorFactory.getColor("red");
        AbstractColor color2 = ColorFactory.getColor("red");

        System.out.println(color1.hashCode());
        System.out.println(color2.hashCode());
    }
}
