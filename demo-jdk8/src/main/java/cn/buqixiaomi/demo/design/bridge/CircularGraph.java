package cn.buqixiaomi.demo.design.bridge;

/**
 * @author : shengkai.li
 * @create :  2019-03-14  20:49
 * @description : 抽象化角色实例 圆形
 */
public class CircularGraph extends GraphAbstract {

    public CircularGraph(IColor color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("画圆圈");
        super.draw();
    }
}
