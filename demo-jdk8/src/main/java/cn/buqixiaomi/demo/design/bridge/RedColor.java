package cn.buqixiaomi.demo.design.bridge;

/**
 * @author : shengkai.li
 * @create :  2019-03-14  20:47
 * @description :实现化角色具体实现类
 */
public class RedColor implements IColor {

    @Override
    public void put() {
        System.out.println("涂上红色");
    }
}
