package cn.buqixiaomi.demo.jdk8;

import java.util.List;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-20 15:26
 */
public class TestBean implements Cloneable{

    private int id;
    private String name;
    private List<String> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
