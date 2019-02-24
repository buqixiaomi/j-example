package cn.buqixiaomi.demo.jdk8.base;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-19 14:46
 */
public class OuterClass {

    private String name;

    public OuterClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    class InnerClass {
//        private String name;
//
//        public InnerClass(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }

        public void testName(){
            System.out.println(name);
            System.out.println(OuterClass.this.name);
        }
    }

    public static void main(String[] args) {
        new OuterClass("out").new InnerClass().testName();
    }
}
