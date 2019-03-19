package cn.buqixiaomi.demo.design.flyweight;

/**
 * @author : shengkai.li
 * @create :  2019-03-19  10:27
 * @description : 具体享元角色
 */
public class Color extends AbstractColor {

    public Color(String clolorCode) {
        super(clolorCode);
    }

    @Override
    public void coloring() {

        System.out.printf("上色:" + super.clolorCode);

    }
}
