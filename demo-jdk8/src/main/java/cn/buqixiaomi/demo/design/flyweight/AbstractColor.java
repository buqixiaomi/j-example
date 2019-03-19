package cn.buqixiaomi.demo.design.flyweight;

/**
 * @author : shengkai.li
 * @create :  2019-03-19  10:17
 * @description : 抽象享元角色 颜色类
 */
public abstract class AbstractColor {

    /**
     * 内部状态
     */
    private String rgb;

    /**
     * 外部状态状态
     */
    protected final String clolorCode;


    public AbstractColor(String clolorCode) {
        this.clolorCode = clolorCode;
    }

    public abstract void coloring();

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }
}
