package cn.buqixiaomi.demo.design.bridge;

/**
 * @author : shengkai.li
 * @create :  2019-03-14  20:51
 * @description : 桥接模式主类,可以自由换形状和颜色
 */
public class BridgeMain {

    public static void main(String[] args) {
        IColor color = new RedColor();
        CircularGraph circularGraph = new CircularGraph(color);
        circularGraph.draw();
    }
}
