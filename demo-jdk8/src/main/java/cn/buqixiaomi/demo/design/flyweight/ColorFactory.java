package cn.buqixiaomi.demo.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : shengkai.li
 * @create :  2019-03-19  10:29
 * @description : 享元工程
 */
public class ColorFactory {

    private static Map<String,AbstractColor> colorMap = new HashMap<>();

    public static AbstractColor getColor(String colorCode){
        AbstractColor color = null;
        if (colorMap.containsKey(colorCode) ){
            color = colorMap.get(colorCode);
        }else {
            color = new Color(colorCode);
            colorMap.put(colorCode,color);
        }
        return color;
    }
}
