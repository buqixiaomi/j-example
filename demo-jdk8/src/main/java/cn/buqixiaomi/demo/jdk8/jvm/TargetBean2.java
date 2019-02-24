package cn.buqixiaomi.demo.jdk8.jvm;

import java.io.Serializable;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-09-11 16:17
 */
public class TargetBean2 implements Serializable {
    private static final byte[] V =  new byte[409600000];
    private static final String A = new String(V);

    private String name;

    private String name2;
    private String name4;
    private String name6;


    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName6() {
        return name6;
    }

    public void setName6(String name6) {
        this.name6 = name6;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
