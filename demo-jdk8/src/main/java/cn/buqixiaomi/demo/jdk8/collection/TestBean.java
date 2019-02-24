package cn.buqixiaomi.demo.jdk8.collection;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-18 15:20
 */
public class TestBean {


    public TestBean(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
