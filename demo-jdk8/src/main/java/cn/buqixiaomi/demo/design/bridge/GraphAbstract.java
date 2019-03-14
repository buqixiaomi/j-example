package cn.buqixiaomi.demo.design.bridge;

/**
 * @author : shengkai.li
 * @create :  2019-03-14  20:42
 * @description :作为抽象或角色，主要持有实现化角色，定义行为
 */
public abstract class GraphAbstract {

    private IColor color;

    public GraphAbstract(IColor color) {
        this.color = color;
    }

    protected void draw(){
        color.put();
    }
}
