package cn.buqixiaomi.demo.jdk8.base;




import cn.buqixiaomi.demo.jdk8.TestBean;

import java.util.ArrayList;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-20 15:22
 */
public class CloneTest {

    public static void main(String[] args) throws Exception{
        TestBean testBean = new TestBean();
        testBean.setId(1);
        testBean.setName("2332");
        testBean.setList(new ArrayList<>());

        TestBean testBean1 = (TestBean)testBean.clone();

        System.out.println(testBean);
        System.out.println(testBean1);
        testBean.setName("dfgdfgdfg");
        testBean.setId(23);
        testBean.getList().add("sdfsdf");
        System.out.println(testBean);
        System.out.println(testBean1);
        /*浅复制，对于基本数据类型和String 复制的是值，对于其他引用类型，复制的引用*/
    }
}
